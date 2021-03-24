#include "iostream"
using namespace std;

struct MaxHeap
{
    int * array;
    int size = 0;
    int maxSize;

    MaxHeap(int MaxSize) {
        array = new int[MaxSize];
        maxSize = MaxSize;
    }

    int Parent(int i) { return (i - 1) / 2; }
    int LeftChild(int i) { return 2 * i + 1; }
    int RightChild(int i) { return 2 * i + 2; }

    void SiftUp(int i) {
        while((i > 0) && (array[i] > array[Parent(i)])) {
            int t = array[i];
            array[i] = array[Parent(i)];
            array[Parent(i)] = t;
            i = Parent(i);
        }
    }

    void SiftDown(int i) {
        int maxIndex = i;
        if ((array[LeftChild(i)] > array[maxIndex]) && (LeftChild(i) < size)) {
            maxIndex = LeftChild(i);
        }
        if ((array[RightChild(i)] > array[maxIndex]) && (RightChild(i) < size)) {
            maxIndex = RightChild(i);
        }
        if (maxIndex != i) {
            int t = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = t;
            SiftDown(maxIndex);
        }
    }

    int GetMax() {
        return array[0];
    }

    void Insert(int p) {
        if (size < maxSize) {
            array[size] = p;
            SiftUp(size);
            size++;
        } else {
            cout << "Error" << endl;
        }
    }

    int ExtractMax() {
        int result = array[0];
        array[0] = array[size];
        size--;
        SiftDown(0);
        return result;
    }
};

int * HeapSort(int * array, int size) {
    MaxHeap * heap = new MaxHeap(size);
    int * arr = new int[size];
    for (int i = 0; i < size; i++) {
        heap->Insert(array[i]);
    }
    for (int i = 0; i < size; i++) {
        arr[i] = heap->ExtractMax();
    }
    return arr;
}