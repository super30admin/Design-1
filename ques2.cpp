Time Complexity-O(1)
Space Complexity-O(n)
Did the code run on Leetcode?Yes

#include <iostream>
#include<stack>
using namespace std;

class MinStack {
public:
    stack<int>s1;
    stack<int>s2;
    MinStack() {
       
    }
    
    void push(int x) {
        s1.push(x);
        if(s2.empty() || s1.top()<=s2.top())
        {
            s2.push(x);
        }
       
    }
    
    void pop() {
        if(s1.top()==s2.top())
        {
            s2.pop();
        }
        s1.pop();
    }
    
    int top() {
          cout<<s1.top();
          cout<<"\n";
        }
    
    int getMin() {
        cout<<s2.top();
        cout<<"\n";
    }
};


int main() {
	MinStack min;
	min.push(-2);
    min.push(0);
    min.push(-3);
    min.getMin();  
    min.pop();
    min.top();     
    min.getMin();   
	return 0;
}