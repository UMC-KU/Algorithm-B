#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    string str; cin >> str;
    string ans;
    stack<char> st;

    for (int i = 0; i < str.length(); i++){

        if ('A' <= str[i] && str[i] <= 'Z')
            ans += str[i];
        else{
            switch (str[i]){
            case '(':
                st.push(str[i]);
                break;
            case '*':
            case '/':
                while (!st.empty() && (st.top() == '*' || st.top() == '/')){
                    ans += st.top();
                    st.pop();
                }
                st.push(str[i]);
                break;
            case '+':
            case '-':
                while (!st.empty() && st.top() != '('){
                    ans += st.top();
                    st.pop();
                }
                st.push(str[i]);
                break;
            case ')':
                while (!st.empty() && st.top() != '('){
                    ans += st.top();
                    st.pop();
                }
                st.pop();
                break;
            }
        }
    }
    while (!st.empty()) {
        ans += st.top();
        st.pop();
    }
    cout << ans << "\n";
    return 0;
}
