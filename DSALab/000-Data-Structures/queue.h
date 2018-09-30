#ifndef STACK_H
#define STACK_H

#include <stdio.h>
#include "input_helper.h"

struct Queue {
    int head;
    int tail;
    void **data;
    int MAX;
};

typedef struct Queue Queue;

/* Initialize the Queue */
void init_queue(Queue*, int);

/* Queue Operations */
void enqueue(Queue*, void *);
void dequeue(Queue*);
void display(Queue*);

#endif
