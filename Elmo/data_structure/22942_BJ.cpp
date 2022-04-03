#include <iostream>
#include <stack>
#include <algorithm>
#include <vector>
using namespace std;

struct data_s { int pos, isOpen, idx; };
int n, x, r;
stack<int> st;
vector<data_s> v;

bool compare(const data_s& a, const data_s& b) {
	return a.pos < b.pos;
}

bool solution() {
	for (int i = 1; i < v.size(); i++)
		if (v[i - 1].pos == v[i].pos) return 0;
	for (int i = 0; i < v.size(); i++) {
		if (v[i].isOpen) st.push(v[i].idx);
		else if (v[i].idx == st.top()) st.pop();
		else return 0;
	}
	return 1;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> x >> r;
		v.push_back({ x - r, 1, i });
		v.push_back({ x + r, 0, i });
	}
	sort(v.begin(), v.end(), compare);
	cout << (solution() ? "YES" : "NO");
}
