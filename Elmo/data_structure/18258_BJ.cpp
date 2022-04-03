#include <iostream>
using namespace std;
int arr[2000001];
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, l=0, front = 0; cin >> n;
    for (int i = 0; i < n; i++) {
        string s; cin >> s;
        if (s == "push") {
            int x; cin >> x;
            arr[l++] = x;
        }
        else if (s == "front") {
            if (l > front) cout << arr[front] << "\n";
            else cout << -1 << "\n" ;
        }
        else if (s == "back") {
            if (l > front) cout << arr[l-1] << "\n";
            else cout << -1 << "\n";
        }
        else if (s == "size") {
            cout << l-front << "\n";
        }
        else if (s == "empty") {
            if (l == front) cout << 1 << "\n";
            else cout << 0 << "\n";
        }
        else if (s == "pop") {
            if (l > front) cout << arr[front++] << "\n";
            else cout << -1 << "\n";
        }
    }

}