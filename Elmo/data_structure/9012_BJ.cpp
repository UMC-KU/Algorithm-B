#include <iostream>
#include <stack>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n; cin >> n;
    for (int i = 0; i < n; i++) {
        stack<char> s;
        string x; cin >> x;
        for (int j = 0; j < x.length(); j++) {
            if (x.at(j) == ')' && !s.empty() && s.top() == '(')s.pop();
            else s.push(x.at(j));
        }
        if (s.empty())cout << "YES" << "\n";
        else cout << "NO" << "\n";
    }
}