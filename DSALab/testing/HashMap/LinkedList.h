//
// Created by shadowleaf on 06-Nov-18.
//

#ifndef LINKEDLIST_H
#define LINKEDLIST_H

struct LLNode {
    struct LLNode* next;
    void* data;
};

typedef struct LLNode LLNode;

typedef int (*Comparator)(const void*, const void*);

struct LinkedList {
    LLNode* head;
    int length; // keep track of the length of the list
    void (*add)(struct LinkedList*, void*);
    void* (*get)(struct LinkedList*, void*, Comparator); // to get the item using the comparator
    //    void* (*get)(struct LinkedList*, int); // to get the item at that index
    void (*remove)(struct LinkedList*, void*); // works on the object and uses comparator
    void (*printOne)(void*); // Tell me how can i print one of your data in the linked list
    Comparator comparator; // to compare two of the items, needed to sort and delete
    void (*print)(struct LinkedList*); // prints the whole list
};

/* You know what ? i'm dumb, instead of having to do printone function i could just ask the data type to print itself
 * but, then i'll have to invent primitives, soooooo chuck it, you can theoretically store any kind of data, though,
 * its the job of the programmer to keep track of what kind of data it is, so when you fetch it, you should know how to
 * dereference it.*/

typedef struct LinkedList LinkedList;

//#define LinkedList* __LLPointer__
//#define void* __VOIDPointer__
//#define __newLLNode__(x) newLLNode(x);

/* core methods */

LinkedList* newLinkedList(Comparator, void (*)(void*));

//#define add(__LLPointer__, __VOIDPointer__) _add(__LLPointer__, __newLLNode__);
//void _add(LinkedList* ll, void* data);
void add_to_linked_list(LinkedList* ll, void* data);

void print_linked_list(LinkedList* ll);

void remove_from_linked_list(LinkedList*, void*);

void* get_linked_list(LinkedList* myll, void* data, Comparator comparator);

/* LLNode Methods */
LLNode* newLLNode(void*);

/* Comparator methods */
int     int_compare_ll(const void *, const void *);
int     int_compare_r_ll(const void *, const void *);
int     string_compare_ll(const void *, const void *);
int     string_compare_r_ll(const void *, const void *);

#endif //HASHMAP_LINKEDLIST_H
