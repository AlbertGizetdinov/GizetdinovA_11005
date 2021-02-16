#pragma once
#include "math.h"
using namespace std;

void sum() {
    int x, y;
    cout << "Enter number 1:" << endl;
    cin >> x;
    cout << "Enter number 2:" << endl;
    cin >> y;
    cout << "Sum is " << x + y;
}

void equationSolution() {
    double a, b ,c;
    cout << "Enter a:" << endl;
    cin >> a;
    cout << "Enter b:" << endl;
    cin >> b;
    cout << "Enter c:" << endl;
    cin >> c;
    int D = b * b - 4 * a * c;
    if (D > 0) {
        cout << "X1 = " << (-b + sqrt(D)) / (2 * a) << "\nX2 = " << (-b - sqrt(D)) / (2 * a);
    } else if (D == 0) {
        cout << "X = " << (- b) / (2 * a);
    } else {
        cout << "No solutions";
    }
}

int power(int x, unsigned int p) {
    int res = 1;
    while (p > 0) {
        res = res * x;
        p--;
    }
    return res;
}

void powerOfTwo() {
    int x, p;
    cout << "Enter number:" << endl;
    cin >> x;
    p = 0;
    while (power(2 , p) <= x) {
        p++;
    }
    cout << "Max p: " << --p;
}
