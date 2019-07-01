#include <iostream>
#include<stdlib.h>
#include <stack>

using namespace std;

/*
    Referenced from GeeksforGeeks
*/

class SpecialStack 
{

public:
    int minimumElement;
    stack<int> myStack;

    void getMin()
    {
        if (myStack.empty())
            throw exception("Stack is empty");
        cout<<minimumElement<<endl;
    }

    void pop()
    {
        if(myStack.empty())
            throw exception("Stack is empty");
        
        int t = myStack.top();
        myStack.pop();
    }

    void peek()
    {
        if(myStack.empty())
            throw exception("Stack is empty");
        
        int t = myStack.top();

        if(t < minimumElement)
            cout<<minimumElement;
        else
            cout<<t;
    }

    void push(int x)
    {
        if(myStack.empty)
        {
            minimumElement = x;
            myStack.push(x);
            return;
        }

        if(x < minimumElement)
        {
            myStack.push(2*x - minimumElement);
            minimumElement = x;
        }

        else
            myStack.push(x);
    }

};