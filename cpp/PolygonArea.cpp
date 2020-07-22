#include <bits/stdc++.h>
using namespace std;

double getArea(vector<pair<double, double>> c, int n) {
    c.push_back(c[0]);
    double sumRight = 0;
    double sumLeft = 0;
    for (int i = 0; i < n - 1; i++) {
        sumRight += c[i].first * c[i + 1].second;
        sumLeft += c[i].second * c[i + 1].first;
    }
    return (sumRight - sumLeft) / 2.0;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    while ((cin >> n) && n != 0) {
        vector<pair<double, double>> cords(n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            pair<double, double> c;
            cin >> c.first >> c.second;
            cords[i] = c;
        }
        double area = getArea(cords, n + 1);

        cout << fixed;
        cout << setprecision(1);
        cout << (area < 0 ? "CW " : "CCW ") << abs(area) << "\n";
    }

    return 0;
}