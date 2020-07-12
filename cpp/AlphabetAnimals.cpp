#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string prev;
    int n;
    cin >> prev >> n;
    unordered_map<char, queue<string>> um;

    for (int i = 0; i < n; i++)
    {
        string animal;
        cin >> animal;
        um[animal.at(0)].push(animal);
    }

    string out = "?";
    char c = prev.at(prev.length() - 1);
    string recurring = "1";
    bool stop = false;
    bool removed = false;
    int initSize = um[c].size();
    while (!um[c].empty())
    {
        string animal = um[c].front();
        um[c].pop();
        char c2 = animal.at(animal.length() - 1);
        if (c == c2) //starts and ends with same char.
        {
            if (recurring == animal)
            { // we have looped the whole list
                stop = true;
                if(initSize-1 != um[c].size()) {
                    removed = true; //we have removed a name from this list
                }
            }
            else
            {
                um[c].push(animal); 
                if (recurring == "1")
                { //save first occurrence
                    recurring = animal;
                }
            }
        }
        if (um[c2].empty() && !removed)
        {
            out = animal + "!";
            break;
        }
        else if (!(um[c2].empty()) && out == "?")
        {
            out = animal;
            
        }
        if (stop) {
            break;
        }
        
    }
    cout << out;

    return 0;
}