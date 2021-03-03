#pragma once
#include "iostream"
using namespace std;

struct Node
{
    int item;
    Node * next;
};

struct Stack
{
    Node * pHead;

    void Push(int item)
    {
        Node * node = new Node;
        node->item = item;
        node->next = pHead;
        pHead = node;
    }

    int Pop()
    {
        if (!pHead)
            throw 1;

        Node * temp = pHead;
        int x = temp->item;
        pHead = temp->next;
        delete temp;
        return x;
    }

    int Peek()
    {
        if (!pHead)
            throw 1;

        return pHead->item;
    }

    void printAll() {
        Node * temp = pHead;
        while (temp != nullptr) {
            cout << temp->item << endl;
            temp = temp->next;
        }
    }
};

struct LinkedList
{
    Node * head = nullptr;
    Node * last;
    int count = 0;

    void add(int num) {
        Node * node = new Node;
        node->item = num;
        if (head == nullptr) {
            node->next = nullptr;
            head = node;
            last = node;
        } else {
            last->next = node;
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

    void printAll() {
        Node * temp = head;
        while (temp != nullptr) {
            cout << temp->item << " ";
            temp = temp->next;
        }
    }
};