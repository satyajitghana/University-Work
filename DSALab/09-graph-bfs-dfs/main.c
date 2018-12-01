#include <stdio.h>

#define MAX 10

int G[MAX][MAX]={}, visited[MAX]={}, n, queue[MAX]={}, front = 0, rear = -1;

void menu();
void reset_visited();
void read_adj_matrix();

// BFS and DFS
void DFS(int);
void BFS(int);

int main() {
    menu();

    return 0;
}

void menu() {
    while (1) {
        int choice;
        printf("\nBFS and DFS on Graph"
               "\n1.\tEnter Adjacency Matrix"
               "\n2.\tDFS of the Graph"
               "\n3.\tBFS of the Graph"
               "\n4.\tExit"
               "\nYour Choice : ");
        scanf("%d", &choice);
        switch (choice) {
            case 1 :
                read_adj_matrix();
                break;
            case 2 :
                reset_visited();
                printf("\n");
                DFS(0);
                break;
            case 3 :
                reset_visited();
                BFS(0);
                printf("\nThe nodes which are reachable are : \n");
                for (int i = 0 ; i < n ; i++) {
                    if (visited[i]) {
                        printf(" %d", i);
                    } else {
                        printf("\n Not all nodes are reachable, BFS not possible.\n");
                        break;
                    }
                }
                break;
            case 4 :
                return;
            default :
                printf("\nWrong Choice !");
        }
    }
}

void reset_visited() {
    front = 0;
    rear = -1;
    for (int i = 0 ; i < MAX ; i++)
        visited[i] = 0;
}

void read_adj_matrix() {
    printf("\nEnter the number of vertices : ");
    scanf("%d", &n);

    printf("\nEnter the adjacency matrix of the graph : ");

    for (int i = 0 ; i < n ; i++) {
        for (int j = 0 ; j < n ; j++) {
            scanf("%d", &G[i][j]);
        }
    }

}

void DFS(int i) {
    printf(" %d", i);
    visited[i] = 1;

    for (int j = 0 ; j < n ; j++) {
        if (!visited[j] && G[i][j] == 1) {
            DFS(j);
        }
    }
}

void BFS(int v) {
    for (int i = 0 ; i < n ; i++) {
        if (!visited[i] && G[v][i]) {
            queue[++rear] = i;
        }
    }

    if (front <= rear) {
        visited[queue[front]] = 1;
        BFS(queue[front++]);
    }
}