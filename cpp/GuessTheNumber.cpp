#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int low = 1;
    int high = 1000;
    int guess;
    for (int i = 0; i < 10; i++)
    {
        guess = low + (high - low) / 2;
        cout << guess << endl
             << flush;
        string ans;
        cin >> ans;
        if (ans == "correct")
        {
            break;
        }
        if (ans == "lower")
        {
            high = guess - 1;
        }
        else
        {
            low = guess + 1;
        }
    }
    return 0;
}