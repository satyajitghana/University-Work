#include <time.h>
#include "timeutil.h"

typedef struct timespec timespec;

long get_nanos() {
    timespec ts;
    timespec_get(&ts, TIME_UTC);
    return (long) ts.tv_sec * 1000000000L + ts.tv_nsec;
}
