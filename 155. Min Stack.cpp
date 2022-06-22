// Time Complexity :O(1)
// Space Complexity :O(N)

class MinStack {
public:
    /** initialize your data structure here. */
   stack<int> st;
    stack<int> min_s;//stack to maintain minimum elemnt
    MinStack() {
        
    }
    
    void push(int val) {
        st.push(val);
        if(min_s.empty()){
            min_s.push(val);
        }
        else{
            int top=min_s.top();
            min_s.push(min(top,val));
            //the min stack holds only one element at a time.
            //if a new element is inserted the top of the min stack is popped
            //the minimum of the popped and the new elemnt is pushed into the stack. 
        }
    }
    
    void pop() {
        if(!st.empty()){
        st.pop();
        }
        min_s.pop();
    }
    
    int top() {
        return st.top();
    }
    
    int getMin() {
        return min_s.top();
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