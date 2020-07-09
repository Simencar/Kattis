#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    string line;
    int N = 1;
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

            int count = 1;
            for (int i = blackDist + 1; i < line.length(); i++)
            {
                if (count < blackDist)
                {
                    if (line.at(i) != '.')
                    {
                        even = false;
                        goto print;
                    }
                    count++;
                }
                else if (count == blackDist)
                {
                    if (line.at(i) != '*')
                    {
                        even = false;
                        goto print;
                    }
                    count = 1;
                }
            }
        }
    print:
        if (even)
        {
            cout << N << " EVEN" << endl;
        }
        else
        {
            cout << N << " NOT EVEN" << endl;
        }
        N++;
    }

    return 0;
}