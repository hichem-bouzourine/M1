package main

import (
	"fmt"
	"math/rand"
	"os"
	"regexp"
	"strconv"
	"time"
	"strings"
	"net"
	"log"
	"bufio"

	st "tme4-squelette/client/structures" 
	tv "tme4-squelette/client/travaux"    
)

var ADRESSE string = "localhost"                           // adresse de base pour la Partie 2
var FICHIER_SOURCE string = "./conseillers-municipaux.txt" // fichier dans lequel piocher des personnes
var TAILLE_SOURCE int = 450000                             // inferieure au nombre de lignes du fichier, pour prendre une ligne au hasard
var TAILLE_G int = 5                                       // taille du tampon des gestionnaires
var NB_G int = 2                                           // nombre de gestionnaires
var NB_P int = 2                                           // nombre de producteurs
var NB_O int = 4                                           // nombre d'ouvriers
var NB_PD int = 2                                          // nombre de producteurs distants pour la Partie 2

var pers_vide = st.Personne{Nom: "", Prenom: "", Age: 0, Sexe: "M"} // une personne vide

// paquet de personne, sur lequel on peut travailler, implemente l'interface personne_int
type personne_emp struct {
	Personne     st.Personne
	num_ligne int
	ligne        string
	Status       string
	aFaire        []func(p st.Personne) st.Personne // tableau afaire vide de fonctions des personnes dans les personnes
	canal_de_lecture chan st.ChanDeMessage
}

type message_proxy struct {
	id       int
	method   string
	canal_de_resultat chan string
}

type personne_dist struct {
	id    int
	proxy chan message_proxy
}

// interface des personnes manipulees par les ouvriers, les
type personne_int interface {
	initialise()          // appelle sur une personne vide de statut V, remplit les champs de la personne et passe son statut à R
	travaille()           // appelle sur une personne de statut R, travaille une fois sur la personne et passe son statut à C s'il n'y a plus de travail a faire
	vers_string() string  // convertit la personne en string
	donne_statut() string // renvoie V, R ou C
}

// fabrique une personne à partir d'une ligne du fichier des conseillers municipaux
// à changer si un autre fichier est utilisé
func personne_de_ligne(l string) st.Personne {
	separateur := regexp.MustCompile("\u0009") // oui, les donnees sont separees par des tabulations ... merci la Republique Francaise
	separation := separateur.Split(l, -1)
	naiss, _ := time.Parse("2/1/2006", separation[7])
	a1, _, _ := time.Now().Date()
	a2, _, _ := naiss.Date()
	agec := a1 - a2
	return st.Personne{Nom: separation[4], Prenom: separation[5], Sexe: separation[6], Age: agec}
}

func constructeur_personne(numero_ligne int, c_lecteur chan st.ChanDeMessage) personne_emp {
	pq := personne_emp{
		Personne:     st.Personne{Nom: "", Prenom: "", Sexe: "M", Age: 0},
		num_ligne: numero_ligne,
		ligne:        "",
		Status:       "V",
		aFaire:        []func(p st.Personne) st.Personne{},
		canal_de_lecture: c_lecteur,
	}
	return pq
}

// *** METHODES DE L'INTERFACE personne_int POUR LES PAQUETS DE PERSONNES ***
// je montionne que dans la salle de TME un collègue m'a aidé à avancer dans ce code, mais pas de copier-coller 
func (p *personne_emp) initialise() {
	c := make(chan string)
	message_a_envoyer_au_lecteur := st.ChanDeMessage{num_ligne: p.num_ligne, canal_de_retour: c}
	p.canal_de_lecture <- message_a_envoyer_au_lecteur
	ligne := (<-c)
	numero_ligne := p.num_ligne
	p.Personne = personne_de_ligne(ligne)
	nombre_taches := rand.Intn(5)
	if nombre_taches == 0 {
		nombre_taches = 1
	}
	taches := []func(p st.Personne) st.Personne{} // tab de func personnes dans les personnes
	for i := 1; i <= 1; i++ {
		taches = append(taches, tv.UnTravail())
	}
	p.ligne = ligne
	p.num_ligne = numero_ligne
	p.aFaire = taches
	p.Status = "R"
}

func (p *personne_emp) travaille() {
	tache := p.aFaire[0]
	var rest_taches []func(p st.Personne) st.Personne
	if len(p.aFaire) <= 1 {
		rest_taches = []func(p st.Personne) st.Personne{}
	} else {
		rest_taches = p.aFaire[1:]
	}
	tache(p.Personne)
	p.aFaire = rest_taches
	if len(rest_taches) == 0 {
		p.Status = "C"
	}

}

func (p *personne_emp) vers_string() string {
	fs := fmt.Sprintf("Civ : %s\t", p.Personne.Sexe)

	fs += fmt.Sprintf(" %s %s %d, Statut : %s\n", p.Personne.Nom, p.Personne.Prenom, p.Personne.Age, p.Status)
	return fs
}

func (p *personne_emp) donne_statut() string {
	return p.Status
}

