#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string line;
    cin >> line;
    int up = 0;
    int down = 0;
    int pref = 0;
    char init = line.at(0);

    for (int i = 1; i < line.length(); i++) {
        char want = line.at(i);
        //always up
        if (i == 1) {
            if (init == 'U' && want == 'D') {
                up += 2;
            }
            if (init == 'D') {
                up++;
            }
        } else {
            if (want == 'D') {
                up += 2;
            }
        }
        //always down
        if (i == 1) {
            if (init == 'D' && want == 'U') {
                down += 2;
            }
            if (init == 'U') {
                down++;
            }
        } else {
            if (want == 'U') {
                down += 2;
            }
        }

        //leave as preferred
        if (init != want) {
            pref++;
            init = want;
        }
    }

    cout << up << endl;
    cout << down << endl;
    cout << pref << endl;
    return 0;
}