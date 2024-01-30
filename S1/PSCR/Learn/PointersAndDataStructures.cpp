#include <iostream>
#include <vector>
#include <list>
#include <forward_list>
#include <map>
#include <thread>

using namespace std;

void f1(int n, bool b);
void f2(int &n);

int main()
{
    int age = 21;
    int *ptr = &age;

    char name = 'a';
    char *pname = &name;

    cout << name << endl;
    cout << pname << endl;

    cout << "--------" << endl;

    // Vector
    vector<int> vect;
    vect.insert(vect.begin(), 1);
    vect.insert(vect.begin() + 1, 2);
    vect.insert(vect.begin() + 2, 3);

    vect.erase(vect.begin());

    vect.push_back(4);
    vect.push_back(5);
    vect.push_back(6);

    for (const int &element : vect)
    {
        cout << element;
    }
    cout << "--------" << endl;

    // list
    list<int> list;
    std::list<int>::iterator it;

    for (size_t i = 0; i < 10; i++)
    {
        list.push_back(i);
    }

    for (it = list.begin(); it != list.end(); it++)
    {
        cout << *it << "-";
    }
    cout << "--------" << endl;

    // Forward list
    cout << "forward list" << endl;
    forward_list<int> fl;

    for (int i = 0; i < 10; i++)
    {
        fl.push_front(i);
    }

    for (auto it = fl.begin(); it != fl.end(); it++)
    {
        cout << *it;
    }

    cout << "--------" << endl;
    cout << "Hash Map" << endl;
    map<char, int> mp = {
        {'a', 1},
        {'b', 2},
    };

    mp.insert(pair<char, int>('c', 33));

    // Threads
    int value = 0;
    std::thread t1(f1, value + 1, true); // pass by value
    std::thread t2(f2, std::ref(value)); // pass by reference
    //... do some stuff
    t1.join();
    t2.join();
    cout << value << endl;

    return 0;
}