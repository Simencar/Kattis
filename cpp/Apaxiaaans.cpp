#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string name;
    cin >> name;
    string out;
    char current = name.at(0);
    out += current;
    for(int i = 1; i < name.length(); i++) {
        if(name.at(i) != current) {
            current = name.at(i);
            out += current;
        }
    }
    cout << out;

    return 0;

}