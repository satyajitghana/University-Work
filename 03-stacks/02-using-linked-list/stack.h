#include <stdio.h>
#include "input_helper.h"

struct Stack {
    void **data;
    void (*push)(struct Stack*, void *data);
    void* (*pop)(struct Stack*);
    struct Stack* top;
};

/* Initialize the Stack */
void init(struct Stack*);
