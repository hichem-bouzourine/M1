// code inspiré d'un collègue
chan personne_channel = [10] of { Personne };  // canal pour passer une Personne entre modules
chan prod_channel = [1] of { Personne };      // canal pour passer une Personne du producteurs au gestionnaire
chan gestionnaire_channel = [1] of { Personne }; // canal pour passer une Personne du gestionnaire au ouvrier ou collecteur
chan collecteur_channel = [2] of { Personne }; // canal pour passer une Personne du collecteur au collecteur
chan fin_temps_channel = [1] of { byte };  // canal pour signaler fin du temps
chan ouvrier_channel = [10] of { Personne };  // canal pour signaler fin du temps

chan lecture_req_channel = [(2) -> (byte, chan)];
chan lecture_res_channel = [2] of { byte, Personne };

active proctype Lecteur() {
    byte num_ligne;
    chan res_channel;
    Personne ligne;
    do
    :: true ->
        (num_ligne, res_channel) = ?lecture_req_channel;
        res_channel!ligne;
    od;
}

active proctype Gestionnaire() {
    Personne personne;
    byte statut;
    do
    :: true ->
        if 
            ::  gestionnaire_channel?personne -> 
                statut = personne.Sexe[0];
                switch
                :: statut == 'R' -> ouvrier_channel[random(10)]!personne;
                :: statut == 'C' -> collecteur_channel!personne;
                :: true -> prod_channel!personne;
            :: prod_channel?personne  ->
                statut = personne.Sexe[0];
                ouvrier_channel[random(10)]!personne;
        fi;
    od;
}

proctype Ouvrier(chan c_ouvrier) {
    Personne personne;
    byte statut;
    do
    :: true ->
        personne = ?c_ouvrier;
        statut = personne.Sexe[0];
        switch
        :: statut == 'V' -> gestionnaire_channel!personne;
        :: statut == 'R' -> gestionnaire_channel!personne;
        :: statut == 'C' -> collecteur_channel!personne;
        :: else -> skip;
        od;
    od;
}

active proctype Producteur() {
    byte num_ligne;
    Personne ligne;
    chan prod_channel;
    do
    :: true ->
        num_ligne = 1 + (49 % 8); // Générer un numéro de ligne aléatoire
        lecture_req_channel!(num_ligne, prod_channel);
        prod_channel!personne -> skip;
    od;
}

active proctype Collecteur() {
    Personne personne;
    int cpt = 0; 
    int n; 
    do
    :: true ->
        personne = ?collecteur_channel[0];
        printf("%s %s %d, Sexe: %s\n", personne.Nom, personne.Prenom, personne.Age, personne.Sexe);
        cpt++; 
    :: true ->
        if 
            :: fin_temps_channel? n -> fin_temps_channel? n;
            :: else -> skip;
    od;
}

init {
    run Lecteur();
    run Gestionnaire();
    run Ouvrier(ouvrier_channel);
    run Producteur();
    run Collecteur();
}
