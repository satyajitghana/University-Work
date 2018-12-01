#include <stdio.h>

#define MAX 100

int list[MAX] = {1, 2, 3, 4, 5}, n = 5;

void menu();
void load_data();
void linear_search();
void binary_search();
int bsearch(int [], int, int, int);
void merge_sort(int [], int, int);
void merge(int [], int, int, int);
void insertion_sort(int [], int);

void print_array(int[], int);

int main() {
    menu();
    return 0;
}

void menu() {
    while (1) {
        int choice;
        printf("\nSearching and Sorting"
               "\n1.\tEnter List Data"
               "\n2.\tLinear Search"
               "\n3.\tBinary Search"
               "\n4.\tMerge Sort"
               "\n5.\tInsertion Sort"
               "\n6.\tExit"
               "\nEnter your choice : ");
        scanf("%d", &choice);

        switch (choice) {
            case 1 :
                load_data();
                break;
            case 2 :
                linear_search();
                break;
            case 3 :
                binary_search();
                break;
            case 4 :
                printf("\nBefore Sorting : \n");
                print_array(list, n);
                merge_sort(list, 0, n-1);
                printf("\nAfter Sorting : \n");
                print_array(list, n);
                break;
            case 5 :
                printf("\nBefore Sorting : \n");
                print_array(list, n);
                insertion_sort(list, n);
                printf("\nAfter Sorting : \n");
                print_array(list, n);
                break;
            case 6 :
                return;
            default :
                printf("Wrong Choice !\n");
        }
    }
}

void load_data() {
    printf("\nEnter the number of elements : ");
    scanf("%d", &n);

    printf("\nEnter %d Elements : ", n);
    for (int i = 0 ; i < n ; i++) {
        scanf("%d", &list[i]);
    }
}

void linear_search() {
    int to_search;
    printf("\nEnter the element to search for : ");
    scanf("%d", &to_search);

    int found = 0;
    for (int i = 0 ; i < n ; i++) {
        if (list[i] == to_search) {
            printf("\nFound %d at %d\n", to_search, i);
            found = 1;
            break;
        }
    }

    if (found == 0) {
        printf("\nElement not found ! \n");
    }
}

void binary_search() {
    int to_search;
    printf("\nEnter the element to search for : ");
    scanf("%d", &to_search);

    int found;
    if ((found = bsearch(list, to_search, 0, n-1)) > -1) {
        printf("\nFound %d at %d\n", to_search, found);
    } else {
        printf("\nElement not found !\n");
    }
}

int bsearch(int arr[], int ele, int start, int end) {
    if (end >= start) {
        int mid = (start + end) / 2;

        if (arr[mid] == ele)
            return mid;

        if (arr[mid] > ele)
            return bsearch(arr, ele, start, mid - 1);

        return bsearch(arr, ele, mid + 1, end);
    }

    return -1;
}

void merge_sort(int arr[], int l, int r) {
    if (l < r) {
        int m = (l + r) / 2;

        merge_sort(arr, l, m);
        merge_sort(arr, m+1, r);

        merge(arr, l, m, r);
    }
}

void merge(int arr[], int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;

    int L[n1], R[n2];

    for (int i = 0 ; i < n1 ; i++)
        L[i] = arr[l + i];
    for (int j = 0 ; j < n2 ; j++)
        R[j] = arr[m + 1 + j];

    int i = 0;
    int j = 0;
    int k = l;

    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }

}

void insertion_sort(int arr[], int n) {
    int key, j;
    for (int i = 0 ; i < n ; i++) {
        key = arr[i];
        j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j+1] = arr[j];
            j = j - 1;
        }

        arr[j+1] = key;
    }
}

void print_array(int arr[], int size) {
    for (int i = 0 ; i < size ; i++)
        printf(" %d", arr[i]);
    printf("\n");
}
