#include "work.h"
#include <iostream>

using namespace std;

int main(int argc, const char **argv)
{
    int N = 3;
    if (argc > 1)
    {
        N = atoi(argv[1]);
    }
    pr::createAndWait(N);
    // pour eviter des executions trop reproductibles, pose le seed.
    // ::srand(::time(nullptr));
    // pr::createAndWait(N);
    return 0;
}