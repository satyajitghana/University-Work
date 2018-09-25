#ifndef LINKED_LIST_H
#define LINKED_LIST_H

#include <stdio.h>

struct LinkedList {
    void* data;
    struct LinkedList* next;
};

typedef struct LinkedList LinkedList;

LinkedList* head = NULL;

LinkedList* newLinkedList();
void add_to_list(LinkedList*);

#endif
