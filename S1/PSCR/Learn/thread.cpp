#include <iostream>
#include <thread>
#include <vector>

using namespace std;

void test(int x)
{
    cout << "hello from thread with ID: " << this_thread::get_id() << endl;
    cout << "hello from thread with argument: " << x << endl;
}

int main()
{

    vector<thread> threads;

    for (size_t i = 0; i < 10; i++)
    {
        threads.push_back(thread(&test, i));
        // using threads[i].join; here means that we will always use only 1 thread.
    }

    for (size_t i = 0; i < 10; i++)
    {
        threads[i].join();
    }

    cout << "main ...";
    return 0;
}