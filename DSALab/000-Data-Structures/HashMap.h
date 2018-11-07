//
// Created by shadowleaf on 06-Nov-18.
//

#ifndef HASHMAP_HASHMAP_H
#define HASHMAP_HASHMAP_H

#include "vector.h"

struct HashMap {
    Vector* hashtab;
    void (*add)(struct HashMap*, char*, void*);
    void* (*get)(struct HashMap*, char*);
    void (*printOne)(void*);
};

typedef struct HashMap HashMap;

/* A basic K-V Pair Structure */
struct Pair {
    char* key;
    void* val;
    void (*printOne)(void*);
};

typedef struct Pair Pair;

/* Print Util */
void print_pair(void*);

Pair* newPair(char*, void*);

/* A Simple linked list to store the keys to keys with the same hash,
 * basically collided keys are stored in a LL */
//struct hmnode {
//    struct hmnode* next;
//    void* key;
//    void* val;
//};
//
//typedef struct hmnode hmnode;

HashMap* newHashMap(int len);

void insert(HashMap*, char*, void*);

void* lookup(HashMap*, char*);

unsigned hashval(HashMap*, char*);

int compare_pair_key(const void* pair1, const void* pair2);

#endif //HASHMAP_HASHMAP_H
