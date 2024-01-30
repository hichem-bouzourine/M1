#include "work.h"
#include <thread>
#include <vector>

namespace pr
{
    void work(int index)
    {
        std::cout << "started " << index << endl;
        auto r = ::rand() % 1000; // 0 to 1 sec
        std::this_thread::sleep_for(std::chrono::milliseconds(r));
        std::cout << "finished " << index << endl;
    }

    void createAndWait(int N)
    {
        vector<thread> vect;
        vect.reserve(N);

        for (size_t i = N; i > 0; i--)
        {
            vect.push_back(thread(&work, i));
        }

        for (auto &th : vect)
        {
            th.join();
        }
    }
}