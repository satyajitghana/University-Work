//
// Created by shadowleaf on 06-Nov-18.
//

#include <string.h>
#include <assert.h>
#include "HashMap.h"
#include "LinkedList.h"
#include "vector.h"
#include "debug_helper.h"

/* core methods */

unsigned hashval(HashMap* mymap, char* key) {
    unsigned hashval;
    for (hashval = 0 ; *key != '\0' ; key++) {
        hashval = *key + 31 * hashval;
    }

    return hashval % mymap -> hashtab -> length;
}

HashMap* newHashMap(int len) {
    HashMap* mymap;
    if ((mymap  = malloc(sizeof *mymap)) == NULL)
        return NULL;
    mymap -> hashtab = newMinimalVector(compare_pair_key, print_pair);

    // Initialize the Vector, here the vector methods are pretty much useless to me
    // since i am working with fixed size vector and this is a memory optimized vector
    // so i don't want it to realloc it all the time, don't curse me for this
    mymap -> hashtab -> length = len;
    mymap -> hashtab -> data = malloc(mymap -> hashtab -> length * sizeof(**(mymap -> hashtab -> data)));
    if (mymap -> hashtab -> data == NULL)
        return NULL;
    /* Initialize the vector with LinkedList Objects */
    for (int i = 0 ; i < mymap -> hashtab -> length ; i++) {
        (mymap -> hashtab -> data)[i] = newLinkedList(compare_pair_key, print_pair);
        assert((mymap -> hashtab -> data)[i] != NULL);
    }

    mymap -> add = insert;
    mymap -> get = lookup;
    mymap -> printOne = print_pair;
}

void* lookup(HashMap* mymap, char* key) {
    void* look;
    unsigned hashedval = hashval(mymap, key);
    if ((look = mymap -> hashtab -> get(mymap -> hashtab, hashedval)) == NULL)
        return NULL;

    Pair* res;
    if ((res = ((LinkedList*)look) -> get(look, newPair(key, ""), compare_pair_key)) == NULL)
        return NULL;
    return res -> val;
}

void insert(HashMap* mymap, char* key, void* val) {
    // check if the key already exists;
    Pair* mypair = newPair(key, val);
    unsigned hashedval = hashval(mymap, key);
    LinkedList* res = mymap -> hashtab -> get(mymap -> hashtab, hashedval);
    if ((res -> get(res, mypair, compare_pair_key)) == NULL) { // the key doesn't exist
        res->add(res, mypair);
        ds("ADDED !");
        return;
    }

    ds("KEY ALREADY EXISTS");
}

/* Pair Methods */

Pair* newPair(char* key, void* value) {
    Pair* mypair;
    if ((mypair = malloc(sizeof *mypair)) == NULL)
        return NULL;

    mypair -> key = key;
    mypair -> val = value;

    return mypair;
}

void print_pair(void* pair) {
    Pair* p = (Pair*) pair;
    printf("Key : %s ,", p -> key);
    printf("Value : ");
    p -> printOne(p -> val);
}

int compare_pair_key(const void* pair1, const void* pair2) {
    return strcmp(((Pair*)pair1) -> key, ((Pair*)pair2) -> key);
}