#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N, W, H;
    cin >> N >> W >> H;
    int hyp = sqrt(pow(W,2)+pow(H,2));
    for(int i = 0; i < N; i++) {
        int length;
        cin >> length;
        if(length <= hyp) {
            cout << "DA" << endl;
        }
        else {
            cout << "NE" << endl;
        }
    }
}