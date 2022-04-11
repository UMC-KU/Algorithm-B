#include <iostream>
#include <algorithm>
#include <vector>
#include <math.h>
using namespace std;

#define MAX_LENGTH 100000
vector<int> prime;

void isPrime(){
	bool flag = true;
	for (int j = 2; j < MAX_LENGTH; j++) {
		flag = true;
		for (int i = 2; pow(i,2) <= j; i++) {
			if (j % i == 0) {
				flag = false;
				break;
			}
		}
		if (flag) {
			prime.push_back(j);
		}
	}
}

bool checkSum(int x) {
	vector<int>::iterator it;
	for (int q = 2; q < x; q++) {
		it = find(prime.begin(), prime.end(), q);
		if (it != prime.end()) {
			int a = (x - q);
			if (a == q)continue;
			it = find(prime.begin(), prime.end(), a);
			if (it != prime.end()) {
				return true;
			}
			else continue;
		}
		else continue;
	}
	return false;
}

bool checkMul(int x) {
	vector<int>::iterator it;
	for (int k = 2; k < x; k++) {
		if (x % k == 0) {
			it = find(prime.begin(), prime.end(), k);
			if (it != prime.end()) {
				int a = (x / k);
				it = find(prime.begin(), prime.end(), a);
				if (it != prime.end()) {
					return true;
				}
				else continue;
			}
			else continue;
		}
	}
	return false;
}

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	isPrime();
	signed int k, m; cin >> k >> m;
	int len = 0;
	if (k == 1)len = 9;
	else if (k == 2)len = 99;
	else if (k == 3)len = 999;
	else if (k == 4)len = 9999;
	else if (k == 5)len = 99999;

	int ans = 0;

	for (int i = 2; i < MAX_LENGTH; i++) {
		if (i > len)break;
		int tmp = i;
		while (tmp % m == 0) {
			tmp /= m;
		}
		if (checkMul(tmp)) {
			if (checkSum(i))ans++;
		}
	}
	cout << ans;
}