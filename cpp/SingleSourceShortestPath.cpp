#include <bits/stdc++.h>
using namespace std;

class Node
{
public:
    int vertex;
    vector<pair<int, int>> adj; //adjacent vertices to this vertex

    Node(int vertex)
    {
        this->vertex = vertex;
    }

    void addEdge(int vertex, int weight)
    {
        pair<int, int> edge(vertex, weight);
        adj.push_back(edge);
    }
};

vector<int> dijkstra(vector<Node *> nodes, int source)
{
    vector<int> dist(nodes.size(), INT_MAX); //distance from vertex to source
    bool visited[nodes.size()] = {false};
    dist[source] = 0;
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
            int weight = dist[current] + nodes[current]->adj[i].second; //dist from adjacent vertex to source
            if (weight < dist[vertex])                                  // update only if this distance is smaller
            {
                dist[vertex] = weight;
            }
        }
        sett.erase(current);
        if (sett.empty())
        {
            break;
        }

        int minDist = INT_MAX;
        int index = 0;
        for (int v : sett) //find closest vertex and use this next iteration
        {
            if (dist[v] < minDist)
            {
                minDist = dist[v];
                index = v;
            }
        }
        current = index;
    }
    return dist;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n, m, q, s;
    while ((cin >> n >> m >> q >> s))
    {
        if ((n == 0 && m == 0 && q == 0 && s == 0))
        {
            break;
        }

        vector<Node *> nodes;
        for (int i = 0; i < n; i++) //create nodes
        {
            Node *no = new Node(i);
            nodes.push_back(no);
        }
        for (int i = 0; i < m; i++) // add edges
        {
            int from, to, weight;
            cin >> from >> to >> weight;
            nodes[from]->addEdge(to, weight);
        }
        vector<int> sp = dijkstra(nodes, s); //contains all shortest paths from s

        for (int i = 0; i < q; i++)
        {
            int dest;
            cin >> dest;
            if (sp[dest] != INT_MAX) //has path
            {
                cout << sp[dest] << endl;
            }
            else // no path
            {
                cout << "Impossible" << endl;
            }
        }
        cout << endl;
    }
    return 0;
}
