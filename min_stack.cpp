// Implementing a stack with push,pop,top and get min function
#include <iostream>
#include <stack>
#include <math.h>
using namespace std;

class MinStack
{
public:
    stack<int> main_stack;
    stack<int> min_stack;
    int minimum;
    MinStack()
    {
        int minimum = INT_MAX;
    }
    void push(int val)
    {
        main_stack.push(val);

        if (val < minimum)
        {
            minimum = val;
        }
        min_stack.push(minimum);
    }

    void pop()
    {
        main_stack.pop();
        min_stack.pop();
    }

    int top()
    {
        return main_stack.top();
    }

    int getMin()
    {
        return min_stack.top();
    }
};
int main()
{
    MinStack minstack;
    minstack.push(-2);
    minstack.push(0);
    minstack.push(-3);
    cout << minstack.getMin() << endl;
    // x.push(-2);
    // x.push(0);
    // x.push(-3);
    // cout << x.getMin();
}
