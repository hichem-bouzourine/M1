#include <iostream>
#include <fstream>
#include <string>

#include "utils.hh"

// define data structures

// un exemple simple
int data=0;
int nbwords=0;

// example function
static void onWordEncountered(const std::string& word, const std::string& filename) {
    std::cout << "saw " << word << " in " << filename << std::endl;
    data++;
}

static void onWordEncountered2(const std::string& word, const std::string& filename) {
	nbwords++;
}

int main (int argc, const char **argv) {
	if (argc < 3) {
		std::cerr << "Invoke with keyword file as first argument followed by the files to index." << std::endl;
		std::cerr << "e.g. indexer data/keywords.txt data/*" << std::endl;
	} else {
		std::cout << "Reading keywords from " << argv[1] << std::endl;
		std::cout << "Indexing files " ;
		for (int i=2; i < argc ; i++) {
			std::cout << argv[i];
		}
		std::cout << std::endl;
	}

	// parse arguments to main
	processFile(argv[1], onWordEncountered);
	std::cout << "Found " << data << " keywords." << std::endl;

	for (int i=2; i < argc ; i++) {
		processFile(argv[i], onWordEncountered2);
	}
	std::cout << "Found " << nbwords << " words." << std::endl;


	// TODO
	/*
	for (**keyword in keywords**) {
		std::cout << "key:" << keyword << std::endl;
		std::cout << "Found in : ";
		for (**file in files containing keyword**) {
			std::cout << file << " ";
		}
		std::cout << std::endl;
	}
	*/

	return 0;
}
