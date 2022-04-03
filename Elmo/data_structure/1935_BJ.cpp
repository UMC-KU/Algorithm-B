#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main(){
	cin.tie(0);
	cout.tie(0);
	ios_base::sync_with_stdio(0);
	int n;
	string str;
	cin >> n >> str;

	vector<int> v(n);
	stack<double> st;

	for (int i = 0; i < n; i++) cin >> v[i];

	for (int i = 0; i < str.length(); i++){
		if (str[i] >= 'A' && str[i] <= 'Z') st.push(v[str[i] - 'A']);
		else{
			if (!st.empty()){
				double tmp = st.top();
				st.pop();
				if (str[i] == '+') tmp = st.top() + tmp;
				else if (str[i] == '-') tmp = st.top() - tmp;
				else if (str[i] == '*') tmp = st.top() * tmp;
				else if (str[i] == '/') tmp = st.top() / tmp;
				st.pop();
				st.push(tmp);
			}
		}
	}
	cout << fixed;
	cout.precision(2);
	cout << st.top() << '\n';

	return 0;
}
