// 155. Min Stack - https://leetcode.com/problems/min-stack/
// Time Complexity : O(1)
// Space Complexity : O(2N) ~ O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

class MinStack {

    /** initialize your data structure here. */
    int[] stack = new int[10000];
    int[] min = new int[10000];
    int topPtr;
    int minPtr;
    
    public MinStack() {
        topPtr=-1;
        minPtr=-1;
    }
    
    public void push(int val) {
        if(topPtr>=10000)
        {
            return;
        }
        stack[++topPtr]=val;
        if(minPtr>=0)
        {
            if(min[minPtr] > val)
            {
                min[++minPtr]=val;
            }
            else
            {
                min[minPtr+1]=min[minPtr];
                minPtr +=1;
            }
        }
        else
        {
            min[++minPtr] = val;
        }
    }
    
    public void pop() {
        if(topPtr < 0)
        {
            return;
        }
        topPtr -= 1;
        minPtr -= 1;
    }
    
    public int top() {
        return stack[topPtr];
    }
    
    public int getMin() {
        return min[minPtr];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
