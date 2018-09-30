//
// Created by shadowleaf on 25-Sep-18.
//

#include <stdlib.h>
#include <stdio.h>
#include "binary_tree.h"
#include "debug_helper.h"
#include "city_data.h"

/* Creates a New Leaf, initializes it and return it */
BTree* newLeaf(void* data, void (*printData)(void* data)) {
    BTree* myleaf = malloc(sizeof *myleaf);

    myleaf -> left = NULL;
    myleaf -> data = data;
    myleaf -> right = NULL;

    myleaf -> add = add_to_tree;
    myleaf -> printData = printData;

    return myleaf;
}
/* Compares the Leaf with the parameter using comparator */
BTree* search_tree(BTree* root, void* param, int (*comparator)(const void* data1, const void* data2)){
    if (root == NULL || comparator(root -> data, param) == 0) {
        return root;
    }

    if (comparator(root -> data, param) >= 0) {
        return search_tree(root -> right, param, comparator);
    } else {
        return search_tree(root -> left, param, comparator);
    }

}

/* Compares two Leaves with Comparator that can compare them */
void add_to_tree(BTree** root, BTree* data, int (*comparator)(const void* data1, const void* data2)) {
    if (*root == NULL) {
        *root = data;
        return;
    }

    if (comparator((*root) -> data, data -> data) >= 0) {
        add_to_tree(&((*root) -> right), data, comparator);
    } else {
        add_to_tree(&((*root) -> left), data, comparator);
    }
}

/* Deletes a leaf from the BTree if it exists, uses comparator to check
 * between the leaf and data of leaf*/
BTree* delete_from_tree(BTree* root, void* param, int (*comparator)(const void* data1, const void* data2)) {
    if (root == NULL)
        return root;

    if (comparator(root -> data, param) > 0) {
        root -> right = delete_from_tree(root -> right, param, comparator);
    } else if (comparator(root -> data, param) < 0) {
        root -> left = delete_from_tree(root -> left, param, comparator);
    } else {
        /* Found you dammit, Delete this goddamn leaf! */

        // case 1 and 2: leaf with only one kid or no kids
        if (root -> left == NULL) {
            BTree* rightKid = root -> right;
            free(root);
            return rightKid;
        } else if (root -> right == NULL) {
            BTree* leftKid = root -> left;
            free(root);
            return leftKid;
        }

        // case 3: leaf with two kids
        BTree* temp = min_leaf(root -> right);
        free(root -> data);
        root -> data = temp -> data;

        /* Delete the in-order successor */
        root -> right = delete_from_tree(root -> right, ((CityData*)(temp -> data)) -> name, comparator);

    }
    return root;
}

/* Helper Method */
/* Returns the left-most leaf, or the minimum value leaf */
BTree* min_leaf(BTree* leaf) {
    BTree* current_leaf = leaf;

    while (current_leaf -> left != NULL)
        current_leaf = current_leaf -> left;

    return current_leaf;
}

/* Prints the Tree In-Order */
void printBTree(BTree* node) {
    if (node == NULL) {
        return;
    }

    printBTree(node -> right);
    node -> printData(node -> data);
    printBTree(node -> left);
}