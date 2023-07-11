//Problem 1: https://leetcode.com/problems/design-hashset/
// Time Complexity :  O(N) where n is the number of entries in bool array
// Space Complexity : O(N) where n is the number of entries in bool array
// Here number of entries = 1001000
// Did this code successfully run on Leetcode :
//Answer - Yes
// Any problem you faced while coding this :
//Answer - No

// Your code here along with comments explaining your approach


/*class MyHashSet {
public:
bool arr[1000][1001]; //first take a 2d boolean array to track the elements present in the boolean array
    MyHashSet() { 
        
     
        for(int i=0;i<1000;i++){
        
             for(int j=0;j<=1000;j++){
arr[i][j] =false; //setting false for every entry since no element is present in hashset
             }
        }
    }
    
    void add(int key) {
     
     
arr[key%1000][key/1000]= true; //setting true for the element added which means element is added in the hashset
     
        
    }
    
    void remove(int key) {
    
arr[key%1000][key/1000]= false; //setting true for the element removed which means element is no more present in the hashset
      
    }
    
    bool contains(int key) {
         
return arr[key%1000][key/1000]; / returns true in case key is present  in hashset otherwise returns false;
    
        
    }
};
*/
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */


 //Problem 2: https://leetcode.com/problems/min-stack/
// Time Complexity :  O(1)
// Space Complexity : O(1)

// Did this code successfully run on Leetcode :
//Answer - Yes
// Any problem you faced while coding this :
//Answer - No

// Your code here along with comments explaining your approach


/* Approach: we will have two stacks one keeping the track of minimums and one a simple stack 

we will push into minimum stack only if the top of the minimum stack is larger than the current element.

By doing this we will make sure we have the current sequence of minimums along with our regular stack
*/

/*

class MinStack {
    stack<int> minstack; 
     stack<int> mystack; 

public:
    MinStack() {
      

    }
    
    void push(int val) {
        if(minstack.empty()||minstack.top()>=val){
            minstack.push(val);
        }
        mystack.push(val);
    }
    
    void pop() {
        if(mystack.top()==minstack.top()){
            minstack.pop();
        }
         mystack.pop();
    }
    
    int top() {
         return mystack.top();
    }
    
    int getMin() {
        return minstack.top();
    }
};
*/
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */