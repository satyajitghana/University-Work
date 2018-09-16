#include <stdio.h>
#include "stack.h"
#include "input_helper.h"
#include "debug_helper.h"

int main() {
    char *expression;
    get_sentence(&expression);
    ds(expression);
    return 0;
}
