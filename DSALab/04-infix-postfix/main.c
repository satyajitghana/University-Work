#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include "stack.h"
#include "exp_eval.h"
#include "input_helper.h"
#include "debug_helper.h"

const char delim[] = " \n";

int main() {

    char *expression;
    printf("Enter an Infix Expression : ");
    get_sentence(&expression);
    printf("Given Infix Expression : %s\n", expression);
    printf("Postfix Expression : ");
    infix2postfix(expression);
    printf("\n");

    return 0;
}
