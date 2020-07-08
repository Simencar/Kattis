#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    char board[8][8];
    int queens = 0;
    for (int i = 0; i < 8; i++)
    {
        string line;
        getline(cin, line);
        for (int j = 0; j < 8; j++)
        {
            board[i][j] = line.at(j);
            if(line.at(j) == '*') {
                queens++;
            }
        }
    }

    bool invalid = false;
    if(queens != 8) {
        invalid = true;
    }

    while (!invalid)
    {
        //check horizontal
        for (int i = 0; i < 8; i++)
        {
            int count = 0;
            for (int j = 0; j < 8; j++)
            {
                if (board[i][j] == '*')
                {
                    count++;
                }
            }
            if (count > 1)
            {
                invalid = true;
            }
        }
        //check vertical
        for (int i = 0; i < 8; i++)
        {
            int count = 0;
            for (int j = 0; j < 8; j++)
            {
                if (board[j][i] == '*')
                {
                    count++;
                }
            }
            if (count > 1)
            {
                invalid = true;
            }
        }
        //check right diags
        for (int i = 0; i < 8; i++)
        {
            int count = 0;
            for (int j = 0; j <= i; j++)
            {
                int k = i - j;
                if (board[k][j] == '*')
                {
                    count++;
                }
            }
            if (count > 1)
            {
                invalid = true;
            }
        }

        for (int i = 6; i >= 0; i--)
        {
            int count = 0;
            for (int j = 0; j <= i; j++)
            {
                int k = i - j;
                if (board[7 - j][7 - k] == '*')
                {
                    count++;
                }
            }
            if (count > 1)
            {
                invalid = true;
            }
        }

        // check left diags
        for (int i = 7; i > 0; i--)
        {
            int k = 0;
            int count = 0;
            for (int j = i; j < 8; j++)
            {
                if (board[j][k] == '*')
                {
                    count++;
                }
                k++;
            }
            if (count > 1)
            {
                invalid = true;
            }
        }

        for (int i = 0; i < 8; i++)
        {
            int k = 0;
            int count = 0;
            for (int j = i; j < 8; j++)
            {
                if (board[k][j] == '*')
                {
                    count++;
                }
                k++;
            }
            if (count > 1)
            {
                invalid = true;
            }
        }
        break;
    }

    if (invalid)
    {
        cout << "invalid" << endl;
    }

    else
    {
        cout << "valid" << endl;
    }

    return 0;
}
