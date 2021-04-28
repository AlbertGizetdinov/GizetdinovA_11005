#include "iostream"

using namespace std;

int amountOfWays(int n){
    int x = 0;
    int y = 1;
    int res = 0;

    while (n > 1) {
        res = x + y;
        x = y;
        y = res;
        n--;
    }

    return res;
}

int arr[10000][10000];
int amountOfWaysForArray(int n, int m){
    for (int i = 0; i < m; i ++) {
        arr[n-1][i] = 1;
    }

    for (int i = 0; i < n; i++) {
        arr[i][0] = 1;
    }

    for (int i = n-2; i >= 0; i--) {
        for (int j = 1; j < m; j++){
            arr[i][j] = arr[i+1][j] + arr[i][j-1];
        }
    }

    return arr[0][m-1];
}

int main() {
    cout << amountOfWays(6) << endl; // 8
    cout << amountOfWaysForArray(5, 5) << endl; // 70
    return 0;
}