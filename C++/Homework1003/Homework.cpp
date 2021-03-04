#include "Homework.h"
#include "iostream"
using namespace std;

int main() {
    /* LinkedList * list = new LinkedList;
    list->add(1);
    list->add(2);
    list->add(3);
    list->add(5);
    list->add(6);
    list->printAll();
    list->insertAt(4, 4);
    list->printAll();
    list->insertAt(7, 6);
    cout << list->size() << endl;
    list->removeAt(5);
    list->removeAt(5);
    list->printAll(); */

    Queue * queue = new Queue;
    queue->Enqueue(1);
    queue->Enqueue(2);
    queue->Enqueue(4);
    queue->Enqueue(5);
    cout << queue->Dequeue() << endl;
    cout << queue->Dequeue() << endl;
    cout << queue->Dequeue() << endl;
    queue->Enqueue(10);
    cout << queue->Dequeue() << endl;
    cout << queue->Dequeue() << endl;
    return 0;
}
