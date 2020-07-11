#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n, m;
    cin>>n>>m;
    int res = m-n;
    string pc = " pieces";
    if(res == 1 || res == -1) {
        pc = " piece";
    }

    if(res > 0) {
        cout << "Dr. Chaz will have " << res << pc <<" of chicken left over!";
    }
    
    else {
        cout << "Dr. Chaz needs " << abs(res) << " more" << pc << " of chicken!";
    }


    return 0;
}