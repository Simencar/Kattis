#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    unordered_map<int,int> mods;
    for(int i = 0; i < 10; i++) {
        int num;
        cin >> num;
        int res = num%42;
        mods[res] = 0;
    }
    cout << mods.size();

    return 0;
}