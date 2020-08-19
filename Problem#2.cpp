// C++ program to implement a stack that supports 
// getMinimum() in O(1) time and O(1) extra space. 
#include <iostream> 
#include <stack>
#include <climits>

using namespace std; 

 
class MinStack {
public:
	
    /** initialize your data structure here. */
    
    stack<int> s;
    int	minEle = INT_MAX;
    
    MinStack() { 

	}
    
    // Stack member function to insert an element to stack.
    void push(int x) {
        if (s.empty())
        { 
            minEle = x;
            s.push(x);
        }
        
        if (x >= minEle)    
            s.push(x);
        else if (x< minEle)
        {
            s.push((2*x)-minEle);
            minEle = x;    
         }    
    }
    
    // Stack member function to delete an element from stack.
    void pop() {
        if(s.empty())
        {
            return;
        }
        
        int y = s.top();
        s.pop();
        
        if (y < minEle)
        {
            minEle = ((2*minEle)-y);         
        }
    }
    
    // member function to get the top element of the stack.
    int top() {
        int y= s.top();
        cout<< "Top element of the stack is : "<<y<<endl;
        return y;
    }
    
    // function to get the minimum element from the entered elements. 
    int getMin() {
            cout<<" Minimum element of the stack is : "<<minEle<<endl;
            return minEle;
    }   

};

// Driver Code 
int main() 
{ 
	MinStack s; 
    s.push(5); 
	s.push(4); 
	s.push(5); 
	s.push(5); 
    s.push(7); 
	s.push(8); 
	s.push(7); 
    s.top();
	 
//	s.pop(); 
	s.getMin(); 
	//s.pop(); 


	return 0; 
} 