// *** METHODES DE L'INTERFACE personne_int POUR LES PAQUETS DE PERSONNES DISTANTES (PARTIE 2) ***
// ces méthodes doivent appeler le proxy (aucun calcul direct)

func (p personne_dist) initialise() {
	retour := make(chan string)
	message := message_proxy{id: p.id, method: "initialise", canal_de_resultat: retour}
	p.proxy <- message
	<-retour
}

func (p personne_dist) travaille() {
	retour := make(chan string)
	message := message_proxy{id: p.id, method: "travaille", canal_de_resultat: retour}
	p.proxy <- message
	<-retour
}

func (p personne_dist) vers_string() string {
	retour := make(chan string)
	message := message_proxy{id: p.id, method: "vers_string", canal_de_resultat: retour}
	p.proxy <- message
	return <-retour
}

func (p personne_dist) donne_statut() string {
	retour := make(chan string)
	message := message_proxy{id: p.id, method: "donne_statut", canal_de_resultat: retour}
	p.proxy <- message
	return <-retour
}

// *** CODE DES GOROUTINES DU SYSTEME ***

// Partie 2: contacté par les méthodes de personne_dist, le proxy appelle la méthode à travers le réseau et récupère le résultat
// il doit utiliser une connection TCP sur le port donné en ligne de commande

// documentation package `net` https://reintech.io/blog/introduction-to-gos-net-package-networking-and-sockets
func proxy(port int, chan_proxy chan message_proxy) {
	address := ADRESSE + ":" + strconv.Itoa(port)
	conn, _ := net.Dial("tcp", address)
	for {
		message := <-chan_proxy
		req := strconv.Itoa(message.id) + "," + message.method + "\n"
		fmt.Fprintf(conn, fmt.Sprintf(req))

		res, _ := bufio.NewReader(conn).ReadString('\n')
		reponse := strings.TrimSuffix(res, "\n")
		fmt.Println("Response recieved: " + reponse)
		message.canal_de_resultat <- reponse
	}
}

// Partie 1 : contacté par la méthode initialise() de personne_emp, récupère une ligne donnée dans le fichier source
func lecteur(c chan st.ChanDeMessage) {
	for {
		message_recu := (<-c)
		file, err := os.Open("./client/conseillers-municipaux.txt")
		if err != nil {
			log.Fatal(err)
		}
		defer file.Close()
		sc := bufio.NewScanner(file)
		// ignorer les deux premières lignes
		sc.Scan()
		sc.Scan()

		cpt := 1
		for sc.Scan() {
			if cpt == message_recu.num_ligne {
				message_recu.canal_de_retour <- sc.Text()
				break
			}
			cpt++
		}
	}

}

// Partie 1: récupèrent des personne_int depuis les gestionnaires, font une opération dépendant de donne_statut()
// Si le statut est V, ils initialise le paquet de personne puis le repasse aux gestionnaires
// Si le statut est R, ils travaille une fois sur le paquet puis le repasse aux gestionnaires
// Si le statut est C, ils passent le paquet au collecteur
func ouvrier(id int, c_ouvrier chan personne_int, c_gestionnaire chan personne_int, c_collecteur chan personne_int) {
	for {
		fmt.Println("Ouvrier ", id, " attend ...")
		pers := (<-c_ouvrier)
		statut := pers.donne_statut()
		fmt.Println("Ouvrier ", id, "  a recu une personne ... ", statut)
		switch statut {
		case "V":
			pers.initialise()
			fmt.Println("Personne initialisé ")
			c_gestionnaire <- pers
		case "R":
			pers.travaille()
			fmt.Println("Personne a travaillé ")
			c_gestionnaire <- pers
			fmt.Println("Personne qui a travaillé a été envoyé au gestionnaire ")
		case "C":
			fmt.Println("Ouvrier ", id, " contact le gestionnaire : ")
			c_collecteur <- pers
		}
	}
}

// Partie 1: les producteurs cree des personne_int implementees par des personne_emp initialement vides,
// de statut V mais contenant un numéro de ligne (pour etre initialisee depuis le fichier texte)
// la personne est passée aux gestionnaires
func producteur(c_prod chan personne_int, c_lecture chan st.ChanDeMessage) {
	for {
		numero_ligne := rand.Intn(TAILLE_SOURCE)
		if numero_ligne == 0 {
			numero_ligne = 1
		}
		pers := constructeur_personne(numero_ligne, c_lecture)
		fmt.Println("Producteur envoi des paquet")
		c_prod <- personne_int(&pers)
	}
}

// Partie 2: les producteurs distants cree des personne_int implementees par des personne_dist qui contiennent un identifiant unique
// utilisé pour retrouver l'object sur le serveur
// la creation sur le client d'une personne_dist doit declencher la creation sur le serveur d'une "vraie" personne, initialement vide, de statut V

