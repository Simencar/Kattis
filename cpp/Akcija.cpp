#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    int prices[N];
    for(int i = 0; i < N; i++) {
        int price;
        cin >> price;
        prices[i] = price;
    }

    sort(prices, prices+N, greater<int>());
    int count = 1;
    int sum = 0;
    for(int i = 0; i < N; i++) {
        if(count == 3) {
            count = 1;
            continue;
        }
        sum += prices[i];
        count++;
    }

    cout << sum;

    return 0;
}