#include "iostream"
#include "string"
#include "vector"

using namespace std;

void changeOfCoins(int x) {
    int coinsArr[3] = {10, 5, 1};
    int amountOfCoins[3] = {0, 0, 0};
    string res;
    for (int i = 0; i < 3; i++) {
        while (x - coinsArr[i] >= 0) {
            amountOfCoins[i]++;
            x -= coinsArr[i];
        }
        res = res + to_string(amountOfCoins[i]) + " ";
    }
    cout << res << endl;
}