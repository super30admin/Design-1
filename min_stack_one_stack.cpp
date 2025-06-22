// Time Complexity :O(1)
// Space Complexity :O(n) +  O(n) --only in worst case where we are adding all desecnding numbers
// so its better comare to two stacks method 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// here we are using only one stack 
// min to infinity,
//while pushing a val : if val <=min then push min and val and change val else push val
// while popping a val: if s.top() = min then pop two times  and set min to s.top(),
//else pop inly one time 



#include <iostream>
#include <stack>
#include <climits>
using namespace std;

class MinStack {
    public:
        stack<int> s;
        int min = INT_MAX;

        MinStack() {
            s.push(min);
        }
        
        void push(int val) {
            if(val <= min){ // if val is <= min then chang ethe value of min
                s.push(min); //push min to s and then  
                s.push(val); // pushing val to s and then                
                min = val; // chang ethe value of min to val
            }
            else{
                s.push(val); //push only value
            }
            
        }
        
        void pop() {
            if(s.top() <= min){
                s.pop(); //pop() one element 
                min = s.top(); // will get the min 
                s.pop(); // pop that min also
            }   
            else{
                s.pop(); //as we added only one num while pushing so remove only one num
            }
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