func producteur_distant(c_gestionnaire chan personne_int, req_chan chan message_proxy) {
	cpt := 0
	for {
		id := cpt
		new_pers := personne_dist{id: id, proxy: req_chan}
		fmt.Println("A creer au serveur", id)
		canal_de_resultat := make(chan string)
		req_chan <- message_proxy{id: id, method: "creer", canal_de_resultat: canal_de_resultat}
		
		<-canal_de_resultat
		
		c_gestionnaire <- new_pers
		cpt++
	}
}

// Partie 1: les gestionnaires recoivent des personne_int des producteurs et des ouvriers et maintiennent chacun une file de personne_int
// ils les passent aux ouvriers quand ils sont disponibles
// ATTENTION: la famine des ouvriers doit être évitée: si les producteurs inondent les gestionnaires de paquets, les ouvrier ne pourront
// plus rendre les paquets surlesquels ils travaillent pour en prendre des autres
// code inspiré par "Tabellout"
func gestionnaire(c_gestionnaire chan personne_int, c_ouvrier chan personne_int, c_prod chan personne_int) {
	file := make([]personne_int, 0)
	for {
		// si la file est remplit renvoyer le premier paquet vers l'ouvrier
		len_file := len(file)
		fmt.Println("Dans la file il y'a : ", len_file)
		if len_file == TAILLE_G {
			elem := file[0]
			fmt.Println("Envoyer des ouvriers")
			c_ouvrier <- elem
			file = file[1:]
		} else {
			// si la file est à moitié remplit alors accepter les paquet
			// des ouvriers ainsi que les producteurs, sinon accepter que ceux des ouvriers
			if len_file <= TAILLE_G/2 {
				if len_file == 0 {
					select {
					// l'ouvrier envoie sont paquet dans c_gestionnaire
					case pers := (<-c_gestionnaire):
						file = append(file, pers)
					// le producteur envoie sont paquet dans c_gestionnaire
					case pers := (<-c_prod):
						file = append(file, pers)
					}
				} else {
					fmt.Println("Gestionnaire essaye d'envoyer vers un des ouvriers  ")
					select {
					// l'ouvrier envoie sont paquet dans c_gestionnaire
					case pers := (<-c_gestionnaire):
						file = append(file, pers)
					// le producteur envoie sont paquet dans c_gestionnaire
					case pers := (<-c_prod):
						file = append(file, pers)
					case c_ouvrier <- file[0]:
						if len_file == 1 {
							file = []personne_int{}
						} else {
							file = file[1:]
						}
					}
				}
			} else {
				fmt.Println("entrain d'attendre un signal d'un ouvrier ... ")
				select {
				case pers := (<-c_gestionnaire):
					file = append(file, pers)
				case c_ouvrier <- file[0]:
					file = file[1:]
				}
				fmt.Println("Gestionnaire a recu un signal soit par un ouvrier soit il a envoyé à l'ouvrier ")
			}
		}

	}
}

// Partie 1: le collecteur recoit des personne_int dont le statut est c, il les collecte dans un journal
// quand il recoit un signal de fin du temps, il imprime son journal.
func collecteur(c chan personne_int, c_fin chan int) {
	journal := ""
	for {
		fmt.Println("Le travaille du Collecteur commence !")
		select { // on utilise select pour écouter simultanément
		case <-c_fin:
			{
				fmt.Println(journal)
				c_fin <- 1
				break
			}
		case pers := (<-c):
			{
				fmt.Println("Collecteur a recu un message")
				journal += pers.vers_string()
			}

		}
	}
}

func main() {
	rand.Seed(time.Now().UTC().UnixNano()) // graine pour l'aleatoire
	if len(os.Args) < 3 {
		fmt.Println("Format: client <port> <millisecondes d'attente>")
		return
	}
	port, _ := strconv.Atoi(os.Args[1])   // utile pour la partie 2
	millis, _ := strconv.Atoi(os.Args[2]) // duree du timeout
	fintemps := make(chan int)

	c_lecteur := make(chan st.ChanDeMessage)
	c_gestionnaire := make(chan personne_int)
	c_collecteur := make(chan personne_int)
	c_ouvrier := make(chan personne_int)
	c_prod := make(chan personne_int)
	req_chan := make(chan message_proxy)

	// lancer les goroutines (parties 1 et 2): 1 lecteur, 1 collecteur, des producteurs, des gestionnaires, des ouvriers
	go func() { lecteur(c_lecteur) }()
	go func() { collecteur(c_collecteur, fintemps) }()
	for i := 0; i < NB_O; i++ {
		go func(k int) { ouvrier(k, c_ouvrier, c_gestionnaire, c_collecteur) }(i)
	}

	go func() {
		proxy(port, req_chan)
	}()

	for i := 0; i < NB_P; i++ {
		go func() { producteur(c_prod, c_lecteur) }()
	}
	
	for i := 0; i < 1; i++ {
		go func() { gestionnaire(c_gestionnaire, c_ouvrier, c_prod) }()
	}

	fmt.Println(port, millis)

	// lancer les goroutines (partie 2): des producteurs distants, un proxy
	time.Sleep(time.Duration(millis) * time.Millisecond)
	fintemps <- 0
	<-fintemps
}