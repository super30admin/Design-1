//Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

#include<iostream>
#include<stack>
using namespace std;

class MinStack {
public:
    /** initialize your data structure here. */
    stack<int> s; 
    stack<int> minst;  //maintain another stack to store the minimum element.
    MinStack() {

    }
   
    void push(int x) {
        //push new element onto stack
        s.push(x);
        //if minst is empty push new element, else push new element if it is less than top elemnt of minst
        if (minst.empty()) {
            minst.push(x);
        }
        else if (x <= minst.top()) {
            minst.push(x);
        }
    }

    void pop() {
        if (s.empty())
            return;
        //if the top element of stack and minstack are same pop top elemnt from both stacks.
        if (s.top() == minst.top()) {
            minst.pop();
        }
        s.pop();
    }

    int top() {
        if (s.empty())
            return 0;
        return s.top();
    }

    int getMin() {
        //return top of minst
        if (minst.empty())
            return 0;
        return minst.top();
    }
};


int main() {
    MinStack* obj = new MinStack();
    obj->push(1);
    obj->pop();
    int param_3 = obj->top();
    int param_4 = obj->getMin();
	return 0;
}