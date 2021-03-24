#include "iostream"
#include "Homework.h"
using namespace std;

int main()
{
    //1. Реализовать двоичную кучу
    MaxHeap * heap = new MaxHeap(7);
    heap->Insert(20);
    heap->Insert(9);
    heap->Insert(15);
    heap->Insert(11);
    heap->Insert(5);
    heap->Insert(7);
    cout << heap->ExtractMax() << endl;
    cout << heap->ExtractMax() << endl;
    cout << heap->ExtractMax() << endl;
    cout << heap->ExtractMax() << endl;
    cout << heap->ExtractMax() << endl;
    cout << "-----------------------\n";

    //2. Реализовать функцию сортировки кучей
    int ar[5] = {5, 10, 7, 9, 2};
    for (int i = 0; i < 5; i++) {
        cout << ar[i] << "\t";
    }
    cout << endl;
    int * a = HeapSort(ar, 5);
    for (int i = 0; i < 5; i++) {
        cout << a[i] << "\t";
    }
    return 0;
}
