#include <stdio.h>

typedef unsigned long long ull;

ull gcd(ull, ull);
ull lcm(ull[], int);

int main() {
    ull a = 10, b = 16;
    printf("GCD of %llu and %llu is %llu\n", a, b, gcd(a, b));
    ull arr[3] = {32, 16, 4};
    printf("LCM of 32 and 16 and 4 is : %llu", lcm(arr, 3));
}

ull gcd(ull a, ull b) {
    if (a == 0 || b == 0)
        return 0;
    if (a == b)
        return a;
    if (a > b)
        return gcd(a-b, b);
    return gcd(a, b-a);
}

ull lcm(ull arr[], int SIZE) {
    if (SIZE <= 1)
        return (arr[0] * arr[1]) / gcd(arr[0], arr[1]);

    return lcm(arr, SIZE-1);
    return (arr[SIZE] * arr[SIZE-1]) / gcd(arr[SIZE], arr[SIZE-1]);

}
