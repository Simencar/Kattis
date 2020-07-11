#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    string a, b, ar, br;
    cin>>a>>b;
    for(int i = 2; i >= 0; i--) {
        ar += a.at(i);
        br += b.at(i);
    }
    cout << max(stoi(ar), stoi(br));

    return 0;
}