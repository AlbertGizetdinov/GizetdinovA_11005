#include "iostream"

using namespace std;

int binarySearch(int arr[], int x, int n) {
    int left = 0;
    int right = n;
    int res = -1;
    while (left <= right) {
        int middle = (left + right) / 2;
        if (x == arr[middle]) {
            res = middle;
            break;
        }
        if (x < arr[middle]) {
            right = middle - 1;
        } else if (x > arr[middle]) {
            left = middle + 1;
        }
    }
    return res;
}

void binarySearchFirstTask(int arr[], int x, int n) {
    int res[2];
    res[0] = binarySearch(arr, x, n);
    res[1] = res[0];
    if (res[0] == -1) {
        cout << "This element isn't in the array" << endl;
        return;
    }
    while (x == arr[res[0] - 1]) {
        res[0] -= 1;
    }
    while (x == arr[res[1] + 1]) {
        res[1] += 1;
    }
    if (res[0] == res[1]) {
        cout << "Index of " << x << " is " << res[0] << endl;
    } else {
        cout << "First index of " << x << " is " << res[0] << endl;
        cout << "Second index of " << x << " is " << res[1] << endl;
    }
}

void binarySearchSecondTask(int arr[][3], int x, int n, int m) {
    int res = -1;
    for (int i = 0; i < n; i++) {
        if (x <= arr[i][m - 1]) {
            res = binarySearch(arr[i], x, n);
        }
    }
    if (res == -1) {
        cout << "This element isn't in the array (False)" << endl;
    } else {
        cout << "This element is in the array (True)" << endl;
    }
}

void binarySearchThirdTask(int num) {
    int left = 0;
    int right = num / 2;
    while (true) {
        int middle = (right + left) / 2;
        int res = middle * middle;
        if (num - res == 0) {
            cout << "Result is: " << middle << endl;
            return;
        } else if (abs(num - (middle - 1) * (middle - 1)) > abs(num - res)) {
            if (abs(num - (middle + 1) * (middle + 1)) > abs(num - res)) {
                cout << "Approximate result: " << middle << endl;
                return;
            } else {
                left = middle;
            }
        } else {
            right = middle;
        }
    }
}

void binarySearchFourthTask(int arr[][4], int n, int m) {
    int min = -1;
    int max = -1;
    int minvalue = INT_MAX;
    int maxvalue = INT_MIN;
    for (int i = 0; i < m; i++) {
        if (arr[i][0] < minvalue) {
            min = i;
            minvalue = arr[i][0];
        }
        if (arr[i][m - 1] > maxvalue) {
            max = i;
            maxvalue = arr[i][m - 1];
        }
    }
    int left = arr[min][0];
    int right = arr[max][m - 1];
    while (left <= right) {
        int middle = (right + left) / 2;
        int top = 0;
        int down = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (middle > arr[i][j]) {
                    down++;
                } else if (middle < arr[i][j]) {
                    top++;
                }
            }
        if ((down + top) % 2 != 0) {
            cout << "Median is: " << middle << endl;
            return;
        }
        if (top > down) {
            left = middle;
        } else if (down > top) {
            right = middle;
        } else {
            cout << "Median is: " << middle << endl;
            return;
        }
    }
}