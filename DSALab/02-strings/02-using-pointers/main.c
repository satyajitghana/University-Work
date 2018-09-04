#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "input_helper.h"
#include "debug_helper.h"
#include "vector.h"

void check_substring(char*, char*);

int main(int argc, char **argv) {
    char* word;
    printf("Enter the word to be searched : ");
    get_word(&word);
    char* sentence;
    printf("Enter the sentences : \n");
    while (get_line(&sentence) > 0) {
        check_substring(sentence, word);
    }

    return 0;
}

void check_substring(char* sentence, char* word) {
    for (int _i = 0 ; _i < strlen(sentence) ; _i++)
        if (strncmp(sentence + _i, word, strlen(word)) == 0)
            printf("found at : %d\n", _i);
    printf("\n");
}
