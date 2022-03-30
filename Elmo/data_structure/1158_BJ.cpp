#include <iostream>
#include <vector>
using namespace std;
vector<int> v;

int main() {
    int n, k, i,start = -1;
    cin >> n >> k;
    for (i = 1; i <= n; i++) v.push_back(i);
    cout << "<";
    while (v.size() != 1) {
        start += k;
        if (start >= v.size()) start %= v.size();
        cout << v[start] << ", ";
        v.erase(v.begin() + start);
        start--;
    }
    cout << v[0]<<">";
}