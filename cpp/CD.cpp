#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    while((cin >> N >> M) &&(N != 0 && M != 0)) {
        unordered_map<long long, int> um;
        int count = 0;
        for(int i = 0; i < N; i++) {
            long long key;
            cin >> key;
            um[key] = 1;

        }
        for(int i = 0; i < M; i++) {
            long long key;
            cin >> key;
            if(!(um.find(key) == um.end())) {
                count++;
            }
        }
        cout << count << endl;
    }


    return 0;
}