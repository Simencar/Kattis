#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    unordered_map<char, string> map;
    map['a'] = "@";
    map['b'] = "8";
    map['c'] = "(";
    map['d'] = "|)";
    map['e'] = "3";
    map['f'] = "#";
    map['g'] = "6";
    map['h'] = "[-]";
    map['i'] = "|";
    map['j'] = "_|";
    map['k'] = "|<";
    map['l'] = "1";
    map['m'] = "[]\\/[]";
    map['n'] = "[]\\[]";
    map['o'] = "0";
    map['p'] = "|D";
    map['q'] = "(,)";
    map['r'] = "|Z";
    map['s'] = "$";
    map['t'] = "']['";
    map['u'] = "|_|";
    map['v'] = "\\/";
    map['w'] = "\\/\\/";
    map['x'] = "}{";
    map['y'] = "`/";
    map['z'] = "2";

    string line;
    string result;
    getline(cin, line);
    for (int i = 0; i < line.length(); i++)
    {
        char c = tolower(line.at(i));
        string sc(1, c);
        if (map.find(c) == map.end())
        {
            result.append(sc);
        }
        else
        {
            result.append(map.at(c));
        }
    }
    cout << result << endl;
    return 0;
}