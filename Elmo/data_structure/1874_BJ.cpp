#include <iostream>
#include <stack>
#include <vector>
using namespace std;

stack<int> st;
vector<char> ans;


int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int num;
	bool valid = true;
	int n; 	cin >> n;
	int cur_num = 0;

	st.push(cur_num);
	cur_num++;

	for (int i = 0; i < n; i++) {
		cin >> num;
		
		while (st.top() < num) {
			st.push(cur_num);
			cur_num++;
			ans.push_back('+');
		}
		if (st.top() == num) {
			st.pop();
			ans.push_back('-');
		}
		else {
			valid = false;
		}
	}

	if (!valid) {
		cout << "NO" << '\n';
	}
	else {
		for (auto ch : ans) {
			cout << ch << '\n';
		}
	}

}