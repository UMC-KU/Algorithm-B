#include <iostream>
using namespace std;
int main() {
	int a, first, cnt = 0, C, B; cin >> a; first = a;
	while (true) { cnt++; if (a < 10)C = (a * 10) + a; else { B = (a / 10) + (a % 10); C = (a % 10) * 10 + (B % 10); } if (C == first)break; a = C; } cout << cnt << endl;
}