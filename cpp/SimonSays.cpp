#include <bits/stdc++.h>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    cin.ignore();
    string s = "Simon says";
    for(int i = 0; i < n; i++) {
        string line;
        getline(cin, line);
        if (line.length() > s.length()) {
            if(s.compare(line.substr(0, s.length())) == 0) {
                cout << line.substr(s.length()) << endl;
            }
        }
    }

    return 0;
}