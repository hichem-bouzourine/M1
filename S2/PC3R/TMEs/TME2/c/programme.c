// il y a quelques morceaux de codes écrit à l'aide d'un collègue
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>
#include "fthread.h"

#define NB_PRODUCTEURS 5
#define NB_CONSOMMATEURS 4

struct paquet {
    char *name;
    int num;
    struct paquet *suiv;
};
struct tapis {
    struct paquet *tete;
    struct paquet *filePaquets;
    int count;
    int maximum;
};

struct tapis * t_prod, *t_cons;
ft_scheduler_t scheduler_prod,scheduler_cons;

int enfilerTapis(struct tapis *t, struct paquet *p) {
    
    p->suiv = NULL;
    if (t->filePaquets == NULL) {
        t->tete = p;
        t->filePaquets = p;
    } else {
        t->filePaquets->suiv = p;
        t->filePaquets = p;
    }
    t->count++;
    return 1;
}

struct paquet *defilerTapis(struct tapis *t) {
    if (t->tete == NULL) {
        return NULL;
    }

    struct paquet *paquet_defile = t->tete;
    t->tete = t->tete->suiv;
    
    if (t->tete == NULL) {
        t->filePaquets = NULL;
    }
    
    t->count--;
    paquet_defile->suiv = NULL;
    return paquet_defile;
}

struct paquet *createPaquet(char *name, int num) {
    struct paquet *pq = malloc(sizeof(struct paquet));
    if (pq == NULL) {
        perror("ERREUR D'ALLOCATION");
        exit(EXIT_FAILURE);
    }
    pq->name = name;
    pq->num = num;
    pq->suiv = NULL;
    return pq;
}

struct tapis *createTapis(int maximum) {
    struct tapis *t = malloc(sizeof(struct tapis));
    if (t == NULL) {
        perror("ERREUR D'ALLOCATION");
        exit(EXIT_FAILURE);
    }
    t->maximum = maximum;
    t->count = 0;
    t->tete = NULL;
    t->filePaquets = NULL;
    return t;
}

struct ParametresThread {
    struct tapis *t;
    char *nom_produit;
    int cible;
    int id; 
    int *cptRef; 
};
ft_event_t tapis_prod_non_plein;
ft_event_t tapis_prod_non_vide;
ft_event_t tapis_cons_non_plein;
ft_event_t tapis_cons_non_vide;


struct ParametresThread *allouerParametres(struct tapis *t, char *nom_produit, int cible, int id, int *cptRef) {
    struct ParametresThread *pth = malloc(sizeof(struct ParametresThread));
    if (pth == NULL) {
        perror("ERREUR D'ALLOCATION");
        exit(EXIT_FAILURE);
    }
    pth->t = t;
    pth->nom_produit = nom_produit;
    pth->cible = cible;
    pth->id = id;
    pth->cptRef = cptRef;
    return pth;
}

void* producteur(void *arg) {
    struct ParametresThread *pth = (struct ParametresThread *)arg;
    char *nom_produit = pth->nom_produit;
    int cible = pth->cible;

    int cpt = 0;
    while(cpt <cible){
        printf("Producteur %s : %d \n",nom_produit,cpt);
        struct paquet * pq = createPaquet(nom_produit,cpt); 
        if(t_prod->count == t_prod->maximum)
            ft_thread_await(tapis_prod_non_plein);
        enfilerTapis(t_prod,pq); 
        cpt ++ ;
        tapis_prod_non_vide=ft_event_create(scheduler_prod);
        ft_thread_cooperate();
    }
}

void* consommateur(void *arg) {
    struct ParametresThread *pth = (struct ParametresThread *)arg;
    struct tapis *t = pth->t;
    int id = pth->id;
    int *cptRef = pth->cptRef;
    while(*cptRef>0){
        // vérifier que le tapis n'est pas vide 
        if(t_cons->count ==0 )
            ft_thread_await(tapis_cons_non_vide);
        
        struct paquet *pq = defilerTapis(t_cons); 
        if(pq!=NULL){
            printf("C%d mange %s %d \n", id,pq->name,pq->num);
            free(pq);
            *cptRef-=1; 
        }
        // signaler au messager que le tapis n'est pas pleins 
        tapis_cons_non_plein=ft_event_create(scheduler_cons);
        ft_thread_cooperate();
    }
}

void* messagers(void *arg) {
    // vide et n'est attaché a aucun ordonnanceur
    struct ParametresThread *param = (struct ParametresThread *)arg;
    int *cptRef = param->cptRef;
    while(*cptRef>0){
        // vérifier que le tapis n'est pas vide 
        ft_thread_link(scheduler_prod);
        while(t_prod->count == 0)
            ft_thread_await(tapis_prod_non_vide);
        struct paquet* pq = defilerTapis(t_prod);
        if(!pq){
            // dire aux autres threads que le tapis de production n'est pas plein 
            printf("Messager a recupere le paquet %s %d \n",pq->name,pq->num);
            tapis_prod_non_plein=ft_event_create(scheduler_prod);
            // se détacher du producteur
            ft_thread_unlink();

            // s'attacher au consoomatteur 
            ft_thread_link(scheduler_cons);
            // si le tapis de consomation est plein attendre qu'il se vide 
            while(t_cons->count == t_cons->maximum)
                ft_thread_await(tapis_cons_non_plein);
            enfilerTapis(t_cons,pq);
            // signaler aux consommateur que le tapis n'est pas vide 
            tapis_cons_non_vide=ft_event_create(scheduler_cons);
            ft_thread_unlink();
        }
    }
    ft_exit();
}

int main() {
    ft_scheduler_t s = ft_scheduler_create();
    ft_scheduler_start(s);

    int cible = 4;
    int cpt = cible * NB_PRODUCTEURS;
    int maximum = 8;
    void *status;
    struct tapis *t = createTapis(maximum);

    ft_thread_t prods[NB_PRODUCTEURS];
    for (int i = 0; i < NB_PRODUCTEURS; i++) {
        char *idProduct = (i == 0) ? "Pomme" : "Orange";
        printf("Id Product : %s \n", idProduct);
        struct ParametresThread *paramProducteur = allouerParametres(t, idProduct, cible, -1, NULL);
        ft_thread_create(s, producteur, NULL, (void *)paramProducteur);
    }

    ft_thread_t consomateurs[NB_CONSOMMATEURS];
    for (int i = 0; i < NB_CONSOMMATEURS; i++) {
        struct ParametresThread *paramConsommateur = allouerParametres(t, NULL, cible, i, &cpt);
        ft_thread_create(s, consommateur, NULL, (void *)paramConsommateur);
    }

    for (int i = 0; i < NB_PRODUCTEURS; i++) {
        // pthread_join(prods[i], &status);
        // fair thread
        ft_thread_join(prods[i]);
    }

    for (int i = 0; i < NB_CONSOMMATEURS; i++) {
        ft_thread_join(consomateurs[i]);
    }

    ft_scheduler_stop(s);
    return 0;
}
