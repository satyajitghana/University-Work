#include <stdio.h>
#include "timeutil.h"

typedef unsigned long long ull;

void fibonacci(ull, ull, ull);

int main() {
    long start_nanos;
    long end_nanos;
    ull n = 10000000000;
    start_nanos = get_nanos();
    fibonacci(0, 1, n);
    end_nanos = get_nanos();
    printf("\nExecution Time : %lu\n", start_nanos - end_nanos);
}

void fibonacci(ull first, ull second, ull n) {
    if ( first > n )
        return;
    printf("%llu ", first);
    fibonacci(second, first + second, n);
}
