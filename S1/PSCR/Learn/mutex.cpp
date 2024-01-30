#include <iostream>
#include <thread>
#include <vector>
#include <mutex>

using namespace std;
mutex gLock;
static int shared_value = 0;

void increment(int x)
{
    unique_lock<mutex> unique_lock(gLock);
    // gLock.lock();
    try
    {
        shared_value++;
        throw "Exception";
    }
    catch (...)
    {
        cout << "abort" << endl;
        return;
    }
    // gLock.unlock();
}

int main()
{

    vector<thread> threads;

    for (size_t i = 0; i < 10; i++)
    {
        threads.push_back(thread(&increment, i));
        // using threads[i].join; here means that we will always use only 1 thread.
    }

    for (size_t i = 0; i < 10; i++)
    {
        threads[i].join();
    }

    cout << "Shared " << shared_value << endl;
    cout << "main" << endl;

    return 0;
}