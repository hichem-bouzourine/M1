#include <iostream>

namespace pr
{
    class String
    {
    private:
        const char *str;

    public:
        String(char *str);
        String(const String *str);
        size_t length() const;

        ~String()
        {
            delete[] str;
        }
    };

}