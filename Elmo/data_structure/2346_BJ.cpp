#include <iostream>
#include <utility>
#include <vector>
using namespace std;

int main() {
    cin.tie(0);
    cout.tie(0);
    ios_base::sync_with_stdio(0);
    int n; cin >> n;
    vector<pair<int, int>> v;

    for (int i = 1; i <= n; i++) {
        int x; cin >> x;
        v.push_back(make_pair(i, x));
    }
    while (!v.empty()) {
        cout << v.front().first << " ";
        int num = v.front().second;
        v.erase(v.begin());
        if (v.empty()) break;
        if (num > 0) {
            for (int i = 0; i < num - 1; i++) {
                v.push_back(v.front());
                v.erase(v.begin());
            }
        }
        else {
            for (int i = 0; i < abs(num); i++) {
                v.insert(v.begin(), v.back());
                v.erase(v.end() - 1);
            }
        }
    }
}
