#include <iostream>
#include <math.h>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    string n;
    int b;
    cin >> n >> b;
    signed int answer = 0;
    for (int i = 0; i < n.length(); i++) {
        if (n[i] < 58) {
            int num = n[i] - 48;
            answer += num * (pow(b, n.length() - i - 1));
        }
        else {
            int num = n[i] - 'A' + 10;
            answer += num * (pow(b, n.length() - i - 1));
        }
    }
    cout << answer;
}