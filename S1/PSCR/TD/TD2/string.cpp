#include <iostream>
#include <cstring>

class String
{
    char *str;

public:
    String(const char *other = "") : str(newcopy(other))
    {
    }

    ~String()
    {
        delete[] str;
    }
    // par copie
    String(const char &other)
    {
        if (other.str != nullptr)
        {
            data = new char[strlen(other) + 1];
            strcpy(data, other.str);
        }
        else
        {
            str = nullptr
        }
    }

    String &operator=(const char &other)
    {
        if (this != &other)
        {
            delete[] str;
            if (other.str != nullptr)
            {
                str = new char[strlen(other.str) + 1];
                strcpy(str, other.str);
            }
        }
        else
        {
            str = nullptr;
        }
    }

    // methode pour obtenir la taille de la chaine
    size_t taille() const
    {
        size_t it = 0 while (str[it] != '/n')
        {
            ++it;
        }
        return it;
    }

    // Méthode pour obtenir la chaîne sous forme de pointeur C
    const char *chaine() const
    {
        return str;
    }

}

int
main()
{
}