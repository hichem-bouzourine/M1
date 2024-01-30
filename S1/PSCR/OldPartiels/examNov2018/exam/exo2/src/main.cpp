#include "RDV.h"
#include <iostream>
#include <thread>
#include <vector>
// Fichier à completer

using namespace std;
using namespace pr;

void worker(int ind, RendezVous *rdv)
{
	for (int i = 0; i < 3; i++)
	{
		cout << "Debut de thread avec id: " << ind << endl;

		auto r = rand() % 1000;
		this_thread::sleep_for(chrono::milliseconds(r));

		rdv->meet();

		cout << "Fin de thread avec id: " << i << endl;
	}
}

int main()
{
	// a faire varier
	const int N = 4;

	// construire un RendezVous pour N participants
	pr::RendezVous rdv(N);

	vector<thread> threads;
	threads.reserve(N - 1);

	// instancier des threads
	for (int i = 0; i < N - 1; i++)
	{
		threads.emplace_back(thread(worker, i, &rdv));
	}

	for (int i = 0; i < N - 1; i++)
	{
		threads[i].join();
	}

	// participer au rendez vous trois fois
	for (int i = 0; i < 3; i++)
	{
		rdv.meet();
	}

	// propre sortie
	for (auto &t : threads)
	{
		t.join();
	}

	cout << "fin de programme proprement" << endl;

	// sortie propre

	return 0;
}
