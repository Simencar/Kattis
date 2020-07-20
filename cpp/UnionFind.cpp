#include <bits/stdc++.h>
using namespace std;

int find(int parent[], int i)  
{  
    if (parent[i] == -1)  
        return i;  
    return find(parent, parent[i]);  
} 

void Union(int parent[], int x, int y)  
{  
    int xset = find(parent, x);  
    int yset = find(parent, y);  
    if(xset != yset) 
    {  
        parent[xset] = yset;  
    }  
} 

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, Q;
    cin >> N >> Q;

    int *parent = new int[N * sizeof(int)];  
    memset(parent, -1, N * sizeof(int));

    for(int i = 0; i < Q; i++) {
        string op;
        int a, b;
        cin >> op >> a >> b;

        if (op == "?") {
            if(a == b || (parent[a] == parent[b] && parent[a] != -1) || parent[a] == b || parent[b] == a) {
                cout << "yes" << endl;
            }

            else {
                cout << "no" << endl;
            }
        }

        else {
            Union(parent, a, b);
        }
    }


    return 0;
}