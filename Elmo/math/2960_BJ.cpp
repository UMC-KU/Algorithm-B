#include <iostream>
#include <vector>
using namespace std;

vector<int> arr;
int k, answer;

bool isPrime(int x) {
	for (int z = 2; (z * z) <= x; z++) {
		if (x % z == 0)return false;
	}
	return true;
}

void erase(int x) {
	for (int j = 0; j < arr.size(); j++) {
		if (arr[j] % x == 0) {
			k--;
			if (k == 0) {
				answer = arr[j];
				return;
			}
			arr.erase(arr.begin() + j);
			j--;
		}
	}
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	int n; cin >> n >> k;
	for (int i = 2; i <= n; i++) {
		arr.push_back(i);
	}
	while (k != 0) {
		if (isPrime(arr[0])) {
			int x = arr[0];
			erase(x);
		}
	}
	cout << answer;
}