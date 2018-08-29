#include <stdio.h>
#include <stdlib.h>

struct string {
    int length;
    char* data;
};

typedef struct string string;

int main() {
    string *lines = malloc(5 * sizeof *lines);
    for (int i = 0 ; i < 5 ; i++) {
        (*(lines + i)).length = i;
    }
    for (int i = 0 ; i < 5 ; i++) {
        printf("%d\n", (*(lines + i)).length);
    }
    return 0;
}
