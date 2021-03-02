#pragma once
using namespace std;

int sum(int * a, int size) {
    int S = 0;
    for (int i = 0; i < size; ++i) {
        S += a[i];
    }
    return S;
}

int *sumOfMas(int *mas1, int *mas2, int mas1len, int mas2len) {
    int *mas = new int[mas1len + mas2len];
    for (int i = 0; i < mas1len; ++i) {
        mas[i] = mas1[i];
    }
    for (int i = mas1len; i < mas2len + mas1len; i++) {
        mas[i] = mas2[i - mas1len];
    }
    delete[] mas1;
    delete[] mas2;
    return mas;
}

void sort(int * a, int size) {
    for (int i = 0; i < size; i++) {
        for (int j = i; j < size; ++j) {
            if (a[i] > a[j]) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
    }
}