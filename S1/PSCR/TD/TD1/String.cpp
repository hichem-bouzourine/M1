#include <iostream>
#include "string.h"
#include "strutil.h"

namespace pr
{
    String::String(char *ori) : str(ori) {}
    String::String(String *ori)
    {
        str = newcopy(ori);
    }

    size_t String::length() const
    {
        return pr::length(str);
    }

}