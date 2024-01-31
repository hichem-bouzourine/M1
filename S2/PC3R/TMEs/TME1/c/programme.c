#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>

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

pthread_mutex_t mutTapis = PTHREAD_MUTEX_INITIALIZER;

int enfilerTapis(struct tapis *t, struct paquet *p) {
    pthread_mutex_lock(&mutTapis);
    p->suiv = NULL;
    if (t->filePaquets == NULL) {
        t->tete = p;
        t->filePaquets = p;
    } else {
        t->filePaquets->suiv = p;
        t->filePaquets = p;
    }
    t->count++;
    pthread_mutex_unlock(&mutTapis);
    return 1;
}

struct paquet *defilerTapis(struct tapis *t) {
    pthread_mutex_lock(&mutTapis);
    if (t->tete == NULL) {
        pthread_mutex_unlock(&mutTapis);
        return NULL;
    }
    struct paquet *paquet_defile = t->tete;
    t->tete = t->tete->suiv;
    if (t->tete == NULL) {
        t->filePaquets = NULL;
    }
    t->count--;
    paquet_defile->suiv = NULL;
    pthread_mutex_unlock(&mutTapis);
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
    struct tapis *t = pth->t;
    char *nom_produit = pth->nom_produit;
    int cible = pth->cible;

    int cpt = 0;
    while (cpt < cible) {
        printf("Producteur %s : %d \n", nom_produit, cpt);
        struct paquet *pq = createPaquet(nom_produit, cpt);

        while (t->count == t->maximum) // condition de bloque si on atteint le max (aide d'un collègue)
            ;

        enfilerTapis(t, pq);
        cpt++;
    }
    pthread_exit(NULL);
}

void* consommateur(void *arg) {
    struct ParametresThread *pth = (struct ParametresThread *)arg;
    struct tapis *t = pth->t;
    int id = pth->id;
    int *cptRef = pth->cptRef;
    while (*cptRef > 0) {
        struct paquet *pq = defilerTapis(t);
        if (pq != NULL) {
            printf("C%d mange %s %d \n", id, pq->name, pq->num);
            (*cptRef)--;
        }
    }
    pthread_exit(NULL);
}

int main() {
    int cible = 4;
    int cpt = cible * NB_PRODUCTEURS;
    int maximum = 8;
    void *status;
    struct tapis *t = createTapis(maximum);

    pthread_t prods[NB_PRODUCTEURS];
    for (int i = 0; i < NB_PRODUCTEURS; i++) {
        char *idProduct = (i == 0) ? "Pomme" : "Banane";
        printf("Id Product : %s \n", idProduct);
        struct ParametresThread *paramProducteur = allouerParametres(t, idProduct, cible, -1, NULL);
        pthread_create(&prods[i], NULL, producteur, (void *)paramProducteur);
    }

    pthread_t consomateurs[NB_CONSOMMATEURS];
    for (int i = 0; i < NB_CONSOMMATEURS; i++) {
        struct ParametresThread *paramConsommateur = allouerParametres(t, NULL, cible, i, &cpt);
        pthread_create(&consomateurs[i], NULL, consommateur, (void *)paramConsommateur);
    }

    for (int i = 0; i < NB_PRODUCTEURS; i++) {
        pthread_join(prods[i], &status);
    }

    for (int i = 0; i < NB_CONSOMMATEURS; i++) {
        pthread_join(consomateurs[i], &status);
    }

    return 0;
}
