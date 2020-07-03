#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    while ((cin >> n) && n != -1)
    {
        int dist = 0;
        int lastTime = 0;
        for (int i = 0; i < n; i++)
        {
            int miles, currentTime;
            cin >> miles >> currentTime;
            dist += (currentTime-lastTime)*miles;
            lastTime = currentTime;
        }
        cout << dist << " miles" << endl;
    }
    return 0;
}