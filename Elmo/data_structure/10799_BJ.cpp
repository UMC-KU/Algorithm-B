#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	stack<char> st;
	string input; cin >> input;
	int total = 0;

	for (int i = 0; i < input.length(); i++) {
		if (input[i] == '(') st.push(input[i]);
		else if (input[i] == ')' and input[i - 1] == '(') { 
			st.pop();
			total += st.size();
		}
		else { 
			total++;
			st.pop();
		}
	}
	cout << total << endl;
}