#include <iostream>
#include <stack>
#include <bits/stdc++.h>

using namespace std;


class MinStack {
    stack<int> s;
    stack<int> minStack;

public:
    /** initialize your data structure here. */
    MinStack()
    {
        minStack.push(INT_MAX);
    }
    
    void push(int x)
    {
        s.push(x);
        minStack.push(min(minStack.top(), x));
    }
    
    void pop()
    {
        s.pop();
        minStack.pop();
    }
    
    int top()
    {
        return s.top();
    }
    
    int getMin()
    {
        return minStack.top();   
    }
};

int main()
{
    MinStack m;

    m.push(5);
    m.push(3);
    m.push(9);
    cout << "Min = " << m.getMin() << endl;

    m.pop();
    m.pop();
    cout << "Min = " << m.getMin() << endl;

    m.push(1);
    cout << "Min = " << m.getMin() << endl;
    
    m.pop();
    m.pop();
    cout << "Min = " << m.getMin() << endl;

    return 0;
}
