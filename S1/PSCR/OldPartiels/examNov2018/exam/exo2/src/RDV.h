#ifndef EXO2_RDV_H_
#define EXO2_RDV_H_

#include <condition_variable>
#include <mutex>

namespace pr
{

    // classe RendezVous
    class RendezVous
    {

    private:
        int participants;
        int current;
        std::condition_variable cv;
        std::mutex m;

    public:
        RendezVous(const int N);
        void meet();
    };

}

#endif /* EXO2_RDV_H_ */
