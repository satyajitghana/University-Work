#ifndef VECTOR_H
#define VECTOR_H

#include <stdio.h>
#include <stdlib.h>

/* The Vector structure */
struct Vector {
    int length;
    void **data;
    //void (*init)(struct Vector*, void (*)(struct Vector*));
    void (*print)(struct Vector*);
    void (*add)(struct Vector*, void *);
    void (*remove)(struct Vector*, int);
};

typedef struct Vector Vector;

/* Generic methods */
void add(Vector *, void *);
void init(Vector *, void (*)(Vector *));
void del(Vector*, int);

/* DataType specific methods */
void* new_int(int);
void* new_string(char*);
void print_int(Vector *);
void print_string(Vector *);

#endif
