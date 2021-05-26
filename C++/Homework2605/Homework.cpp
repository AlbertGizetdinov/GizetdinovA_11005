#include "Homework.h"
#include "iostream"

using namespace std;

int main() {
    //First task
    changeOfCoins(26);
    changeOfCoins(31);
    changeOfCoins(4);

    //Second task
    cout << "Enter amount of days:" << endl;
    int num;
    cin >> num;

    int *arr = new int[num];
    for (int i = 0; i < num; i++) {
        arr[i] = 0;
    }

    int n = num * 3 + 1;
    int *schedule = new int[n];
    int count = 1;
    for (int i = 1; i < n; i++) {
        if (i % 3 == 1) {
            cout << "Enter " << count << " day:" << endl;
            count++;
        }
        cin >> schedule[i];
    }

    int max = 0;
    int k = 0;
    count = 0;
    while (true) {
        for (int i = 1; i < n; i++) {
            if (i % 3 == 2 && schedule[i] > max) {
                max = schedule[i];
                k = i;
            }
        }

        schedule[k] = 0;
        max = 0;
        int m = -1;
        for (int i = 0; i < schedule[k + 1]; ++i) {
            if (arr[i] == 0) {
                m = i;
            }
        }
        arr[m] = schedule[k - 1];
        count++;

        if (count == num) {
            break;
        }
    }

    cout << "Answer: " << endl;
    for (int i = 0; i < num; ++i) {
        cout << arr[i] << " ";
    }
    return 0;
}