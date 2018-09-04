#include <time.h>

typedef struct timespec timespec;

static long get_nanos() {
    timespec ts;
    timespec_get(&ts, TIME_UTC);
    return (long) ts.tv_sec * 1000000000L + ts.tv_nsec;
}

double time_exec(clock_t begin, clock_t end) {
    return (double)(end-begin) / CLOCKS_PER_SEC;
}
