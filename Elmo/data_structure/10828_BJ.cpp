#include <iostream>
#include <stack>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    stack<int> stack;
    cin >> n;
    for (int i = 0; i < n; i++) {
        string s;
        cin >> s;
        if (s == "push") {
            int x; cin >> x;
            stack.push(x);
        }
        else if (s == "top") {
            if (!stack.empty())cout << stack.top() << "\n";
            else cout << -1 << "\n";
        }
        else if (s == "size") {
            cout << stack.size() << "\n";
        }
        else if (s == "empty") {
            if (stack.empty())cout << 1 << "\n";
            else cout << 0 << "\n";
        }
        else if (s == "pop") {
            if (!stack.empty()) {
                cout << stack.top() << "\n";
                stack.pop();
            }
            else cout << -1 << "\n";
        }
    }
}