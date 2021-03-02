#include "iostream"
#include "Homework.h"
using namespace std;

int main()
{
    cout << "First task" << endl;
    int *mas = new int [5];
    for (int i = 0; i < 5; ++i) {
        mas[i] = i + 2;
    }
    for (int i = 0; i < 5; ++i) {
        cout << mas[i] << " ";
    }
    cout << "\nSum elements of array: " << sum(&mas[0], 5) << endl;

    cout << "\nSecond task" << endl;
    int *mas1 = new int [3];
    for (int i = 0; i < 3; ++i) {
        mas1[i] = i + 1;
    }
    int *mas2 = new int [4];
    for (int i = 0; i < 4; ++i) {
        mas2[i] = i + 4;
    }
    int *mas3 = sumOfMas(mas1, mas2, 3, 4);
    for (int i = 0; i < 7; ++i) {
        cout << mas3[i] << " ";
    }

    cout << "\nThird task" << endl;
    int a[] = {1, 4, 9, 2, 6, 10, 3};
    sort(a, 7);
    for (int i = 0; i < 7; i++) {
        cout << a[i] << " ";
    }
    return 0;
}