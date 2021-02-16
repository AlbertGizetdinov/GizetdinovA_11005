#include "iostream"
#include "Homework.h"
using namespace std;

int main()
{
    cout << "First task (sum) :\n";
    sum();
    cout << "\nSecond task (equation solution) :\n";
    equationSolution();
    cout << "\nThird task (max power of two) :\n";
    powerOfTwo();
    cout << "\nFourth task (power of number) :\n";
    int x, p;
    cout << "Enter number:" << endl;
    cin >> x;
    cout << "Enter degree:" << endl;
    cin >> p;
    cout << "Result is: " << power(x , p);
    return 0;
}