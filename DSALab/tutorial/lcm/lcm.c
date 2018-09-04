#include <stdio.h>

#define MAX 1000

int index = 0;
int pfs[MAX];
int ia = 0;
int ib = 0;
int pfa[MAX];
int pfb[MAX];
int u[MAX];
void lcm(int, int);
int f2 = 0;

int k = 0;
/* Program for LCM of two numbers */
int main(int argc, char **argv) {
    int a, b;
    scanf("%d %d", &a, &b);
    /*pf(a, pfa, &ia);
    pf(b, pfb, &ib);
    printArray(pfs, index);
    printArray(pfa, ia);
    printArray(pfb, ib);
    un(pfa, pfb, u);
    printArray(u, k);
    int lcm = 1;
    for (int i = 0; i < k ; i++) {
        lcm *= u[i];
    }
    printf("\n# %d\n", lcm);*/
    lcm(a, b);
    return 0;
}

void printArray(int arr[], int length) {
    for (int i = 0 ; i < length; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void pf(int a, int arr[], int *ia) {
    for (int i = 2; i <= a ; i++) {
        while (a%i == 0) {
            printf(" *%d* ", i);
            a = a/i;
            arr[(*ia)++] = i;
        }
        if (a == 1 ) break;
    }
}

void lcm(int a, int b) {
    int n = ( a > b ? a : b );
    //for (int i = 2; i <= n  ; i++) {
        /*while (a%i == 0) {
            printf(" *%d* ", i);
            a = a/i;
            arr[(*ia)++] = i;
        }
        if (a == 1 ) break;*/
    int i=2;
    int flag = 0;
        while(1) {
            //printf("**");
            if (i > n) break;
            if (a%i==0 || b%i==0) printf(" *%d* ", i);
            if (a%i == 0) {a = a/i; flag = 1;}
            if (b%i == 0) {b = b/i; flag = 1;}
            if (flag !=1)
                i++;
            else {
                i = 2;
                flag = 0;
            }
            if (a == 1 && b == 1) break;
        }
    //}
}

void un(int a1[], int a2[], int u[]) {
    int i, j, n, m;
    n = ia;
    m = ib;
     for(i=0,j=0,k=0;i<n&&j<m;){
        if(a1[i]<a2[j]){
            u[k]=a1[i];
            i++;
            k++;
        }
        else if(a1[i]>a2[j]){
            u[k]=a2[j];
            j++;
            k++;
        }
        else{
            u[k]=a1[i];
            i++;
            j++;
            k++;
        }
    }
    
    if(i<n){
        for(;i<n;++i){
            u[k]=a1[i];
            k++;
        }
    }
    else if(j<m){
        for(;j<m;++j){
            u[k]=a2[j];
            k++;
        }
    }
}
