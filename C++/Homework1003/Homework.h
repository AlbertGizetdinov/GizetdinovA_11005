#include "iostream"
using namespace std;

struct Node {
    int item;
    Node * next = nullptr;
    Node * prev = nullptr;
};

struct LinkedList
{
    Node * head = nullptr;
    Node * last = nullptr;
    int count = 0;

    void add(int item) {
        Node * node = new Node;
        node->item = item;
        if (head == nullptr) {
            node->next = nullptr;
            node->prev = nullptr;
            head = node;
            last = node;
        } else {
            last->next = node;
            node->prev = last;
            last = node;
        }
        count++;
    }

    int size() {
        return count;
    }

    int get(int i) {
        Node * node = head;
        i--;
        while (i > 0) {
            i--;
            node = node->next;
        }
        return node->item;
    }

    void insertAt(int item, int id) {
        Node * nodePrev = head;
        id = id - 2;
        while (id > 0) {
            id--;
            nodePrev = nodePrev->next;
        }
        Node * nodeNext = nodePrev->next;
        Node * node = new Node;
        node->item = item;
        node->next = nodeNext;
        node->prev = nodePrev;
        nodePrev->next = node;
        nodeNext->prev = node;
        count++;
    }

    void removeAt(int id) {
        Node * node = head;
        id--;
        while (id > 0) {
            id--;
            node = node->next;
        }
        Node * nodeNext = node->next;
        Node * nodePrev = node->prev;
        nodeNext->prev = nodePrev;
        nodePrev->next = nodeNext;
        count++;
        delete node;
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

struct Queue {
    Node * head = nullptr;
    Node * last = nullptr;

    void Enqueue(int item) {
        Node * node = new Node;
        node->item = item;
        if (head == nullptr) {
            head = node;
            last = node;
        } else {
            last->next = node;
            last = node;
        }
    }

    int Dequeue() {
        if (head == nullptr) {
            return 0;
        }
        Node * node = head;
        head = head->next;
        return node->item;
    }
};
