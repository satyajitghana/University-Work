#include <stdio.h>
#include "LinkedList.h"
#include "HashMap.h"
#include "vector.h"
#include "debug_helper.h"

void lltest();

int main() {

    HashMap* mymap = newHashMap(10);
    mymap -> add(mymap, "I'm the Key", "I'm the Value");
    void* val = mymap -> get(mymap, "I'm the Key");
    if (val != NULL)
        ds(val);

    return 0;
}

void lltest() {
    LinkedList* mylist = newLinkedList(int_compare_ll, print_int);
    mylist -> add(mylist, new_int(10));
    mylist -> add(mylist, new_int(20));
    mylist -> add(mylist, new_int(30));
    mylist -> add(mylist, new_int(40));

    mylist -> remove(mylist, new_int(40));

    mylist -> print(mylist);

    printf("\nLength : %d\n", mylist -> length);
}