#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    int prices[n];
    long long disc = 0;

    for (int i = 0; i < n; i++)
    {
        cin >> prices[i];
    }
    sort(prices, prices + n, greater<int>());

    for (int i = 2; i < n; i += 3)
    {
        disc += prices[i];
    }
    cout << disc << endl;

    return 0;
}