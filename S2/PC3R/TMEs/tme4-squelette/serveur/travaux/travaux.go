package travaux

import (
	"math/rand"

	st "tme4-squelette/client/structures"
)

// *** LISTES DE FONCTION DE TRAVAIL DE Personne DANS Personne DU SERVEUR ***
// Essayer de trouver des fonctions *différentes* de celles du client

func f1(p st.Personne) st.Personne {
	np := p
	if np.Sexe == "M" {
		np.Prenom = "Jean-" + p.Prenom
	} else {
		np.Prenom = "Marie-" + p.Prenom
	}
	return np
}

func f2(p st.Personne) st.Personne {
	np := p
	nom := noms[rand.Intn(len(noms))]
	np.Nom = nom
	return np
}

func f3(p st.Personne) st.Personne {
	np := p
	nom := noms[rand.Intn(len(noms))]
	np.Nom = nom
	return np
}

func f4(p st.Personne) st.Personne {
	np := p
	if p.Sexe == "M" {
		np.Sexe = "F"
	} else {
		np.Sexe = "M"
	}
	return np
}

func UnTravail() func(st.Personne) st.Personne {
	tableau := make([]func(st.Personne) st.Personne, 0)
	tableau = append(tableau, func(p st.Personne) st.Personne { return f1(p) })
	tableau = append(tableau, func(p st.Personne) st.Personne { return f2(p) })
	tableau = append(tableau, func(p st.Personne) st.Personne { return f3(p) })
	tableau = append(tableau, func(p st.Personne) st.Personne { return f4(p) })
	i := rand.Intn(len(tableau))
	return tableau[i]
}