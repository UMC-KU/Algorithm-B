#include <iostream>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    int a, b, c, m; cin >> a >> b >> c >> m;
    int pi = 0, work = 0;
    for (int i = 0; i < 24; i++) {
        if ((pi + a) > m) {
            pi -= c;
            if (pi < 0)pi = 0;
        }
        else {
            pi += a;
            work += b;
        }
    }
    cout << work;
}