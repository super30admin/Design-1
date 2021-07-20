// Your code here along with comments explaining your approach

//COMMENT ONE OF THE PROBLEM CODE WHILE RUNNING OTHER

//Problem-1
//CODE IS IN C++
// Time Complexity : O(1) and o(10^6) for initializing hash map
// Space Complexity : O(10^6)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Want to decrease Space Complexity

class MyHashMap {
public:
    /** Initialize your data structure here. */
    int a[1000001];
    MyHashMap() {
        memset(a, -1, sizeof(a));
    }
    
    /** value will always be non-negative. */
    void put(int key, int value) {
        a[key%1000001]=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {
        if(a[key%1000001]!=-1)
            return a[key%1000001];
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        a[key%1000001]=-1;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */

//----------------------------------------------------------------------------------------------------------------------------

//Problem-2
//Code is in c++
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Want to decrease Space Complexity
class MinStack {
public:
    /** initialize your data structure here. */
    stack<int>s1;
    stack<int>s2;
    MinStack() {
    }
    
    void push(int val) {
        s1.push(val);
        if(s2.empty()){
            s2.push(val);
            return;
        }
        if(s2.top()>=val){
            s2.push(val);
            return;
        }
        s2.push(s2.top());
    }
    
    void pop() {
        s1.pop();
        s2.pop();
    }
    
    int top() {
        return s1.top();
    }
    
    int getMin() {
        return s2.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */