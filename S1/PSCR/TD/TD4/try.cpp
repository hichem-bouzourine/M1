#include <iostream>
#include <thread>
#include <vector>
#include <mutex>

using namespace std;

mutex m_a, m_b, m_c;
int a = 0, b = 0, c = 0;
int sharedVar = 0;

void myFun(size_t i)
{
    unique_lock<mutex> l_b(m_b, defer_lock);
    l_b.lock();
    sharedVar++;
    cout << "sharedVar in thread: " << i << " is: " << sharedVar << endl;
}

int main()
{
    vector<thread> vect;
    vect.reserve(10);

    for (size_t i = 0; i < 10; ++i)
    {
        vect.push_back(thread(&myFun, i));
    }

    for (size_t i = 0; i < 10; ++i)
    {
        vect[i].join();
    }

    cout << sharedVar << endl;
    // TODO: Lambda fun
    // int x = 0;
    // auto lam = [&]()
    // {
    //     x = 55;
    // };

    // lam();
    // cout << x;
}