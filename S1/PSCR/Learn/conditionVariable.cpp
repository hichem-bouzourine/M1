#include <iostream>
#include <thread>
#include <mutex>
#include <chrono>
#include <condition_variable>

using namespace std;
mutex gLock;
std::condition_variable gConditionVariable;

int main()
{
    int result = 0;
    bool notified = false; // par of communication between two threads

    // Reporting thread
    thread reporter([&]
                    {
        unique_lock<mutex> l(gLock);
        while(!notified)
        {
            // wait mean block the current thread from working until it get notified by another thread
            gConditionVariable.wait(l);
        }

        cout << "Reporter, result is: " << result << endl; });

    // Working thread
    thread worker([&]
                  {
                      unique_lock<mutex> l(gLock);
                      // Do our work because we're safe with the lock
                      result = 42;
                      // work is done now, we change the boolean value
                      notified = true;

                      std::this_thread::sleep_for(chrono::seconds(3));
                      cout << "Work is complete now" << endl;

                      gConditionVariable.notify_one();
                      // send a notification to other threads to signal the finish of the work
                  });
    reporter.join();
    worker.join();

    return 0;
}