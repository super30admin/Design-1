// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> S;
     int Min;

    public MinStack() {
        S = new Stack<>();
        Min = Integer.MAX_VALUE;
         
    }
    
    public void push(int val) {
        if(Min>=val) {
            S.push(Min);
            Min = val;
        }
        S.push(val);
    }
    
    public void pop() {
      if (S.isEmpty()) {
        return;
      }
        int popped = S.pop();
        if (popped == Min){
            Min = S.pop();
        }
    }
    
    public int top() {
        return S.peek();
    }
    
    public int getMin() {
        return Min;
    }
}

