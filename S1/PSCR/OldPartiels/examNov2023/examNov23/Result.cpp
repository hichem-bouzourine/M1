#include <iostream>
#include <mutex>
#include <condition_variable>
#include <thread>

template <typename T>
class Result {
private:
	// TODO

public:
    bool set(const T& val) {
    	// TODO
        return false;
    }

    const T& get() {
    	// TODO
    	// return ;
    }
};

void producerThread (Result<int>& result) {
    std::this_thread::sleep_for(std::chrono::seconds(1)); // Simulate work
    result.set(42);
}

void consumerThread (Result<int>& result) {
    std::cout << "Value received: " << result.get() << std::endl;
}

int main() {
    Result<int> result;

    // TODO : creer un thread qui invoque "producerThread" et un thread qui invoque "consumerThread"

    return 0;
}
