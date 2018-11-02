#include <stdio.h>
//#include "debug_helper.h"
//#include "binary_tree.h"
//#include "input_helper.h"

void btree_menu();
void main_menu();

int main() {
    int a = 10;
    printf("%d\n", a);
    return 0;
}

void btree_menu() {
    printf("\n---------- Stacks using Linked Lists ----------------------\n"
           "1.\tPush\n"
           "2.\tPop\n"
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
