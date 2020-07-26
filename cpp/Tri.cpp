#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int a, b, c;
    string x, y, z;
    cin >> a >> b >> c;
    x = to_string(a), y = to_string(b), z = to_string(c);
    if (a + b == c) {
        cout << x + "+" + y + "=" + z;
    } else if (a - b == c) {
        cout << x + "-" + y + "=" + z;
    } else if (a / b == c && a % b == 0) {
        cout << x + "/" + y + "=" + z;
    } else if (a * b == c) {
        cout << x + "*" + y + "=" + z;
    } else if (b + c == a) {
        cout << x + "=" + y + "+" + z;
    } else if (b - c == a) {
        cout << x + "=" + y + "-" + z;
    } else if (b / c == a && b % c == 0) {
        cout << x + "=" + y + "/" + z;
    } else if (b * c == a) {
        cout << x + "=" + y + "*" + z;
    }

    return 0;
}