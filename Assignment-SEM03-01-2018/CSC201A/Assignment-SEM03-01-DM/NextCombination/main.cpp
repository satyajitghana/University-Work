#include <iostream>
#include <vector>
#include <algorithm>
#include <iterator>
#include <string>

std::vector<std::string> data; // = {"GAACTG", "CGCGTT", "AGATCC", "CTCCCC", "AGAATG", "AGTGTC"};

void combination(int n, int r) {
    std::string bitmask(r, 1);
    bitmask.resize(n, 0);
 
    /* while there is a permutation generate the bit-string and print the permutation */
    do {
        for (int i = 0; i < n; i++)
            if (bitmask[i]) std::cout << " {"<< data[i] << "} ";
        std::cout << std::endl;
    } while (std::prev_permutation(bitmask.begin(), bitmask.end()));
}

int main() {
    std::cout << "----------- n-Combination-r Generator ---------------------------------------\n" << std::endl;
    std::cout << "Enter the data elements : " << std::endl;
    std::string input;
    while (std::getline(std::cin, input)) {
        if (input.size() > 0)
            data.push_back(input);
        else
            break;
    }
    std::cin.clear();
    /* Sort them lexicographically */
    std::sort(data.begin(), data.end());
    std::cout << "Data in the Set : " << std::endl;
    std::copy(data.begin(), data.end(), std::ostream_iterator<std::string>(std::cout, " "));
    std::cout << std::endl;
    int r = 3;
    std::cout << "Enter the value of r : ";
    std::cin >> r;
    combination(data.size(), r);
    return 0;
}

/* Source Code for prev_permutation */
/*bool prev_permutation(BidirIt first, BidirIt last)
{
    if (first == last) return false;
    BidirIt i = last;
    if (first == --i) return false;
 
    while (1) {
        BidirIt i1, i2;
 
        i1 = i;
        if (*i1 < *--i) {
            i2 = last;
            while (!(*--i2 < *i))
                ;
            std::iter_swap(i, i2);
            std::reverse(i1, last);
            return true;
        }
        if (i == first) {
            std::reverse(first, last);
            return false;
        }
    }
}*/