#include <bits/stdc++.h>
using namespace std;

class QuickUnion {
    public:
    int* id;
    int* size;

    QuickUnion(int n) {
        id = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    int find(int p) {
        int root = p;
        while(root != id[root]) {
            id[root] = id[id[root]];
            root = id[root];
        }
        return root;
    }

    bool connected(int p, int q) {
        return find(p) == find(q);
    }

    void Union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if(rootP == rootQ) {
            return;
        }
        if(size[rootP] < size[rootQ]) {
            id[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        else{
            id[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }

};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, Q;
    cin >> N >> Q;

    QuickUnion * qU = new QuickUnion(N);

    for(int i = 0; i < Q; i++) {
        string op;
        int a, b;
        cin >> op >> a >> b;

        if (op == "=") {
            qU->Union(a,b);
        }

        else {
            if(qU->connected(a,b)) {
                cout << "yes\n"; //DONT USE endl; SPENT HOURS DEBUGGING TIMELIMIT EXCEEDING 
            }

            else {
                cout << "no\n";
            }
        }
    }


    return 0;
}

