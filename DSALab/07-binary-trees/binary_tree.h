//
// Created by shadowleaf on 25-Sep-18.
//

#ifndef DATABASERECORDS_BINARY_TREE_H
#define DATABASERECORDS_BINARY_TREE_H

struct BTree {
    struct BTree* left;
    void* data;
    struct BTree* right;

    void (*add)(struct BTree** root, struct BTree* data,
            int (*comparator)(void* data1, void* data2));
    void (*printData)(void* leaf);
};

typedef struct BTree BTree;

BTree* newLeaf(void* data, void (*printData)(void* leaf));

BTree* search_tree(BTree* root, void* param, int (*comparator)(const void* data1, const void* data2));

void add_to_tree(BTree** root, BTree* data, int (*comparator)(const void* data1, const void* data2));
BTree* delete_from_tree(BTree* root, void* param, int (*comparator)(const void* data1, const void* data2));

/* Helper Method */
BTree* min_leaf(BTree*);

void printBTree(BTree* node);
#endif //DATABASERECORDS_BINARY_TREE_H
