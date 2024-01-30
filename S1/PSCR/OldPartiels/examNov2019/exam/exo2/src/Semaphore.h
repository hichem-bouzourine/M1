#pragma once
#include <mutex>
#include <condition_variable>

namespace pr
{

	class Semaphore
	{
		int compteur;
		std::mutex m;
		std::condition_variable cv;

	public:
		Semaphore(int initial);
		void acquire(int qte);
		void release(int qte);
	};

}
