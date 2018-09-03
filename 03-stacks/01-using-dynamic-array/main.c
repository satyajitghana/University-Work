#include <stdio.h>
#include <stdlib.h>
#include "stack.h"
#include "input_helper.h"
#include "debug_helper.h"
#include "vector.h"

void menu();

Stack mystack;

int main() {
    //Stack mystack;
    init_stack(&mystack, 10);
    //push(&mystack, new_string("satyajit"));
    //push(&mystack, new_string("shubham chutiya"));
    //pop(&mystack);
    //display(&mystack);
    menu();
    return 0;
}

void menu(){
    while (1) {
        printf("--- STACKS USING DYNAMIC ALLOCATIONS ---\n"
               "1.\tPush\n"
               "2.\tPop\n"
               "3.\tDisplay\n"
               "4.\tExit\n"
               "\nEnter your choice : ");
        char choice;
        choice = getchar();
        getchar();
        switch(choice) {
            case '1': {
                char* string;
                get_sentence(&string);
                push(&mystack, new_string(string));
                }
                break;
            case '2':
                pop(&mystack);
                break;
            case '3':
                display(&mystack);
                break;
            case '4':
                exit(0);
                break;
            default:
                printf("\nWrong Choice !\n");
                break;
        }
    }
}
