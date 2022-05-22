#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
using ull = unsigned long long;

const unsigned long long limit = (ull)1 << 63;

void convert(string x, string y);
ull f(string s, ull x);

struct info {
	ull a;
	int b, c;
};
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	string a, b;
	cin >> a >> b;
	convert(a, b);
	return 0;
}
void convert(string x, string y)
{
	int mx = -1, my = -1;
	ull ret = 0;
	reverse(x.begin(), x.end());
	reverse(y.begin(), y.end());
	for (int i = 0; i < x.length(); i++)
	{
		if ('0' <= x[i] && x[i] <= '9')
			mx = max(mx, x[i] - '0');
		else
			mx = max(mx, x[i] - 'a' + 10);
	}
	for (int i = 0; i < y.length(); i++)
	{
		if ('0' <= y[i] && y[i] <= '9')
			my = max(my, y[i] - '0');
		else
			my = max(my, y[i] - 'a' + 10);
	}
	vector<info> v;
	for (int i = mx + 1; i <= 36; i++)
	{
		for (int j = my + 1; j <= 36; j++)
		{
			if (i == j)continue;

			ull tx = f(x, i);
			ull ty = f(y, j);

			//if (tx == ty)cout << tx << " " << ty;
			if (tx < limit && ty < limit && tx == ty)
				v.push_back({ tx,i,j });
		}
	}
	if (v.empty())cout << "Impossible";
	else if (v.size() >= 2) cout << "Multiple";
	else cout << v[0].a << " " << v[0].b << " " << v[0].c;

}
ull f(string s, ull x)
{
	ull ret = 0;
	for (int i = 0; i < s.length(); i++)
	{
		ull plus = 0;
		if ('0' <= s[i] && s[i] <= '9')
			plus = (ull)(s[i] - '0');
		else
			plus = (ull)(s[i] - 'a' + 10);
		ret += (plus * (ull)pow(x, i));
	}
	return ret;
}