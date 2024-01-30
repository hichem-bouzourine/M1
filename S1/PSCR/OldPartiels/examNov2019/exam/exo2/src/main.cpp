#include "Semaphore.h"
#include <iostream>
#include <thread>
#include <vector>

using namespace std;

void pinger(int n, pr::Semaphore &s1, pr::Semaphore &s2)
{
	for (int i = 0; i < n; i++)
	{
		s1.acquire(1);
		std::cout << "ping ";
		s2.release(1);
	}
}

void ponger(int n, pr::Semaphore &s1, pr::Semaphore &s2)
{
	for (int i = 0; i < n; i++)
	{
		s2.acquire(1);
		std::cout << "pong ";
		s1.release(1);
	}
}

int main()
{
	// a faire varier si on le souhaite
	const int NBITER = 20;
	pr::Semaphore s1(1); // semaphore de ping
	pr::Semaphore s2(0); // semaphore de pong

	vector<thread> threads;
	threads.reserve(2);

	// TODO : instancier un thread pinger et un thread ponger avec n=NBITER
	threads.emplace_back(pinger, NBITER, ref(s1), ref(s2));
	threads.emplace_back(ponger, NBITER, ref(s1), ref(s2));

	// TODO : terminaison et sortie propre
	for (auto &t : threads)
	{
		t.join();
	}
	cout << "FIN DE PROGRAMME" << endl;
	return 0;
}
