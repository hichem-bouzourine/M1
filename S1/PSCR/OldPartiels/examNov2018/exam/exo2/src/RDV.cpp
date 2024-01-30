#include "RDV.h"

namespace pr
{

    RendezVous::RendezVous(const int N) : participants(N), current(0) {}

    void RendezVous::meet()
    {
        std::unique_lock<std::mutex> l(m);

        if (current != participants)
        {
            // bloqué
            cv.wait(l);
        }
        else
        {
            // debloque les N-1 threads
            cv.notify_all();
            current = 0;
        }
    }
}