// 155. Min Stack (PR #2  S30)
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s;
    int minEle;
    
    public MinStack() {
        s = new Stack<>();
        minEle = Integer.MAX_VALUE;
        }
    
    public void push(int x) {
        if(x <= minEle)
        {
            s.push(minEle);
            minEle = x;
        }
        
        s.push(x);
    }
    
    public void pop() {
        int popped = s.pop();
        if(popped == minEle){
            minEle = s.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minEle;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


 /*

 Complexity Analysis 

 Time Complexity : O(1) for all operations.
 
 Space Complexity : O(n).
    Worst case is that all the operations are push. In this case, there will be 
    O(2⋅n)=O(n) space used. 
 */