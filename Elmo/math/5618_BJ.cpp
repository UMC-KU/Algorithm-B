#include <iostream>
using namespace std;

int gcd(int a, int b) {
	return a % b ? gcd(b, a % b) : b;
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	int n, a, b, i;
	cin >> n;
	cin >> a >> b;
	a = gcd(a, b);
	if (n == 3) {
		cin >> b;
		a = gcd(a, b);
	}
	for (i = 1; i * i < a; i++)
		if (a % i == 0)
			cout << i << "\n";
	if (i * i == a) cout << i << "\n";
	for (i--; i; i--) if (a % i == 0) cout << a / i << "\n";
}