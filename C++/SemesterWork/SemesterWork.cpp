#include "iostream"
#include "vector"

using namespace std;

struct FenwickTree{

    vector<int> ftree;

    int F(int x){
        return x & (-x);
    }

    int sum(int x){
        int sum = 0;
        while(x > 0){
            sum = sum + ftree[x];
            x = x - F(x);
        }
        return sum;
    }

    int sum(int start, int end){
        return sum(end) - sum(start - 1);
    }

    void add(int id, int value){
        while(id <= ftree.size()){
            ftree[id] += value;
            id = id + F(id);
        }
    }

    FenwickTree(vector<int> array){
        int n = array.size();
        ftree.assign(n + 1, 0);
        for(int i = 0; i < n; ++i){
            add(i + 1, array[i]);
        }
    }
};

int main(){
    vector<int> arr = {1, 2, 3, 4, 5, 6};
    FenwickTree ftree(arr);
    cout << "Array is\n";
    for(int i = 0; i < 6; ++i)
        cout << arr[i] << " ";
    cout << "\nSum of interval [1, 4] is " << ftree.sum(1, 4) << endl;

    cout << "After changing 3 to 10, array is\n";
    arr[3 - 1] += 7;
    ftree.add(3, 7);
    for(int i = 0; i < 6; ++i)
        cout << arr[i] << " ";
    cout << "\nSum of interval [1, 4] is " << ftree.sum(1, 4) << endl;

    return 0;
}