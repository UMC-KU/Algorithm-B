#include <iostream>
#include <string>
using namespace std;
const int MAX = 50;
int N, M;
int cache[MAX][4]; //i번째, {A, C, G, T}

int main(void)
{
    ios_base::sync_with_stdio(0);
    cin.tie(0); 
    cin >> N >> M;

    for (int i = 0; i < N; i++){

        string temp;  cin >> temp;

        for (int j = 0; j < temp.length(); j++)
            switch (temp[j]){
            case 'A':
                cache[j][0]++;
                break;
            case 'C':
                cache[j][1]++;
                break;
            case 'G':
                cache[j][2]++;
                break;
            case 'T':
                cache[j][3]++;
                break;
            }
    }
    //Hamming Distance 기록
    int result = 0;
    string DNA = "";
    for (int i = 0; i < M; i++){
        int idx = 0, cnt = 0;
        for (int j = 0; j < 4; j++)
            if (cache[i][j] > cnt){
                idx = j;
                cnt = cache[i][j];
            }
        result += (N - cnt);
        switch (idx){
        case 0:
            DNA += 'A';
            break;
        case 1:
            DNA += 'C';
            break;
        case 2:
            DNA += 'G';
            break;
        case 3:
            DNA += 'T';
            break;
        }
    }
    cout << DNA << "\n";
    cout << result << "\n";
}