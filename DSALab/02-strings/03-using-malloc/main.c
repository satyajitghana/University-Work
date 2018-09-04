#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "input_helper.h"
#include "debug_helper.h"

void check_substring(char*, char*);

int main(int argc, char **argv) {
    
    char* word = malloc(1000 * sizeof *word);
    printf("Enter the word to be searched : ");
    scanf("%[^\n\t]s", word);
    word = realloc(word, strlen(word));

    char* sentence = malloc(1000 * sizeof *sentence);
    printf("Enter the sentence : ");
    scanf("\n%[^\n\t]s", sentence);
    sentence = realloc(sentence, strlen(sentence));

    check_substring(sentence, word);

    return 0;
}

void check_substring(char* sentence, char* word) {
    for (int _i = 0 ; _i < strlen(sentence) ; _i++)
        if (strncmp(sentence + _i, word, strlen(word)) == 0)
            printf("found at : %d\n", _i);
    printf("\n");
}
