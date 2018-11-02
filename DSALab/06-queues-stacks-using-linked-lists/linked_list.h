#ifndef LINKED_LIST_H
#define LINKED_LIST_H

#include <stdio.h>
#include "debug_helper.h"

struct LinkedList {
    void* data;
    struct LinkedList* next;
};

typedef struct LinkedList LinkedList;

LinkedList* newLink(void* data);

/* LinkedList Methods */
void add_at_end_of_list(LinkedList**, LinkedList*);
void add_at_beg_of_list(LinkedList** head, LinkedList* toadd);
LinkedList* remove_from_end_of_list(LinkedList** head);
LinkedList* remove_from_beg_of_list(LinkedList** head);


/* Printing the List */
void print_list(LinkedList* head);
void print_link(LinkedList* link);

#endif
