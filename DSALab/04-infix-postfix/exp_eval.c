#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include "exp_eval.h"
#include "stack.h"
#include "vector.h"

int precedence(char ch) {
    switch (ch) {
        case '+':
        case '-':
            return 1;
        case '*':
        case '/':
            return 2;
        case '^':
            return 3;
        default:
            return -1;
    }
}

int infix2postfix(char *expr) {
    const char delim[] = " \n";

    Vector* output = newMinimalVector(string_compare, print_one_string);
    Stack* stack = newStack(strlen(expr));

    char* token = strtok(expr, delim);

    while (token != NULL) {
        if (isdigit(token[0]) || strlen(token) > 1) { /* operand was encountered */
            output -> add(output, token);
        } else if (strlen(token) == 1
            && token[0] == '(') {
            stack -> push(stack, token);
        } else if (strlen(token) == 1
            && token[0] == ')') {
            while (!stack -> isEmpty(stack) && *(char*)(stack -> peek(stack)) != '(' ) {
                output -> add(output, stack -> pop(stack));
            }
            stack -> pop(stack);
        } else { /* operator was encountered */
            while (!stack -> isEmpty(stack) && precedence(token[0]) <= precedence(*(char*)(stack -> peek(stack)))) {
                output -> add(output, stack -> pop(stack));
            }
            stack -> push(stack, new_string(token));
        }
        token = strtok(NULL, delim);
    }

    while (!stack -> isEmpty(stack)) {
        output -> add(output, stack -> pop(stack));
    }

    output -> print(output);

    return 1;
}
