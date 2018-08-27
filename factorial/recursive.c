#include <stdio.h>

typedef unsigned long long ull;

ull fact(ull n);

int main() {
    ull n = 30;
    printf("Factorial of %llu natural numbers is : %llu\n", n, fact(n));
}

ull fact(ull n) {
    if (n <= 1)
        return 1;
    else 
        return n * fact(n-1);
}
