#include "linked_list.h"
#include <stdio.h>
#include <stdlib.h>
#include "debug_helper.h"

LinkedList* newLinkedList(void * data) {
    LinkedList* newList = malloc(sizeof *newList);
    newList -> next = NULL;
    newList -> data = data;
}

void add_to_list(LinkedList* to_add) {
    // if (head == NULL) {

    // }
    if (head == NULL)
        ds("Hi");    
}
