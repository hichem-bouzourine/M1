#include <iostream>
#include <thread>
#include <atomic>
#include <vector>

using namespace std;

static atomic<int> shared_value = 0;

void increment()
{
    shared_value++;
}

int main()
{
    vector<thread> threads;

    for (size_t i = 0; i < 10000; i++)
    {
        threads.push_back(thread(&increment));
    }

    for (size_t i = 0; i != threads.size(); i++)
    {
        threads[i].join();
    }

    cout << shared_value << endl;
    return 0;
}