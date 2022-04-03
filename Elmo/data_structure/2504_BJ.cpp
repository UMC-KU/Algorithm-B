#include <iostream>
#include <stack>
#include <string>
using namespace std;

stack<char> s;

int main(void){
    ios_base::sync_with_stdio(0);
    cin.tie(0); 
    cout.tie(0);
    string input; cin >> input;
    int result = 0, tmp = 1;
    bool isWrong = false;

    for (int i = 0; i < input.size(); i++){
        if (input[i] == '('){
            tmp *= 2;
            s.push('(');
        }
        else if (input[i] == '['){
            tmp *= 3;
            s.push('[');
        }
        else if (input[i] == ')' && (s.empty() || s.top() != '(')){
            isWrong = true;
            break;
        }
        else if (input[i] == ']' && (s.empty() || s.top() != '[')){
            isWrong = true;
            break;
        }
        else if (input[i] == ')'){
            if (input[i - 1] == '(')
                result += tmp;
            s.pop();
            tmp /= 2;
        }
        else if (input[i] == ']'){
            if (input[i - 1] == '[') result += tmp;
            s.pop();
            tmp /= 3;
        }
    }
    if (isWrong || !s.empty()) cout << 0 << "\n";
    else cout << result << "\n";
    return 0;

}