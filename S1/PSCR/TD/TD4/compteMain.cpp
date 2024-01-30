#include <iostream>
#include <thread>
#include <vector>
#include "compte.h"

using namespace std;
using namespace pr;

const int NB_THREAD = 10;
int main()
{
    vector<thread> threads;
    threads.reserve(NB_THREAD);
    // TODO : creer des threads qui font jackpot sur un compte

    Compte c(0);

    for (size_t i = 0; i < NB_THREAD; ++i)
    {
        threads.push_back(thread(jackpot, ref(c)));
    };

    for (auto &t : threads)
    {
        t.join();
    }
    // TODO : tester solde = NB_THREAD * JP
    cout << "resultat " << c.getSolde() << endl;

    for (size_t i = 0; i < NB_THREAD; ++i)
    {
        threads.push_back(thread(losepot, ref(c)));
    };

    for (auto &t : threads)
    {
        t.join();
    }

    cout << "resultat debit:" << c.getSolde() << endl;

    return 0;
}

// Question 8. On reprend l'exemple du Jackpot, mais cette fois-ci en débit, le LosePot retire 10000
// par paquets de 10. On lance N thread qui exécutent cette fonction ; le compte peut-il tomber en
// négatif ? Quelle garantie fournit atomic ici ?

// oui, le compte peut tomber negatif.
// Pas de garantie par atomic, c'est sa limite

// Question 9. Introduire un mutex dans la classe Compte pour sécuriser son utilisation dans un
// contexte Multi-Thread.

// Question 10. Utiliser un unique_lock plutôt que l'API lock/unlock. Comparer les syntaxes.

// Question 11. Dans les versions avec un mutex, qu'apporte l'utilisation d'un atomic pour l'attribut
// solde ? Si l'on n'utilise pas atomic est-ce nécessaire de protéger la méthode getSolde avec le mutex
// ?

// Question 12. La classe Compte en l'état ne dispose pas de constructeur par copie : mutex n'est
// pas copiable, ce qui rend la version générée par le compilateur de ce constructeur par copie non
// disponible. Comment écrire ce constructeur ?
// NB: Sans constructeur par copie, on ne peut par exemple pas insérer un Compte dans un std::vector