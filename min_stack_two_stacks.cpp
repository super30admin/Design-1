// Time Complexity :O(1)
// Space Complexity :O(n) + O(n) === O(n) --as we are maintaing two stacks
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//maintaing two stacks s original stack and ms for maintaing min corresponds to the stack
//min variable to keep track of min



#include <iostream>
#include <stack>
#include <climits>
using namespace std;

class MinStack {
    public:
        stack<int> s;
        stack<int> ms;
        int min = INT_MAX;

        MinStack() {
            
            ms.push(min);
        }
        
        void push(int val) {
            if(val <= min){ // if val is <= min then chang ethe value of min
                min = val; // chang ethe value of min
            }
            s.push(val); // pushing val to s
            ms.push(min); // pushing min to ms one to one correspondence       
        }
        
        void pop() {
            s.pop(); //pop from main stack
            ms.pop(); // pop corresponding min 
            min = ms.top();  // min changes to top of ms as it keeps track of min         
        }
        
        int top() {
            return s.top(); // return top of s for top
        }
        
        int getMin() {
            return min; // return min variable
        }
    };

    int main(){

    MinStack* obj = new MinStack();
      obj->push(5);
      obj->push(3);
      obj->push(5);
      obj->push(2);

     int param_1 = obj->getMin();

      obj->pop();
     int param_3 = obj->top();
     int param_4 = obj->getMin();
     cout << param_1<<" "<<param_3<<" "<<param_4<<endl;
    

    } 