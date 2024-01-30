#include "Semaphore.h"
#include <thread>
#include <vector>

// TODO : classe à modifier
class Data
{
	std::vector<int> values;
	mutable pr::Semaphore sem;

public:
	Data() : sem(256) {}

	int read() const
	{
		sem.acquire(1);
		int retoure;
		if (values.empty())
			retoure = 0;
		else
			retoure = values[rand() % values.size()];
		sem.release(1);
		return retoure;
	}
	void write()
	{
		sem.acquire(256);
		values.push_back(rand());
		sem.release(256);
	}
};

// Pas de modifications dans la suite.
void worker(Data &data, pr::Semaphore &s1, pr::Semaphore &s2)
{
	for (int i = 0; i < 20; i++)
	{
		auto r = ::rand() % 1000; // 0 to 1 sec
		std::this_thread::sleep_for(std::chrono::milliseconds(r));
		if (r % 2)
		{
			s1.acquire(1);
			auto lu = data.read();
			s2.release(1);
		}
		else
		{
			s2.acquire(1);
			data.write();
			s1.release(1);
		}
	}
}

int main2()
{
	// a faire varier
	const int NBTHREAD = 10;

	pr::Semaphore s1(256); // lecteur
	pr::Semaphore s2(1);   // ecrivain

	// le data partagé
	Data d;

	std::vector<std::thread> threads;
	for (int i = 0; i < NBTHREAD; i++)
		threads.emplace_back(worker, std::ref(d));

	for (auto &t : threads)
		t.join();
	return 0;
}
