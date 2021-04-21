#include "Homework.h"
#include "iostream"

using namespace std;

int main()
{
    //First task Необходимо найти индекс первого вхождения Х в массив и последнего.
    cout << "Task 1" << endl;
    int arrFirstTask[28] = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 5, 5, 5, 5, 6, 9, 9, 9, 9, 9, 9};
    binarySearchFirstTask(arrFirstTask, 0, 28); // 0; 3
    binarySearchFirstTask(arrFirstTask, 9, 28); // 22; 27
    binarySearchFirstTask(arrFirstTask, 6, 28); // 21
    binarySearchFirstTask(arrFirstTask, 8, 28); // -

    //Second Task Написать функцию, которая будет проверять, содержит ли матрица число Х, или нет.
    cout << "\nTask 2" << endl;
    int arrSecondTask[3][3] = {{1, 3, 4},
                               {6, 8, 10},
                               {45, 67, 68}};
    binarySearchSecondTask(arrSecondTask, 68, 3, 3); // +
    binarySearchSecondTask(arrSecondTask, 1000, 3, 3); // -

    //Third Task Найти округлённое до целых чисел значение квадратного корня из числа Х
    cout << "\nTask 3" << endl;
    binarySearchThirdTask(9); // 3
    binarySearchThirdTask(16); // 4
    binarySearchThirdTask(156); // 12
    binarySearchThirdTask(157); // 13

    //Fourth Task Нужно найти медиану матрицы
    cout << "\nTask 4" << endl;
    int arrFourthTask[4][4] = {{4, 6, 8, 9},
                               {1, 4, 5, 6},
                               {2, 4, 7, 10},
                               {3, 6, 8, 12}};
    binarySearchFourthTask(arrFourthTask, 4, 4); // 6
    return 0;
}