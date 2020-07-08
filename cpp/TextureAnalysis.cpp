#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    string line;
    while ((cin >> line) && line != "END")
    {
        bool even = true;
        int blackDist = 0;
        if (line.length() > 1)
        {
            for (int i = 1; i < line.length(); i++)
            {
                if (line.at(i) == '*')
                {
                    blackDist = i;
                    break;
                }
            }
            for (int i = 0; i < line.length(); i += blackDist)
            {
                cout << i << endl;
                if (line.at(i) != '*')
                {
                    even = false;
                    break;
                }
            }
        }

        if (even)
        {
            cout << "EVEN" << endl;
        }
        else
        {
            cout << "NOT EVEN" << endl;
        }
    }

    return 0;
}