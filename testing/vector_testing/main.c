#include <stdio.h>
#include "vector.h"
#include "input_helper.h"
#include "debug_helper.h"

int main() {
    Vector mylist;
    init(&mylist, print_string);
    char* line;
    get_line(&line);
    mylist.add(&mylist, line);
    mylist.print(&mylist);
}
