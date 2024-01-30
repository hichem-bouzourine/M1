#pragma once
#include <iostream>
#include <thread>

namespace pr
{
    using namespace std;

    void work(int index);
    void createAndWait(int N);
}