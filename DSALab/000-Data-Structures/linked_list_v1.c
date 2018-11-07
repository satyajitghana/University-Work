#include <stdio.h>
#include <stdlib.h>
#include "debug_helper.h"
#include "linked_list.h"

LinkedList* newLink(void * data) {
    LinkedList* newList = malloc(sizeof *newList);
    newList -> next = NULL;
    newList -> data = data;

    return newList;
}

/* Methods to add a Link */
void add_at_end_of_list(LinkedList** head, LinkedList* toadd) {
    if (*head == NULL) {
        *head = toadd;
//        print_link(toadd);
        return;
    }

    toadd -> next = (*head);
    *head = toadd;
}

void add_at_beg_of_list(LinkedList** head, LinkedList* toadd) {
    if (*head == NULL) {
        *head = toadd;
        return;
    }

    add_at_beg_of_list(&((*head) -> next), toadd);
}

/* Methods to delete a Link */
LinkedList* remove_from_end_of_list(LinkedList** head) {
    if (*head == NULL)
        printf("\nList is Empty !\n");

    LinkedList* temp = *head;
    *head = (*head) -> next;
    return temp;
}

LinkedList* remove_from_beg_of_list(LinkedList** head) {
    if (*head == NULL)
        printf("\nList is Empty !\n");

    LinkedList* temp = *head;
    LinkedList* prev = NULL;

    while (temp -> next != NULL) {
        prev = temp;
        temp = temp -> next;
    }

    if (prev == NULL)
        return NULL;

    prev -> next = NULL;

    return temp;
}

void print_list(LinkedList* head) {
    if (head == NULL) {
        return;
    }
    print_list(head -> next);
    ds((char*)(head -> data));
}

void print_link(LinkedList* link) {
    ds((char*)(link -> data));
}