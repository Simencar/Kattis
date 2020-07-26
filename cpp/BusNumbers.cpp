#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    int numbers[n];
    for (int i = 0; i < n; i++) {
        cin >> numbers[i];
    }
    sort(numbers, numbers + n);
    string out;
    int count = 1;
    int start = numbers[0];
    bool endMatch = false;
    for (int i = 1; i < n; i++) {
        if (numbers[i] == numbers[i - 1] + 1) {
            count++;
            if (i == n - 1) {
                numbers[i - 1] = numbers[i];
                endMatch = true;
                goto print;
            }
        } else {
        print:
            if (count > 2) {
                out += to_string(start) + "-" + to_string(numbers[i - 1]) + " ";
            } else if (count == 2) {
                out += to_string(start) + " " + to_string(numbers[i - 1]) + " ";
            } else {
                out += to_string(start) + " ";
            }
            if (i == n - 1 && !endMatch) {
                out += to_string(numbers[i]);
            }
            count = 1;
            start = numbers[i];
        }
    }
    cout << out << endl;

    return 0;
}