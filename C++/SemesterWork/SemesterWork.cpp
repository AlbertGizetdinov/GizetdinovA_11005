#include "iostream"
#include "vector"

using namespace std;

struct FenwickTree {
    vector<int> bit;  // binary indexed tree
    int n;

    FenwickTree(int n) {
        this->n = n;
        bit.assign(n, 0);
    }

    FenwickTree(vector<int> a) : FenwickTree(a.size()) {
        for (size_t i = 0; i < a.size(); i++)
            add(i, a[i]);
    }

    int sum(int r) {
        int ret = 0;
        for (; r >= 0; r = (r & (r + 1)) - 1)
            ret += bit[r];
        return ret;
    }

    int sum(int l, int r) {
        return sum(r) - sum(l - 1);
    }

    void add(int id, int delta) {
        for (; id < n; id = id | (id + 1))
            bit[id] += delta;
    }
};

int main()
{
    FenwickTree *ftree = new FenwickTree(5);
    ftree->add(0,1);
    ftree->add(1,2);
    ftree->add(0,7);
    ftree->add(2,3);
    ftree->add(3,4);
    ftree->add(4,5);
    cout << ftree->sum(3) << endl; // (1 + 7) + 2 + 3 + 4 = 17
    cout << ftree->sum(2, 4) << endl; // 3 + 4 + 5 = 12
    return 0;
}