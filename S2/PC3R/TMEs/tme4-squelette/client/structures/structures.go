package structures

type Personne struct {
	Nom    string
	Prenom string
	Age    int
	Sexe   string
}

type ChanDeMessage struct {
	canal_de_retour     chan string
	num_ligne int
}