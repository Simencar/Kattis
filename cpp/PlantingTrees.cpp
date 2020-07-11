#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int N;
    cin >> N;
    int trees[N];

    for (int i = 0; i < N; i++)
    {
        int time;
        cin >> time;
        trees[i] = time;
    }

    sort(trees, trees + N, greater<int>());
    int day = 1;
    int finished = 1;
    
    for (int i = 0; i < N; i++)
    {
        finished = max(finished, (day + trees[i]));
        day++;
    }
    cout << finished + 1 << endl;

    return 0;
}