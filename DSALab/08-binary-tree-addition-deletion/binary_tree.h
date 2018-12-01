//
// Created by shadowleaf on 25-Sep-18.
//

#ifndef DATABASERECORDS_BINARY_TREE_H
#define DATABASERECORDS_BINARY_TREE_H

typedef int (*Comparator)(const void*, const void*);

// Make a get parameter

struct BTree {
    struct BTree* left;
    void* data;
    struct BTree* right;

    void (*add)(struct BTree** root, struct BTree* data,
            Comparator comparator);
    void (*printData)(void* leaf);
};

typedef struct BTree BTree;

BTree* newLeaf(void* data, void (*printData)(void* leaf));

BTree* search_tree(BTree* root, void* param, Comparator comparator);

void add_to_tree(BTree** root, BTree* data, Comparator comparator);

BTree* delete_from_tree(BTree* root, void* param, Comparator comparator);

/* Helper Method */
BTree* min_leaf(BTree*);

void printBTree(BTree* node);
#endif //DATABASERECORDS_BINARY_TREE_H
