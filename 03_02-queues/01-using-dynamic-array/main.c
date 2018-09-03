#include <stdio.h>
#include <stdlib.h>
#include "queue.h"
#include "input_helper.h"
#include "debug_helper.h"
#include "vector.h"

void menu();
void clear_buffer();

Queue myqueue;

int main() {
    //Stack mystack;
    init_queue(&myqueue, 10);
    /*enqueue(&myqueue, new_string("satyajit"));
    enqueue(&myqueue, new_string("shubham chutiya"));
    enqueue(&myqueue, new_string("shubham chutiya 2"));
    dequeue(&myqueue);
    dequeue(&myqueue);
    display(&myqueue);*/
    menu();
    return 0;
}

void menu(){
    while (1) {
        printf("--- QUEUES USING DYNAMIC ALLOCATIONS ---\n"
               "1.\tEnqueue\n"
               "2.\tDequeue\n"
               "3.\tDisplay\n"
               "4.\tExit\n"
               "\nEnter your choice : ");
        char choice;
        choice = getchar();
        clear_buffer();
        switch(choice) {
            case '1': {
                    char* string;
                    printf("\nEnter your data : ");
                    get_sentence(&string);
                    enqueue(&myqueue, new_string(string));
                }
                break;
            case '2':
                dequeue(&myqueue);
                break;
            case '3':
                display(&myqueue);
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

void clear_buffer() {
    //fflush(stdin);
    int c;
    while ( (c = getchar()) != '\n' && c != EOF)
        ;
}
