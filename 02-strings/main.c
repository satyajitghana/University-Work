#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "input_helper.h"
#include "debug_helper.h"
#include "vector.h"

void check_substring(Vector, char*);

int main(int argc, char **argv) {
    Vector mylist;
    init(&mylist, print_string);
    
    char* word;
    printf("Enter the word to be searched : ");
    get_word(&word);
    printf("Note: Blank line to end adding more lines\n");
    char* sentence;
    printf("Enter the sentences : \n");
    while (get_line(&sentence) > 0) {
        mylist.add(&mylist, new_string(sentence));
        free(sentence);
    }
    check_substring(mylist, word);

    return 0;
}

void check_substring(Vector mylist, char* word) {
    for (int i = 0 ; i < mylist.length ; i++) {
        printf("line[%d] :\n", i);
        char* curr_string = *mylist.data;
        for (int _i = 0 ; _i < strlen(curr_string) ; _i++) {
            if (strncmp(curr_string + _i, word, strlen(word)) == 0) {
                printf("found at : %d\n", _i);
            }
        }
        printf("\n");
    }
}
