//
// Created by shadowleaf on 25-Sep-18.
//

#include <stdlib.h>
#include "database.h"
#include "city_data.h"
#include "vector.h"
#include "debug_helper.h"

/* When you create an instance of my Database, tell me how can i compare two of your data inputs,
 * tell me how can i print one of those data, that's it, i'll take care of things from here*/
Database* newDatabase(
        int (*comparator)(const void* data1, const void* data2),
        int (*seq_comparator)(const void* data1, const void* data2),
        void (*printOne)(void* data)) {
    Database* mydatabase = malloc(sizeof *mydatabase);
    mydatabase -> data_root = NULL;
    mydatabase -> seq_data = newMinimalVector(comparator, printOne);
    mydatabase -> add = add_to_database;
    mydatabase -> print = printDatabase;
    mydatabase -> search = search_database;

    /* Sequential Data Method */
    mydatabase -> sortSeqData = sort_seq_data;
    mydatabase -> seqComparator = seq_comparator;

    /* DataType specific methods */
    mydatabase -> comparator = comparator;
    mydatabase -> printOne = printOne;

    return mydatabase;
}

/* To Search the database */
// Comparator must check between your data and your parameter of your data
int search_database(Database* mydatabase, void* param, int (*comparator)(const void*, const void*)) {
    BTree* res = search_tree(mydatabase -> data_root, param, comparator);
    if (res != NULL) {
        res -> printData(res -> data);
        return 1;
    } else {
        printf("\n NO SUCH RECORD EXIST!\n");
        return -1;
    }
}

/* Return the position of data in Sequential List of data, then do whatever you want with it */
int linear_search_database(Database* mydatabase, void* param, int (*comparator)(const void*, const void*)) {
    return (mydatabase -> seq_data -> search(mydatabase -> seq_data, param, comparator));
}

/* To add data to the database */
int add_to_database(Database* mydatabase, void* data) {
    mydatabase -> seq_data -> add(mydatabase -> seq_data, data);
    insertion_sort(mydatabase -> seq_data -> data, (size_t)mydatabase -> seq_data -> length, sizeof *(mydatabase -> seq_data -> data), compare_id);
    BTree* newNode = newLeaf(data, mydatabase -> printOne);
    add_to_tree(&mydatabase -> data_root, newNode, mydatabase -> comparator);
}

/* To Print the complete database */
void printDatabase(Database* mydatabase) {
    printBTree(mydatabase -> data_root);
}

/* Sequential Data Methods */
void sort_seq_data(Database* mydatabase) {
    insertion_sort(mydatabase -> seq_data -> data, (size_t)mydatabase -> seq_data -> length, sizeof *(mydatabase -> seq_data -> data), mydatabase -> seqComparator);
}