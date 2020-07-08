#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    while ((cin >> n) && n != 0)
    {
        vector<string> names;
        vector<string> sorted;
        for (int i = 0; i < n; i++)
        {
            string name;
            cin >> name;
            names.push_back(name);
        }

        while (!names.empty())
        {
            int min1 = INT_MAX;
            int min2 = INT_MAX;
            int index = 0;
            for (int i = 0; i < names.size(); i++)
            {
                char c1 = names[i].at(0);
                char c2 = names[i].at(1);
                if ((int(c1)) < min1 || ((int(c1)) == min1 && (int(c2)) < min2))
                {
                    min1 = int(c1);
                    min2 = int(c2);
                    index = i;
                }
            }
            sorted.push_back(names[index]);
            names.erase(names.begin() + index);
        }
        for(int i = 0; i < n; i++) {
            cout << sorted[i] << endl;
        }
    }

    return 0;
}