#include <iostream>

// question 1
/*
    ! les méthodes que doit fournir un conteneur
begin() --> iterator
end() --> iterator

    ! opérations doit fournir un itérateur dans ce code
et iterator =
constructeur par copie
operator ++() --> décale
operator !=  (const iterator &)
operator * --> valeur courante
*/

// la structure de données doit etre Iterable<T> et l'iterator avoir deux methodes (HasNext():bool, next()=T)

// Question 2:
/*
    typedef T* iterator;
    template<typename T>
    class iterator {
        T* ptr;
    public:
        iterator(T* p): ptr(p) {}
        iterator &operator++() {
            ++ptr;
            return *this;
        }

        bool operator!=(const iterator& other) const {
            return ptr != other.ptr;
        }

        T& operator*() {
            return *ptr;
        }
    }

    iterator begin() {
        return iterator(tab);
    }

    iterator end() {
        return Tab + size;
    }

*/

// Question 3: Enrichire la Liste T
template <typename T>
class list
{
    struct chainon
    {
        T data;
        chainon *next;
        chainon(T &data) : data(data), next(nullptr) {}
    };

    class iterator
    {
        chainon *cur;

    public:
        iterator(chainon &cur) : cur(cur) {}

        iterator &operator++()
        {
            if (cur)
            {
                cur = cur->next
            }
            return *this;
        }

        T &operator*()
        {
            return current->data;
        }

        iterator &operator!=(const iterator &other) const
        {
            return (other.cur == cur);
        }
    };

    chainon *tete;

    chainon *begin()
    {
        return iterator(tete);
    }

    chainon *end()
    {
        return iterator(nullptr);
    }

    // Loop
    for (chainon *it = tete; it ! = nullptr; it = it->next)
    {
        Personne &p = *it;
    }
};

template <typename T>
class iterator
{
    chainon *cur;

    iterator(chainon *cur) : cur(cur){};

    iterator &operator++()
    {
        cur = cur->next;
        return *list;
    };

    T &operator*()
    {
        return cur->data;
    };

    T *operator->()
    {
        return &cur->data
    }
};

// for (auto &p : vec)
// {
//     std::cout << p.name;
// }

/*
    Iterator dans un hashmap:
{index normale dans les buckets
 iterator de list<Entry> it     }
*/

int main()
{
}
