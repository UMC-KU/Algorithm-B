#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <stack>
#include <set>
using namespace std;

bool visited[201];
bool arr[201];
set<string> s_set;
string str;
vector<pair<int, int>> v;

void dfs(int cnt, int idx) {
	if (cnt >= 1) {
		string s = "";
		for (int i = 0; i < str.size(); i++) {
			if (arr[i]) continue;
			s += str[i];
		}
		s_set.insert(s);
	}
	for (int i = idx; i < v.size(); i++) {
		if (visited[i]) continue;
		visited[i] = true;
		arr[v[i].first] = true;
		arr[v[i].second] = true;
		dfs(cnt + 1, idx + 1);
		visited[i] = false;
		arr[v[i].first] = false;
		arr[v[i].second] = false;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> str;
	stack<int> st;
	for (int i = 0; i < str.size(); i++) {
		if (str[i] == '(') st.push(i);
		else if (str[i] == ')') {
			v.push_back({ st.top(), i });
			st.pop();
		}
	}
	dfs(0, 0);
	for (auto x : s_set) {
		cout << x << "\n";
	}
	return 0;
}