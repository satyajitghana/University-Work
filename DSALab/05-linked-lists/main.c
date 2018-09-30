#include <stdio.h>
#include "vector.h"
#include "input_helper.h"
#include "linked_list.h"

void menu();

int main() {
    LinkedList* head = NULL;
    char* input;
    while(1) {
        menu();
        int choice = next_int();
        switch (choice) {
            case 1:
                printf("\nEnter your Data : ");
                get_line(&input);
                add_at_end_of_list(&head, newLink(input));
                break;
            case 2:
                printf("\nEnter your Data : ");
                get_line(&input);
                add_at_beg_of_list(&head, newLink(input));
                break;
            case 3: {
                LinkedList *deleted = remove_from_end_of_list(&head);
                if (deleted != NULL) {
                    printf("\nDeleted Link : ");
                    print_link(deleted);
                }
            }
                break;
            case 4: {
                LinkedList *deleted = remove_from_beg_of_list(&head);
                if (deleted != NULL) {
                    printf("\nDeleted Link : ");
                    print_link(deleted);
                }
            }
                break;
            case 5:
                print_list(head);
                break;
            case 6:
                return 0;
            default:
                printf("\nInvalid Choice !\n");
        }
    }
}

void menu() {
    printf("\n---------- Linked Lists ----------------------\n"
           "1.\tAdd at the End of List\n"
           "2.\tAdd at the Beginning of List\n"
           "3.\tRemove from the End of the List\n"
           "4.\tRemove from the Beginning of the List\n"
           "5.\tDisplay the List\n"
           "6.\tExit\n"
           "\nYour Choice : ");
}
