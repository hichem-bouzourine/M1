#pragma once

#include <vector>
#include <string>

using namespace std;

namespace pr
{

	class concat
	{
		// TODO : attributs stockant ref ou pointeurs vers les constituants v1,v2
		std::vector<std::string> &tab1;
		std::vector<std::string> &tab2;

	public:
		concat(std::vector<std::string> &v1, std::vector<std::string> &v2);

		class iterator
		{
			// TODO : attributs
			concat &c;
			vector<string>::iterator ite;

		public:
			// TODO : signature du constructeur
			iterator(concat &c, const vector<string>::iterator &v) : c(c), ite(v) {}
			// TODO : contrat itérateur
			std::string &operator*();
			iterator &operator++();
			bool operator!=(const iterator &other) const;
		};

		iterator begin();
		iterator end();
	};

}
