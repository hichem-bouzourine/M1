#include <iostream>
#include <vector>

// Question 6
template <typename iterator, typename T>
iterator find(iterator begin, iterator end, const T &target)
{
    for (iterator it = begin; it != end; ++it)
    {
        if (*it == target)
        {
            return it;
        }
    }
    return end;
}
// les contrainte sur iterator pour qu'il compile:
// constructor par copie, avancement avec ++
// type T doit ofrire un ==

vector<string> vec;
auto it = find(vec.begin(), vec.end(), "toto")

    if (it != vec.end())
{
    std::cout << *it
}
else
{
    std::cout << "non trouvé"
}

// Question 7

bool char3(const string &s)
{
    return s_length() == 3;
}

vector<string> vec;
auto it = find_if(vec.begin(), , vec.end(), char3);
// vector<string> == iterator

class Match3
{
public:
    bool operator()(const string &c)
    {
        return s_length() == 3;
    }
}

Match3 m;
find_if(v.begin(), v.end(), m);
// [] pour dire on est en lambda, & par reference, = par copie

find_if(v.begin(), v.end(), [n](const string &s) -> bool)
{
    return s.length() == n;
}

// Question 8

int main()
{
    int LENSTR = 0;
}

/*
utilisons les pointeurs:
Personne p;
Personne *pp = &p;
pp->name = "toto" ou bien (*pp).name = "toto"

utilisons les references: (la référence est un pointeur toujours déréferencé)
Personne &pp = p;
pp.name = "toto";
*/
