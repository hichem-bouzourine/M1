package main

import (
	"bufio"
	"fmt"
	"math/rand"
	"net"
	"os"
	"strconv"
	"strings"

	st "tme4-squelette/client/structures"
	tr "tme4-squelette/serveur/travaux"
)

var ADRESSE = "localhost"

var pers_vide = st.Personne{Nom: "", Prenom: "", Age: 0, Sexe: "M"}
var identifiants = make(map[int]*personne_serv)

// type d'un paquet de personne stocke sur le serveur, n'implemente pas forcement personne_int (qui n'existe pas ici)
type personne_serv struct {
	Status   string
	aFaire    []func(st.Personne) st.Personne
	Personne st.Personne
}

// cree une nouvelle personne_serv, est appelé depuis le client, par le proxy, au moment ou un producteur distant
// produit une personne_dist
func creer(id int) *personne_serv {
	pers := pers_vide
	tableau_afaire := []func(st.Personne) st.Personne{}
	new_pers_serv := personne_serv{Status: "V", aFaire: tableau_afaire, Personne: pers}
	identifiants[id] = &new_pers_serv
	return &new_pers_serv
}

// Méthodes sur les personne_serv, on peut recopier des méthodes des personne_emp du client
// l'initialisation peut être fait de maniere plus simple que sur le client
// (par exemple en initialisant toujours à la meme personne plutôt qu'en lisant un fichier)
func (p *personne_serv) initialise() {
	p.Personne = st.Personne{Prenom: "Yanis", Nom: "Tabellout", Sexe: "M", Age: 21}
	n := rand.Intn(5)
	if n == 0 {
		n = 1
	}
	for i := 1; i <= n; i++ {
		p.aFaire = append(p.aFaire, tr.UnTravail())
	}
	p.Status = "R"
}

func (p *personne_serv) travaille() {
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

func (p *personne_serv) vers_string() string {
	fs := fmt.Sprintf("Personne Distante : %s\t", p.Personne.Sexe)

	fs += fmt.Sprintf(" %s %s %d, Status : %s\n", p.Personne.Nom, p.Personne.Prenom, p.Personne.Age, p.Status)
	fs += fmt.Sprintf("\n")
	return fs
}

func (p *personne_serv) donne_statut() string {
	return p.Status
}

// Goroutine qui maintient une table d'association entre identifiant et personne_serv
// il est contacté par les goroutine de gestion avec un nom de methode et un identifiant
// et il appelle la méthode correspondante de la personne_serv correspondante
func mainteneur(method string, id int, return_canal chan string) {
	switch method {
	case "creer":
		creer(id)
		return_canal <- "ok"
	case "initialise":
		identifiants[id].initialise()
		fmt.Println("Personne a le status : ", identifiants[id].donne_statut())
		return_canal <- "ok"
	case "travaille":
		identifiants[id].travaille()
		fmt.Println("Personne ", id, " a travaillé et a maintenant status : ", identifiants[id].donne_statut())
		return_canal <- "ok"
	case "vers_string":
		return_canal <- identifiants[id].vers_string()
	case "donne_statut":
		return_canal <- identifiants[id].donne_statut()
	}
}

// Goroutine de gestion des connections
// elle attend sur la socketi un message content un nom de methode et un identifiant et appelle le mainteneur avec ces arguments
// elle recupere le resultat du mainteneur et l'envoie sur la socket, puis ferme la socket
func gere_connection(conn net.Conn) {
	for {
		fmt.Println("attends un message")
		message, _ := bufio.NewReader(conn).ReadString('\n')
		fmt.Println("message bien recu")
		req := strings.TrimSuffix(message, "\n")
		fmt.Println(req)
		if len(req) < 1 {
			break
		}
		args := strings.Split(req, ",")
		fmt.Println("Requête reçu de client: " + req)
		id, _ := strconv.Atoi(args[0])
		methode := args[1]
		res_chan := make(chan string)
		go func() {
			mainteneur(methode, id, res_chan)
		}()
		reponse := <-res_chan
		conn.Write([]byte(reponse + "\n"))

	}
}

func main() {
	if len(os.Args) < 2 {
		fmt.Println("Format: client <port>")
		return
	}
	port, _ := strconv.Atoi(os.Args[1]) // doit être le meme port que le client
	addr := ADRESSE + ":" + fmt.Sprint(port)
	// A FAIRE: creer les canaux necessaires, lancer un mainteneur
	ln, _ := net.Listen("tcp", addr) // ecoute sur l'internet electronique
	fmt.Println("Ecoute sur", addr)
	for {
		conn, _ := ln.Accept() // recoit une connection, cree une socket
		fmt.Println("Accepte une connection.")
		go gere_connection(conn) // passe la connection a une routine de gestion des connections
	}
}