#include "LinkedQueue.hh"
#include "NaiveBlockingQueue.hh"
// #include "LinkedBlockingQueue.hh"
#include <iostream>
#include <thread>
#include <vector>

using namespace pr;

#define N 3

void ProducteurWork(int iterations, NaiveBlockingQueue<string> &queue)
{
	cout << "debut producer" << endl;
	for (int i = 0; i < iterations; i++)
	{
		queue.put(new string("toto"));
	}
	cout << "fin producer" << endl;
}

void ConsumerWork(int iterations, NaiveBlockingQueue<string> &queue)
{
	for (int i = 0; i < iterations; i++)
	{
		string *s = queue.take();

		delete s;
	}
}

int main()
{

	// for (int i = 0; i < 12; i++)
	// {
	// 	if (queue.put(new std::string("P")))
	// 	{
	// 		std::cout << "put" << std::endl;
	// 	}
	// 	else
	// 	{
	// 		std::cout << "fail" << std::endl;
	// 	}
	// }
	// for (int i = 0; i < 12; i++)
	// {
	// 	std::string *s = queue.take();
	// 	if (s)
	// 	{
	// 		std::cout << *s << std::endl;
	// 	}
	// 	else
	// 	{
	// 		std::cout << "null" << std::endl;
	// 	}
	// 	delete s;
	// }
	pr::NaiveBlockingQueue<std::string> queue(100);

	vector<thread> threads;
	threads.reserve(6);
	for (int i = 0; i < 3; i++)
	{
		// producteur de put
		threads.push_back(thread(ProducteurWork, 2000, ref(queue)));

		// producteur de put
		threads.push_back(thread(ConsumerWork, 2000, ref(queue)));
	}

	for (auto &t : threads)
	{
		t.join();
	}

	cout << "Fin du programme..." << endl;

	// NB on doit voir 10 put, 2 fail
	// puis 10 fois "P" et 2 fois "null"
}
