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

    //Prints out the minimum Element unless stack is empty
    void getMin()
    {
        if (myStack.empty())
            cout<<"Stack is empty";
        else    
            cout<<minimumElement<<endl;
    }

    /*
        Two scenarios to be considered.
        1. If top is greater than/equal to min value then print it. 
        1. If the top is the min value then 
    
     */
    void pop()
    {
        if(myStack.empty())
            cout<<"Stack is empty";
        
        int top = myStack.top();
        myStack.pop();
        
        if(top < minimumElement)    
            minimumElement = 2*minimumElement - top;
        else
            cout<<top;

    }

    void peek()
    {
        if(myStack.empty())
            cout<<"Stack is empty";
        
        int top = myStack.top();

        if(top < minimumElement)
            cout<<minimumElement;
        else
            cout<<top;
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