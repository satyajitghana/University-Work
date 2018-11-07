//
// Created by shadowleaf on 06-Nov-18.
//

#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>

#include "LinkedList.h"
#include "debug_helper.h"

typedef int (*Comparator)(const void*, const void*);

/* core methods */
LinkedList* newLinkedList(Comparator comparator, void (*printOne)(void*)) {
    LinkedList* newLL = malloc(sizeof *newLL);
    newLL -> head = NULL;
    newLL -> get = get_linked_list;
    newLL -> add = add_to_linked_list;
    newLL -> remove = remove_from_linked_list;
    newLL -> comparator = comparator;
    newLL -> print = print_linked_list;
    newLL -> printOne = printOne;

    return newLL;
}

void add_to_linked_list(LinkedList* ll, void* data) {
    LLNode* newNode = newLLNode(data);

    newNode -> next = ll -> head;
    ll -> head = newNode;

    ll -> length++;
}

void* get_linked_list(LinkedList* myll, void* data, Comparator comparator) {
    LLNode* head;
    for (head = myll -> head; head != NULL ; head = head -> next) {
        if (comparator(data, head -> data) == 0)
            return head -> data;
    }

    return NULL; // not found
}

void print_linked_list(LinkedList* myll) {
    LLNode* head;
    for (head = myll -> head; head != NULL ; head = head -> next) {
        myll -> printOne(head -> data);
        printf(" , ");
    }
}

void remove_from_linked_list(LinkedList* myll, void* toRemove) {
    LLNode* node;
    LLNode* prev = NULL;

//    assert(myll -> head != NULL);

    for (node = myll -> head ; node != NULL; prev = node, node = node -> next) {
        if (myll -> comparator(toRemove, node -> data) == 0) { // found you bitch
            if (prev == NULL) { // beginning of the list ?
                myll -> head = node -> next;
            } else {
                prev -> next = node -> next;
            }
            // free the memory;
            free(node -> data);
            free(node);

            // reduce the length
            myll -> length--;
            return;
        }
    }
}

/* LLNode Methods */
LLNode* newLLNode(void* data) {
    LLNode* newNode = malloc(sizeof *newNode);
    newNode -> next = NULL;
    newNode -> data = data;

    return newNode;
}

/* Comparator Functions */
int int_compare_ll(const void * a1, const void * a2) {
    // di(**((const int**)a1));
    if (*((const int*) a1) > *((const int*) a2)) return 1;
    if (*((const int*) a1) < *((const int*) a2)) return -1;
    return 0;
}

int int_compare_r_ll(const void * a1, const void * a2) {
    // di(**((const int**)a1));
    if (*((const int*) a1) > *((const int*) a2)) return -1;
    if (*((const int*) a1) < *((const int*) a2)) return 1;
    return 0;
}

int string_compare_ll(const void * s1, const void * s2) {
    return strcmp((const char*)s1, (const char*)s2);
}

int string_compare_r_ll(const void * s1, const void * s2) {
    return (-1)*strcmp((const char*)s1, (const char*)s2);
}
