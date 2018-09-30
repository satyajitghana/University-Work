//
// Created by shadowleaf on 25-Sep-18.
//

#ifndef DATABASERECORDS_DATABASE_H
#define DATABASERECORDS_DATABASE_H

#include "vector.h"
#include "binary_tree.h"

struct Database {
    BTree* data_root;
    Vector* seq_data;
    int (*add)(struct Database*, void* data);
    int (*delete)(struct Database*, char* id);
    int (*search)(struct Database*,
            void* search_term,
            int (*comparator)(const void* data1, const void* data2));
    void (*print)(struct Database*);

    /* Sequential Data Methods */
    void (*sortSeqData)(struct Database*);
    int (*seqComparator)(const void*, const void*);

    /* DataType specific methods */
    int (*comparator)(const void* data1, const void* data2);
    void (*printOne)(void* data);
};

typedef struct Database Database;

Database* newDatabase(
        int (*)(const void*, const void*),
        int (*)(const void*, const void*),
        void (*)(void*));

int add_to_database(Database* mydatabase, void* data);

void printDatabase(Database* mydatabase);

void sort_seq_data(Database* mydatabase);

int search_database(Database*, void* param, int (*)(const void*, const void*));
int linear_search_database(Database*, void* param, int (*)(const void*, const void*));

#endif //DATABASERECORDS_DATABASE_H
