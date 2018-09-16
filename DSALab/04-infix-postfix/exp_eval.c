#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include "exp_eval.h"
#include "stack.h"

bool is_operand(char ch) {
    return isalpha(ch);
}

int precedence(char ch) {
    switch(ch) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
    }
    return -1;
}

int infix2postfix(char *expr) {
    int i = 0, k = 0;
    char *output = malloc(strlen(expr) * sizeof *output);
    Stack* stack = newStack(strlen(expr));

    while (expr[i]) {
        if (is_operand(expr[i])) {
            output[k++] = expr[i];
        }

        else if (expr[i] == '(') {
            stack -> push (stack, (void*)expr[i]);
        }
    }
}
