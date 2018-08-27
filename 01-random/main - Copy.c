#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "timeutil.h"

/*
 * Author   : Satyajit Ghana
 * Reg.No   : 17ETCS002159
 * */

void help(void);

char *name;

int main(int argc, char **argv) {
    int n = 1, min = 0, max = RAND_MAX;
    char c;
    name = *argv;
    /* Seed rand with current system time */
    srand(time(0));

    while (--argc > 0 && (++argv)) {
        switch((c = **argv)) {
            case 'l':
                min = atoi(*++argv);
                max = atoi(*++argv);
                argc -= 2;
                break;
            case 'n':
                n = atoi(*++argv);
                argc--;
                break;
            case 'h':
                help();
                return 0;
            default:
                printf("%s: invalid character : %c\n", name, c);
                break;
        }
    }

    if (argc > 0) {
        help();
    }

    clock_t begin = clock();
    while(n--) {
        printf("%d\n", (rand()%(max - min + 1)) + min);
    }
    clock_t end = clock();
    printf("\nExecution Time : %.6fs\n", time_exec(begin, end));

    return 0;
}

void help() {
        printf("\nUSAGE: %s n <number> l <lower> <upper>\n"
        "\t n <numer>: quantity of pseudo-numbers to generate\n"
        "\t l <lower_limit> <upper_limit>\n"
        "\t example: %s 10 l 2 10\n"
        "\t\tgenerates 10 pseudo-random numbers from [2, 10]\n", name, name);
}
