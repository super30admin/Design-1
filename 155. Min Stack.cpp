/*
Time: O(1)
Space: O(n)

Use two stacks, one for holding values and one for encountered minimums.
If the value to be inserted is greater than current stack top, it will never be minimum, so we don't need to push it to min stack
However, if the value is smaller or equal to current top, then in future it can be a minimum (by popping any other minimum values that is inserted on top of it), so we need to push it onto min stack
*/
class MinStack {
public:
    vector<int> st, mini;
    MinStack() {
      st = {};
      mini = {};
    }
    
    void push(int val) {
      st.push_back(val);

      if(mini.empty() || mini[mini.size()-1] >= val)  mini.push_back(val);
    }
    
    void pop() {
      if(st[st.size()-1] == mini[mini.size()-1])  mini.pop_back();
      st.pop_back();
    }
    
    int top() {
      return st[st.size()-1]; 
    }
    
    int getMin() {
      return mini[mini.size()-1];
    }
};

