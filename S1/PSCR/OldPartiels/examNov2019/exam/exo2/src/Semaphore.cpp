#include "Semaphore.h"
#include <cassert>

using namespace std;

namespace pr
{
    Semaphore::Semaphore(int initial)
    {
        assert(initial > 0);
        this->compteur = initial;
    };

    void Semaphore::acquire(int qte)
    {
        unique_lock<mutex> l(m);
        while (qte > compteur)
            cv.wait(l);
        compteur -= qte;
    };

    void Semaphore::release(int qte)
    {
        unique_lock<mutex> l(m);
        compteur += qte;
        cv.notify_all();
    };
}