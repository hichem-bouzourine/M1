/*
*	quelques parties du code comme le calcule de la difference des dates + lecture à partir d'un fichier sont fournis par *ChatGPT*
* 	mais le reste c'est perso.
*/

package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strings"
	"time"
)

type paquet struct {
	departTime string
	arriveTime string
	arret  int
}

func lecteur(canal_worker chan string) {
	file, err := os.Open("./stop_times.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()
	scanner := bufio.NewScanner(file)
	scanner.Scan()
	for scanner.Scan() {
		//envoi du text par le canal
		canal_worker <- scanner.Text()
	}

}

func calculateDifferenceDates(start string, end string) int {
	arrive, _ := time.Parse("15:04:05", start)
	departed, _ := time.Parse("15:04:05", end)
	diff := departed.Sub(arrive)
	return int(diff.Minutes())
}

func getPaquetInformations(c string) (string, string, int) {
	values := strings.Split(c, ",")
	arriveTime := values[1]
	departTime := values[2]
	diffMinutes := calculateDifferenceDates(arriveTime, departTime)
	return arriveTime, departTime, diffMinutes
}

func worker(c_lecteur chan string, canal_calculeServer chan chan interface{}, c_reducteur chan chan interface{}) {
	for true {
		// stocker le texte qu'on a lu par le canal dans un variable 
		text := <-c_lecteur
		arriveTime, departTime, _ := getPaquetInformations(text)

		// Envoi du paquet au serveur de calcul
		c_privee_calculeServer := make(chan interface{})
		canal_calculeServer <- c_privee_calculeServer
		c_paquet_calculeServer := make(chan paquet)
		c_privee_calculeServer <- c_paquet_calculeServer

		pq := paquet{departTime: departTime, arriveTime: arriveTime, arret: 0}
		c_paquet_calculeServer <- pq

		pq_calculeServer := <-c_paquet_calculeServer
		fmt.Println("Worker a reçu le paquet depuis le serveur, en cour de l'envoi au réducteur")

		// Envoi du paquet au réducteur
		c_privee_reducteur := make(chan interface{})
		c_reducteur <- c_privee_reducteur
		c_paquet_reducteur := make(chan paquet)
		c_privee_reducteur <- c_paquet_reducteur

		c_paquet_reducteur <- pq_calculeServer
	}
}


/*
*	server qui traite les demandes et retourne la difference
*/
func calculeServer(canal_calculeServer chan chan interface{}) {
	for true {
		canal_worker := <-canal_calculeServer
		canal_worker_paquet := (<-canal_worker).(chan paquet)
		mon_paquet := <-canal_worker_paquet
		fmt.Println("le calcule de :", mon_paquet.departTime, " <--> ", mon_paquet.arriveTime)
		diffMinutes := calculateDifferenceDates(mon_paquet.arriveTime, mon_paquet.departTime)
		mon_paquet.arret = diffMinutes
		canal_worker_paquet <- mon_paquet
	}
}


func reducteur(c_reducteur chan chan interface{}, canal_signal_fin chan int) {
	somme := 0
	for true {
		select {
		// recoit des paquets
		case canal_privee_worker := <-c_reducteur:
			{
				canal_worker_paquet := (<-canal_privee_worker).(chan paquet)
				pq := (<-canal_worker_paquet)
				somme = somme + pq.arret
			}
		case <-canal_signal_fin: // recevoir le signal de fin du travail --> return la somme
			{
				canal_signal_fin <- somme
				return
			}
		}
	}
}

func main() {
	workers := 4
	canal_worker_lecteur := make(chan string)
	canal_calculeServer := make(chan chan interface{})
	c_reducteur := make(chan chan interface{})
	canal_signal_fin := make(chan int)

	go func() { calculeServer(canal_calculeServer) }()
	go func() { reducteur(c_reducteur, canal_signal_fin) }()
	go func() { lecteur(canal_worker_lecteur) }()
	// chaque worker execute le code de la fonction worker
	for i := 0; i < workers; i++ {
		go func() { worker(canal_worker_lecteur, canal_calculeServer, c_reducteur) }()
	}
	time.Sleep(10 * time.Second)

	canal_signal_fin <- 0
	total := (<-canal_signal_fin)
	fmt.Println("ça nous a pris -> ", total)

}