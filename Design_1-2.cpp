#include<iostream>
using namespace std;
#include<stack>		//Standard STL library for stack imported.

class MinStack {			//Created class Minstack with functions : push,pop,top,getMin()
private:
    stack<int> s1;
    stack<int> s2;	
    int min=INT_MAX;		//Stack 1 and 2 are created to solve using 2 stacks.
public:
    void push(int x) {
        s1.push(x);
        if (s2.empty() || x <= s2.top())  s2.push(x);	// Function to push the element. Push in stack1 and 
        											//if element is smaller than top of stack2 only then push it in stack 2.
    					//The top of stack2 always stores minimum value.
    }
    
    void pop() {
        if (s1.top() == s2.top())  s2.pop();	// If the inserted value is same in Stack1 and Stack2. ie top is same and hence min value is same. then pop 
        									//from Stack2 and then stack1. If the value of Stack1 is greater 
        									//then only pop that as Stack 2->top represents only minimum value.
        									
        s1.pop();
    }
    int top() {
        cout<< s1.top();		//Get top value of stack1.
    }
    int getMin() {
        cout<< s2.top();		//Get the minimum value that is : top of stack2.
    }
};
int main()
{
    MinStack minstack1;	//Object of class created.
    minstack1.push(80);		//Push function implemented.
    minstack1.push(10);
    minstack1.push(40);

    minstack1.pop();	//Pops the element.
	
    minstack1.getMin();		//Returns the minimum element.

    return 0;
}

