#include "iostream"
using namespace std;

struct Node
{
    int item;
    Node * next = nullptr;
};

struct SortedList
{
    Node * head = nullptr;
    int count = 0;

    void add(int item) {
        Node * node = new Node;
        node->item = item;
        if (head == nullptr) {
            head = node;
            count++;
            return;
        }
        if (head->item > node->item) {
            node->next = head;
            head = node;
            count++;
            return;
        }
        if (head->item == node->item) {
            return;
        }
        Node * temp = head;
        while (temp->item < node->item) {
            if (temp->next == nullptr) {
                break;
            }
            if (temp->next->item > node->item) {
                break;
            }
            temp = temp->next;
        }
        if (temp->item == node->item) {
            return;
        }
        node->next = temp->next;
        temp->next = node;
        count++;
    }

    int get(int id) {
        Node * node = head;
        while (id > 1) {
            id--;
            node = node->next;
        }
        return node->item;
    }

    void removeAt(int id) {
        Node * temp = head;
        count--;
        if (id == 1) {
            head = temp->next;
        } else {
            id -= 2;
            while (id > 0) {
                temp = temp->next;
                id--;
            }
            Node *node = temp->next;
            temp->next = node->next;
        }
    }

    int getCount() {
        return count;
    }

    void printAll() {
        Node * temp = head;
        if (temp == nullptr) {
            cout << "0" << endl;
            return;
        }
        while (temp != nullptr) {
            cout << temp->item << " ";
            temp = temp->next;
        }
        cout << endl;
    }
};

SortedList * Union(SortedList * a, SortedList * b) {
    SortedList * res = new SortedList;
    for (int i = 1; i <= a->getCount(); i++) {
        res->add(a->get(i));
    }
    for (int i = 1; i <= b->getCount() ; i++) {
        res->add(b->get(i));
    }
    return res;
}

SortedList * Intersect(SortedList * a, SortedList * b) {
    SortedList * res = new SortedList;
    for (int i = 1; i <= a->getCount() ; i++) {
        for (int j = 1; j < b->getCount(); j++) {
            if (a->get(i) == b->get(j)) {
                res->add(a->get(i));
                break;
            }
        }
    }
    return res;
}

SortedList * Difference(SortedList * a, SortedList * b) {
    SortedList * res = new SortedList;
    bool hasInList = true;
    for (int i = 1; i <= a->getCount() ; i++) {
        for (int j = 1; j < b->getCount(); j++) {
            if (a->get(i) == b->get(j)) {
                hasInList = false;
                break;
            }
        }
        if (hasInList) {
            res->add(a->get(i));
        } else {
            hasInList = true;
        }
    }
    return res;
}