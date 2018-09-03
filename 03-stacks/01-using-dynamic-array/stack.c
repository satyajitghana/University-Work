#include <stdio.h>
#include <stdlib.h>
#include "stack.h"
#include "input_helper.h"
#include "debug_helper.h"

void init_stack(Stack* mystack, int max_size) {
    mystack -> top = -1;
    mystack -> data = NULL;
    mystack -> MAX = max_size;
}

void push(Stack* mystack, void* data) {

    if (mystack -> top >= mystack -> MAX) {
        printf("\n*Stack Overflow Detected !*\n");
        return;
    }

    mystack -> data = realloc(mystack -> data, (mystack -> top + 2) * sizeof *(mystack -> data));    
    if (mystack -> data != NULL) {
        (mystack -> data)[(++mystack -> top)] = data;
        //((mystack -> data)[++mystack -> top]) = data;
        //di(mystack -> top);
        //ds((char*)data);
        //ds((char*)((mystack -> data)[mystack ->top]));

    } else {
        printf("\n*cannot allocate memory !*\n");
    }
}

void pop(Stack* mystack) {
    if (mystack -> top -1 < 0) {
        printf("\n*Stack Underflow detected !*\n");
        return;
    }

    mystack -> top--;
    /* Resize the data array as the elements are removed */
    mystack -> data = realloc(mystack -> data, (mystack -> top + 1) * sizeof *(mystack-> data));

    /* Print the removed data */
    printf("removed");
    ds((char*)(mystack->data)[mystack -> top+1]);
}

void display(Stack* mystack) {
    for (int i = mystack -> top  ; i >= 0 ; i--) {
        //printf("%s\n", *(char**)((mystack->data)[i]));
        di(i);
        //ds((char*)((mystack->data)[i]));
        ds(*(char**)(mystack->data + i))
    }
}
