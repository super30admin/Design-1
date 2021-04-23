// Time Complexity :  O(1)
// Space Complexity : O(n) n->Size of the stck
// Did this code successfully run on Leetcode :Yes 
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class MinStack {
    stack<pair<int,int>> st;  //Stack STL which stores pairs {elem,min_elem}
    
public:
    /** initialize your data structure here. */
    MinStack() {
        //stack<pair<int,int>> st; //Initialize stack
    }    
    void push(int val) {
        int mn=val;
        if(!st.empty()){
            mn = min(mn,st.top().second); //comparing to be newly pushed element with min value
        }
        st.push({val,mn});
    }
    
    void pop() {
        st.pop(); //pop
    }
    
    int top() {
        return st.top().first; //top
    }
    
    int getMin() {
        return st.top().second; //getMin
        
    }
};

 

