#include <iostream>
using namespace std;

int GCD(int a, int b) {
	return a % b ? GCD(b, a % b) : b;
}

int LCM(int a, int b, int x) {
	return x * (a / x) * (b / x);
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n, a, b; cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		int gcd = GCD(a, b);
		int lcm = LCM(a, b, gcd);
		cout << lcm << "\n";
	}
}