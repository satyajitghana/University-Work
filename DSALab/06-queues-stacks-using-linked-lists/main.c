#include <stdio.h>
#include "vector.h"
#include "input_helper.h"
#include "linked_list.h"

enum {
    STACK=1,
    QUEUE=2
};

void stack_menu();
void main_menu();
void queue_menu();

int main() {
    LinkedList* head = NULL;
    int choice;
    char* input;
    main_menu();
    choice = next_int();
    switch (choice) {
        case STACK: {
            while (1) {
                stack_menu();
                choice = next_int();
                switch (choice) {
                    case 1: {
                        printf("\nEnter your Data : ");
                        get_line(&input);
                        add_at_end_of_list(&head, newLink(input));
                    }
                        break;
                    case 2: {
                        LinkedList* deleted = remove_from_end_of_list(&head);
                        if (deleted != NULL) {
                            printf("\nDeleted : ");
                            print_link(deleted);
                        }
                    }
                        break;
                    case 3: {
                        print_list(head);
                    }
                        break;
                    case 4:
                        return 0;
                    default:
                        printf("\nInvalid Choice !\n");
                }
            }
        }
        case QUEUE: {
            while (1) {
                queue_menu();
                choice = next_int();
                switch (choice) {
                    case 1: {
                        printf("\nEnter your Data : ");
                        get_line(&input);
                        add_at_end_of_list(&head, newLink(input));
                    }
                        break;
                    case 2: {
                        LinkedList* deleted = remove_from_beg_of_list(&head);
                        if (deleted != NULL) {
                            printf("\nDeleted : ");
                            print_link(deleted);
                        }
                    }
                        break;
                    case 3: {
                        print_list(head);
                    }
                        break;
                    case 4:
                        return 0;
                    default:
                        printf("\nInvalid Choice !\n");
                }
            }
        }
        default:
            printf("\nWrong Choice !\n");
            break;
    }
}

void stack_menu() {
    printf("\n---------- Stacks using Linked Lists ----------------------\n"
           "1.\tPush\n"
           "2.\tPop\n"
           "3.\tDisplay\n"
           "4.\tExit\n"
           "\nYour Choice : ");
}

void queue_menu() {
    printf("\n---------- Queues using Linked Lists ----------------------\n"
           "1.\tEn-queue\n"
           "2.\tDe-queue\n"
           "3.\tDisplay\n"
           "4.\tExit\n"
           "\nYour Choice : ");
}

void main_menu() {
    printf("\n-----------STACK AND QUEUES USING LINKED LISTS------\n"
           "1.\tStacks\n"
           "2.\tQueues\n"
           "\nYour Choice : ");
}
