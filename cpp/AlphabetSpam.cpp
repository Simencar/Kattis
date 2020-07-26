#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    string line;
    cin >> line;
    double white, upper, lower, symb = 0;
    for (int i = 0; i < line.length(); i++) {
        if (line.at(i) == '_') {
            white++;
        } else if (isupper(line.at(i))) {
            upper++;
        } else if (islower(line.at(i))) {
            lower++;
        } else if (!isalpha(line.at(i))) {
            symb++;
        }
    }
    double x = white / line.length();
    double y = lower / line.length();
    double z = upper / line.length();
    double q = symb / line.length();

    cout << fixed;
    cout << setprecision(20);
    cout << x << "\n"
         << y << "\n"
         << z << "\n"
         << q;

    return 0;
}