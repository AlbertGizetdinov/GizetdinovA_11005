#include "Homework.h"
#include "iostream"
using namespace std;

int main()
{
    cout << "First task" << endl;
    Stack * stack = new Stack;
    stack->Push(2);
    stack->Push(4);
    stack->Push(6);
    stack->printAll();

    cout << "Second task" << endl;
    LinkedList * list = new LinkedList;
    list->add(1);
    list->add(3);
    list->add(5);
    list->add(7);
    cout << list->size() << endl;
    cout << list->get(2) << " " << list->get(4) << endl;

    cout << "Third task" << endl;
    list->printAll();
    return 0;
}