#include <bits/stdc++.h>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, op, val;
    while (cin >> n)
    {
        bool q = true, s = true, p = true;
        queue<int> queue;
        stack<int> stack;
        priority_queue<int> pq;
        for (int i = 0; i < n; i++)
        {
            cin >> op >> val;
            if (op == 1)
            {
                queue.push(val);
                stack.push(val);
                pq.push(val);
            }
            else
            {
                if (queue.empty())
                {
                    p = q = s = false;
                    continue;
                }
                if (val != queue.front())
                {
                    q = false;
                }

                if (val != stack.top())
                {
                    s = false;
                }

                if (val != pq.top())
                {
                    p = false;
                }

                queue.pop();
                stack.pop();
                pq.pop();
            }
        }
        if (q && !s && !p)
        {
            cout << "queue" << endl;
        }
        else if (s && !q && !p)
        {
            cout << "stack" << endl;
        }
        else if (p && !s && !q)
        {
            cout << "priority queue" << endl;
        }

        else if (!q && !p && !s)
        {
            cout << "impossible" << endl;
        }

        else
        {
            cout << "not sure" << endl;
        }
    }

    return 0;
}