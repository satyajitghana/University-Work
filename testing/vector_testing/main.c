#include <stdio.h>
#include <stdbool.h>
#include "vector.h"
#include "input_helper.h"
#include "debug_helper.h"

void test_strings();
void test_ints();

int main() {
    test_ints();
}

void test_ints() {
    int arr[10] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    Vector mylist;
    init(&mylist, print_int, int_compare, int_compare_r);

    for (int i = 0 ; i < 10 ; i++) {
        mylist.add(&mylist, &arr[i]);
    }

    mylist.print(&mylist);
    printf("\nNow Sorted\n");
    mylist.sort(&mylist, false);
    mylist.print(&mylist);
}

void test_strings() {
    Vector mylist;
    init(&mylist, print_string, int_compare, int_compare_r);
    char* line;
    get_line(&line);
    mylist.add(&mylist, line);
}
