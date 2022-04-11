#include <iostream>
#include <math.h>
#include <string>
using namespace std;

bool isPrime(int x) {
    if(x == 1)return false;
    for (int i = 2; (i * i) <= x; i++) {
        if (x % i == 0)return false;
    }
    return true;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int start, last; cin >> start >> last;
    bool answer = true;
    for(int j = start; j<=last ; j++){
        if (isPrime(j)) {
            string s = to_string(j);
            answer = true;
            for (int i = 0; i < (s.length() / 2); i++) {
                if (s[i] != s[s.length() - i - 1]) {
                    answer = false;
                    break;
                }
            }
            if (answer) cout << j << "\n";
        }
    }
    cout << -1;
}