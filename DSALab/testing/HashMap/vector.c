#include <stdio.h>
#include <string.h>
#include <stdarg.h>
#include "vector.h"
#include "debug_helper.h"

typedef int (*Comparator)(const void*, const void*);

Vector* newVector(void (*print_util)(Vector*),
        int (*compare)(const void*, const void*),
        int (*compare_r)(const void*, const void*)) {
    Vector* myVector = malloc(sizeof *myVector);
    init(myVector, print_util, compare, compare_r);
    return myVector;
}

Vector* newMinimalVector(Comparator comparator,
        void (*printOne)(void*)) {
    Vector* myVector = malloc(sizeof *myVector);
    myVector -> length = 0;
    myVector -> data = NULL;
    myVector -> get = get;
    myVector -> add = add;
    myVector -> remove = del;
    myVector -> print = print_vector;
    myVector -> printOne = printOne;
    myVector -> search = linear_search_vector;
    myVector -> comparator = comparator;

    return myVector;
}

Vector* _newMinimalVectorWithArgs(Comparator comparator, void (*printOne)(void*), size_t argc, ...) {
    Vector* thisVector = newMinimalVector(comparator, printOne);

    va_list valist;

    // va_start takes the valist and the last parameter before the "..."
    va_start(valist, argc);
    for (int i = 0 ; i < argc ; i++) {
        // printf("*%d*", va_arg(valist, int));
        thisVector -> add (thisVector, va_arg(valist, void*));
    }
    va_end(valist);
    return thisVector;
}

void init(Vector *list,
        void (*print_util)(Vector*),
        int (*compare)(const void*, const void*),
        int (*compare_r)(const void*, const void*)) {
    list -> get = get;
    list -> length  = 0;
    list -> data    = NULL;
    list -> print   = print_util;
    list -> add     = add;
    list -> remove  = del;
    list -> comparator = compare;
    list -> comparator_r = compare_r;
    list -> sort = sort;
    list -> search = linear_search_vector;
}

void* get(Vector *list, int loc) {
    return (list -> data)[loc];
}

void add(Vector *list, void * DATA) {
    list -> data = realloc(list -> data, sizeof *(list -> data) * (list -> length + 1));
    (list -> data)[(list -> length)] = DATA;
    list -> length++;
}

void del(Vector *list, int index) {
    for (int i = index ; i < list -> length - 1 ; i++) {
        (list -> data)[i] = (list -> data)[i+1];
    }
    list -> length --;
    list -> data = realloc(list -> data, sizeof *(list -> data) * (list -> length));
}

void sort(Vector *list, bool descending) {
    if (descending)
        qsort(list -> data, (size_t)list -> length,
            sizeof *(list -> data),
            list -> comparator_r);
    else 
        qsort(list -> data, (size_t)list -> length,
            sizeof *(list -> data),
            list -> comparator);
}

/* Searching Algorithms */
int linear_search_vector(Vector* list, void* param, int (*comparator)(const void*, const void*)) {
    for (int i = 0 ; i < list -> length ; i++) {
        if (comparator(list -> data[i], param) == 0) {
            list->printOne(list->data[i]);
            return i;
        }
    }

    return -1;
}

/* Comparator Functions */
int int_compare(const void * a1, const void * a2) {
    // di(**((const int**)a1));
    if (**((const int**) a1) > **((const int**) a2)) return 1;
    if (**((const int**) a1) < **((const int**) a2)) return -1;
    return 0;
} 

int int_compare_r(const void * a1, const void * a2) {
    // di(**((const int**)a1));
    if (**((const int**) a1) > **((const int**) a2)) return -1;
    if (**((const int**) a1) < **((const int**) a2)) return 1;
    return 0;
} 

int string_compare(const void * s1, const void * s2) {
    return strcmp(*(const char**)s1, *(const char**)s2);
}

int string_compare_r(const void * s1, const void * s2) {
    return (-1)*strcmp(*(const char**)s1, *(const char**)s2);
}

/* Generic Print Utility */
void print_vector(Vector* list) {
    for (int i = 0 ; i < list -> length ; i++) {
        list -> printOne(list -> data[i]);
    }
}

/*Print Utils*/

void print_int_vector(Vector *list) {
    for (int i = 0 ; i < list -> length ; i++) {
        di(*(int *)((list -> data)[i]));
    } 
}

void print_string_vector(Vector *list) {
    for (int i = 0 ; i < list -> length ; i++) {
        ds((char *)((list -> data)[i]))
    }
}

/* Single Data Print Utils */
void print_int(void* data) {
    printf("%d", (*(int*)data));
}

void print_string(void* data) {
    printf("%s", ((char*)data));
}

/* New Data of Specific DataType Methods */

void* new_int(int data) {
    int* new_data = malloc(sizeof *new_data);
    *new_data = data;
    return new_data;
}

void* new_double(double data) {
    double* new_data = malloc(sizeof *new_data);
    *new_data = data;
    return new_data;
}

void* new_string(char* data) {
    char* new_data = malloc(strlen(data) * sizeof *new_data);
    strcpy(new_data, data);
    return new_data;
}

/* Other Sorting Techniques */
void insertion_sort(void** arr, size_t length, size_t ele_size, int (*comparator)(const void* data1, const void* data2)) {
    void* key;
    for (int i = 1 ; i < length ; i++) {
        key = arr[i];
        int j = i - 1;
        while (j >= 0 && comparator(arr[j], key) >= 0) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
    }
}

