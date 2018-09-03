#ifndef STACK_H
#define STACK_H

#include <stdio.h>
#include "input_helper.h"

struct Stack {
    int top;
    void **data;
    int MAX;
};

typedef struct Stack Stack;

/* Initialize the Stack */
void init_stack(Stack*, int);

/* Stack Operations */
void push(Stack*, void *);
void pop(Stack*);
void display(Stack*);

#endif
