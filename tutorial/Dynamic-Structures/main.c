#include <stdio.h>
#include <stdlib.h>
#include "input_helper.h"
#include "debug_helper.h"

void find_max(int *arr, int n);
void array_sum(int *arr, int n);

int main() {
    int *arr, n;
    printf("\nEnter number of elements : ");
    n = next_int();
    arr = calloc(n, sizeof *arr);
    for (int i = 0 ; i < n ; i++) {
        printf("Enter element [%d] : ", i);
        *(arr + i) = next_int();
    }
    dai(arr, 0, n);
    find_max(arr, n);
    array_sum(arr, n);
}

void find_max(int* arr, int n) {
    int max = arr[0];
    for (int i = 1 ; i < n ; i++)
        if (arr[i] > max) max = arr[i];
    printf("\nMax is %d\n", max);
}

void array_sum(int *arr, int n) {
    int sum = 0;
    for (int i = 0 ; i < n ; i++) {
        sum += arr[i];
    }
    printf("\nSum is %d\n", sum);
}
