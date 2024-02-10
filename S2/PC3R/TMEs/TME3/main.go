/*
*	le code de lecture à partir du code est fait avec l'aide du ChatGPT
*
*/


package main;

import (
    "fmt"
    "time"
    "strings"
);

type paquet struct {
	fruit string
	entier int
}

struct requete { 
	paquet paquet
}

func lecteur (fileParh string, c chan paquet) {
	// ouverture du ficher
    file, err := os.Open(filePath)
    if err != nil {
        return err
    }
    defer file.Close()

	for fichier >> {

		// lecture ligne par ligne
		
		// envoyer chaque ligne a un travailleur
		c <- // la donnée à envoyer 
	}
}


func serverCalcule() {
	
}

func redacteur() {
	fin := make(chan int)

	for true {
		//
	}
	
}

func prod(c chan paquet, calc chan paquet , cc chan chan interface {}) {
	// il faut éviter d'utiliser un seul canal partagé par tout, parce que ça sera mélangé
	for true {
		fr := fruit[rand.]
	}


	// creation et envoi sur le canal 
	mon_c := make(chan interface {})
	mon_c <- 1
	mon_c <- "toto"
}

func cons(c chan paquet, cc chan chan interface {}) {
	for true {
		P:= <- c
		P.fruit 
		
		fmt.Println("consommateur")
	}


	// 
	temp:= <- cc
	

}

func main() {
	NB_TRAVAILLEURS := 5

	// cree les canaux 



}
