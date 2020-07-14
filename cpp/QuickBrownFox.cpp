#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    cin.ignore();
    string line;
    for (int i = 0; i < n; i++)
    {
        bool chars[26] = {false};
        getline(cin, line);

        for (int j = 0; j < line.length(); j++)
        {
            char c = tolower(line.at(j));
            int pos = int(c) - 97;
            if (pos >= 0 && pos < 27)
            {
                chars[pos] = true;
            }
        }
        string res = "missing ";
        for (int j = 0; j < 26; j++)
        {
            if (!chars[j])
            {
                char c = j + 97;
                res += c;
            }
        }

        if (res == "missing ")
        {
            res = "pangram";
        }

        cout << res << endl;
    }

    return 0;
}