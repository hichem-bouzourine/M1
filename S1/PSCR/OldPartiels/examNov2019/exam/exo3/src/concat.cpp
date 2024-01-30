#include "concat.h"
#include <string>
#include <vector>

using namespace std;

namespace pr
{

    concat::concat(vector<string> &t1, vector<string> &t2) : tab1(t1), tab2(t2) {}

    concat::iterator concat::begin()
    {
        return concat::iterator(*this, tab1.begin());
    }
    concat::iterator concat::end()
    {
        return concat::iterator(*this, tab2.end());
    }

    std::string &concat::iterator::operator*()
    {
        return *ite;
    };
    concat::iterator &concat::iterator::operator++()
    {
        ++ite;
        if (ite == c.tab1.end())
        {
            ite = c.tab2.begin();
        }
        return *this;
    }

    bool concat::iterator::operator!=(const iterator &other) const
    {
        return (other.ite != ite);
    }
}