#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int c;
    cin >> c;
    for(int i = 0; i < c; i++) {
        int l, n;
        cin >> l >> n;
        int early = 0;
        int late = 0;
        for(int j = 0; j < n; j++) {
            int a;
            cin >> a;
            early = max(early, min(a, l-a));
            late = max(late, max(a, l-a));
        }
        cout << early << " " << late << "\n"; 
    }

    return 0;
}