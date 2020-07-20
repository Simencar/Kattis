#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
    int vertex;
    vector<pair<int, double>> adj; //adjacent vertices to this vertex

    Node(int vertex)
    {
        this->vertex = vertex;
    }

    void addEdge(int vertex, double fact)
    {
        pair<int, double> edge(vertex, fact);
        adj.push_back(edge);
    }
};

//shortest path algorithm modified to find max size of micheal at each vertex
vector<double> dijkstra(vector<Node *> nodes, int source)
{
    vector<double> sizes(nodes.size(), 0); //current max size of michael at this vertex
    bool visited[nodes.size()] = {false};
    sizes[source] = 8;
    int current = source;
    unordered_set<int> sett; // set containing vertices with a parent marked as visited

    while (true)
    {
        visited[current] = true;                             //mark current vertex as visited
        for (int i = 0; i < nodes[current]->adj.size(); i++) // go through adjacent vertices
        {
            int vertex = nodes[current]->adj[i].first;
            if (visited[vertex])
            {
                continue;
            }
            sett.insert(vertex);
            double size = sizes[current] * nodes[current]->adj[i].second; //size of michael at next vertex 
            if (size > sizes[vertex])                                  // update only if this size is larger
            {
                sizes[vertex] = size;
            }
        }
        sett.erase(current);
        if (sett.empty())
        {
            break;
        }

        double maxSize = 0.0;
        int index = 0;
        for (int v : sett) //find vertex with largest size and use this next iteration
        {
            if (sizes[v] > maxSize)
            {
                maxSize = sizes[v];
                index = v;
            }
        }
        current = index;
    }
    return sizes;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n,m;
    while((cin >> n >> m) && (n != 0 && m != 0)) {

        vector<Node *> nodes;
        for (int i = 0; i < n; i++) //create nodes
        {
            Node *no = new Node(i);
            nodes.push_back(no);
        }

        for (int i = 0; i < m; i++) // add edges
        {
            int from, to;
            double fact;
            cin >> from >> to >> fact;
            nodes[from]->addEdge(to, fact);
            nodes[to]->addEdge(from, fact);
        }

        vector<double> sizes = dijkstra(nodes, 0); // contains size of micheal at each vertex after use of optimal path. 
        //complexity is unneccesary large since we only want paths from 0 to n-1, but it works. 
        double size = sizes[n-1];
        double fract = size / 8;
        cout << fixed;
        cout.precision(4);
        cout << fract << endl;
    }

    return 0;
}