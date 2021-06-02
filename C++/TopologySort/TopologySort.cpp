#include "iostream"
#include "list"
#include "stack"

using namespace std;

class Graph {
    int vertex;
    list<int> *arr;
    void topologicalSortUtil(int vertex, bool visited[], stack<int> &Stack);
public:
    Graph(int vertex);
    void addEdge(int vertex, int edge);
    void topologicalSort();
};

Graph::Graph(int vertex) {
    this->vertex = vertex;
    arr = new list<int>[vertex];
}

void Graph::addEdge(int vertex, int edge) {
    arr[vertex].push_back(edge);
}

void Graph::topologicalSortUtil(int vertex, bool visited[], stack<int> &Stack) {
    visited[vertex] = true;
    list<int>::iterator i;
    for (i = arr[vertex].begin(); i != arr[vertex].end(); ++i)
        if (!visited[*i])
            topologicalSortUtil(*i, visited, Stack);
    Stack.push(vertex);
}

void Graph::topologicalSort() {
    stack<int> Stack;
    bool *visited = new bool[vertex];
    for (int i = 0; i < vertex; i++)
        visited[i] = false;

    for (int i = 0; i < vertex; i++)
        if (visited[i] == false)
            topologicalSortUtil(i, visited, Stack);

    while (Stack.empty() == false) {
        cout << Stack.top() << " ";
        Stack.pop();
    }
}

int main() {
    Graph g(6);
    g.addEdge(5, 2);
    g.addEdge(5, 0);
    g.addEdge(4, 0);
    g.addEdge(4, 1);
    g.addEdge(2, 3);
    g.addEdge(3, 1);

    cout << "Topological Sort of the graph" << endl;
    g.topologicalSort();

    return 0;
}