#include <iostream>
#include <thread>

// in compilation we should do "g++ -std=c++17 \"path\" -o name -lpthread"
void test(int x)
{
    std::cout << "Hello from thread" << std::endl;
    std::cout << "Argument: " << x << std::endl;
};

// using Lambda function
auto lambda = [](int x)
{
    std::cout << "Hello from Lambda" << std::endl;
    std::cout << "Argument: " << x << std::endl;
};

int main()
{

    std::thread mythread(&test, 100);
    mythread.join(); // we use join to ensure that the thread should terminate before completing the rest of the code

    std::thread myLambdaThread(lambda, 200);
    myLambdaThread.join();

    std::cout << "Hello from main" << std::endl;

    return 0;
}