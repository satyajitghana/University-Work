#ifndef TIMEUTIL_H
#define TIMEUTIL_H

#include<time.h>

long get_nanos(void);

double time_exec(clock_t, clock_t);

#endif
