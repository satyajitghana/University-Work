#include <stdio.h>
#include "debug_helper.h"
#include "input_helper.h"
#include "binary_tree.h"

void main_menu();
void display_menu();

int main() {
    BTree* root = NULL;
    int choice;
    while (1) {
        main_menu();
        choice = next_int();
        switch (choice) {
            case 1 : {

            }
                break;
            case 2: {

            }
                break;
            case 3: {
                display_menu();
                choice = next_int();
                switch (choice) {
                    case 1: {

                    }
                        break;
                    case 2: {

                    }
                        break;
                    case 3: {

                    }
                        break;
                    default:
                        printf("Wrong choice \n");
                }
            }
                break;
            case 4:
                return 0;

            default:
                printf("Wrong Choice \n");
        }
    }
    return 0;
}

void main_menu() {
    printf("\n---------- Binary Trees ----------------------\n"
           "1.\tInsert\n"
           "2.\tDelete\n"
           "3.\tDisplay\n"
           "4.\tExit\n"
           "\nYour Choice : ");
}

void display_menu() {
    printf("\n---------- Display Operations ----------------------\n"
           "1.\tInOrder\n"
           "2.\tPostOrder\n"
           "3.\tPreOrder"
           "4.\tExit\n"
           "\nYour Choice : ");
}