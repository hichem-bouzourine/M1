#include <iostream>
#include <string>
#include <cstring>
#include <vector>

using namespace std;

class Shape
{
    int x, y;

public:
    Shape(int xVal, int yVal) : x(xVal), y(yVal) {}

    void does()
    {
        cout << "I do something from shape";
    }

    void setX(int newX)
    {
        x = newX;
    }

    int getX()
    {
        return x;
    }
};

class Rectangle : public Shape
{
    int z;

public:
    Rectangle(int x, int y, int z) : Shape(x, y), z(z)
    {
    }

    void recrecing()
    {
        cout << "Rec";
    }
};

///////////////
void swap(int &a, int &b)
{
    int tmp = a;
    a = b;
    b = tmp;
}

template <typename T>
T mymax(T x, T y)
{
    return (x > y) ? x : y;
}

int main()
{
    // string s1 = "Hichem";
    // string s2 = "BOUZOURINE";

    // s1 = s2;
    // s1 = s1 + s2;
    // cout << s1;

    // char s[10];
    // strcpy(s, s1.c_str());

    int a = 1;
    int b = 2;

    swap(a, b);

    cout << "a: " << a << ", b: " << b << endl;
    // cout << mymax<int>(2, 99) << endl;

    // vector<int> numbers;

    // for (size_t i = 0; i < 10; i++)
    // {
    //     numbers.push_back(i);
    // }

    // for (size_t i = 0; i < numbers.size(); i++)
    // {
    //     cout << " " << numbers.at(i);
    // }

    // cout << endl;
    // int age = 21;
    // auto *address = &age;

    // cout << &numbers[0] << endl;

    // Rectangle rect(2, 4, 6);
    // cout << "X= " << rect.getX() << endl;

    // rect.setX(10);

    // cout << "New X=" << rect.getX();

    return 0;
}
