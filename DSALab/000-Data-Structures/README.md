# Vectors

This was my first ADT, let's see what it contains for now.

Here's a example code

```c
    #include <stdio.h>
    #include <stdbool.h>
    #include "vector.h"
    #include "input_helper.h"
    #include "debug_helper.h"

    int main() {
        // Create the Vector
        Vector mylist;

        // Initialize the list
        init(&mylist, print_int, int_compare, int_compare_r);

        // adds integer 5 to the vector
        mylist.add(&mylist, new_int(5));

        // print the data
        mylist.print(&mylist);

        // delete the element at index 0
        mylist.remove(&mylist, 1);
    }
```

See ``../../testing`` folder for more example code

# Structure and Methods

``init``
Params: address of vector list created, print utility, comparator, reverse comparator
Returns: nothing

Explanation:
When you create the list you need a self reference, so that it can be initialized, the print\_int is used so that when you call the print method, it can print that int, it's data type specific, that's why it's required, same for the compartor, that's required for sorting the vector.

``print``
Params: self reference
Output: prints the elements stored in the vector

``sort``
Params: self reference, boolean true/false (true if you want it sorted in descending)

``add``
Params: self reference, reference to the data to be added to the list

``remove``
Params: self reference, int index to be removed
Uses a rudimentary O(n) time to move the data, should have used linked lists or something better.

``new_int``
Params: int
Returns: a void pointer to the data

``new_string``
Params: pointer to the string
Returns: a void pointer to the string

``print_int``
Params: self reference
This will print all the data stored in the vector.

# Attributes

``length``
Simply the length of the vector

## Notes:
maybe try something like this, because i repeatedly use some comparator function that i could reduce the code of.

```c
#define operation(name, op, dtype)                              \
    static dtype dtype ## _ ## name(dtype val1, dtype val2) {   \
        return (val1 op val2);                                  \
    }

#define operation1(op, val1, val2) (val1 op val2) 

#include <stdio.h>

operation(plus, +, int)

int main() {
    int sum = int_plus(15, 3);
    int sum2 = operation1(+, 15, 3);
    printf("%d\n%d\n", sum, sum2);
}
}```