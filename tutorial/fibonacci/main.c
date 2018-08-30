#include <stdio.h>

int main() {
    int n = 10;
    int first = 0;
    int second = 1;
    int third;
    while (second < n) {
        third = first + second;
        printf("%d ", second);
        first = second;
        second = third;
    }
}
