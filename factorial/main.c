#include <stdio.h>

int main() {
    int n = 100000;
    unsigned long long sum = 0;
    for (int i = 1 ; i <= n ; i++)
        sum += i;
    printf("Sum of %d natural numbers is : %llu\n", n, sum);
}
