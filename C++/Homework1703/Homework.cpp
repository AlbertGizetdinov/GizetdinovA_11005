#include "iostream"
#include "Homework.h"
using namespace std;

int main()
{
    //1. Сортированный список
    SortedList * list1 = new SortedList;
    list1->add(6);
    list1->add(1);
    list1->add(25);
    list1->add(7);
    list1->add(10);
    cout << list1->get(2) << endl;
    list1->printAll();
    list1->removeAt(4);
    list1->printAll();
    cout << "------------------" << endl;

    //2. Сортированный список с сохранением уникальности элементов
    SortedList * list2 = new SortedList;
    list2->add(6);
    list2->add(6);
    list2->add(1);
    list2->add(8);
    list2->add(2);
    list2->add(6);
    list2->printAll();
    cout << "------------------" << endl;

    //3. Операции над двумя списками
    //3.1. Объединение
    Union(list1, list2)->printAll();
    cout << "-----" << endl;
    //3.2. Пересечение
    Intersect(list1, list2)->printAll();
    cout << "-----" << endl;
    //3.3. Разность
    Difference(list1, list2)->printAll();
    return 0;
}
