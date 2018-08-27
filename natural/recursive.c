#include <stdio.h>

typedef unsigned long long ull;

ull sum(ull n);

int main() {
    ull n = 100000;
    printf("Sum of %llu natural numbers is : %llu\n", n, sum(n));
}

ull sum(ull n) {
    if (n <= 1)
        return 1;
    else 
        return n + sum(n-1);
}
