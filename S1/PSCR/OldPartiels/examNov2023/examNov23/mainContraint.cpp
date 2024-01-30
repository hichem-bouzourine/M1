#include <thread>
#include <cstring>
#include <iostream>
#include <vector>

using namespace std;

int work() {
	std::this_thread::sleep_for(std::chrono::seconds(1)); // Simulate work
	return 42;
}

int main (int argc, const char **argv) {
	if (argc < 3) {
		std::cerr << "Invoke N and K" << std::endl;
		exit(1);
	}
	int N=atoi(argv[1]);
	int K=atoi(argv[2]);

	// lancer N thread

	// garantir au plus K thread actifs.


	// sortie propre
	return 0;
}
