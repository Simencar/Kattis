#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int cases, n;
    cin >> cases;

    for (int i = 0; i < cases; i++) {
        cin >> n;
        unordered_map<string, int> places;
        int count = 0;
        for (int j = 0; j < n; j++) {
            string place;
            cin >> place;
            if (places.find(place) == places.end()) {
                places.insert({place, 0});
                count++;
            }
        }
        cout << count << endl;
    }
}