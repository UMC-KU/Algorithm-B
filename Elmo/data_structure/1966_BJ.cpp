#include <iostream>
#include <queue>
using namespace std;
int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int count = 0;
    int tc; cin >> tc;
    int n, m;

    for (int i = 0; i < tc; ++i) {
        count = 0;
        cin >> n >> m;
        queue<pair<int, int>> q;
        priority_queue<int> pq;
        for (int j = 0; j < n; ++j) {
            int x;  cin >> x;
            q.push({ j, x });
            pq.push(x);
        }
        while (!q.empty()) {
            int index = q.front().first;
            int value = q.front().second;
            q.pop();
            if (pq.top() == value) {
                pq.pop();
                ++count;
                if (index == m) {
                    cout << count << endl;
                    break;
                }
            }
            else q.push({ index,value });
        }
    }
}