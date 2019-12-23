// Time Complexity :
//      push() - O(1)
//      pop() - O(1)
//      top() - O(1)
//      getMin() - O(1)
//      findMin() - O(top)
//      
// Space Complexity :
//      overall - O(n)
//      push() - O(1)
//      pop() - O(1)
//      top() - O(1)
//      getMin() - O(1)
//      findMin() - O(1)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {

    static final int MAX = 1000;
    int[] array;
    int top;
    int minElm;

    /** initialize your data structure here. */
    public MinStack() {
        array = new int[MAX];
        top = -1;
        minElm = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(top == MAX - 1)
        {
            System.out.println("Stack Overflow");
        }
        else
        {
            array[++top] = x;
            if(x <= minElm)
                minElm = x;
        }
    }
    
    public void pop() {
        if(top == -1)
        {
            System.out.println("Stack Underflow");
        }
        else
        {
            if(array[top] > minElm)
            {
                --top;
            }
            else
            {
                --top;
                findMin();
            }
        }
    }
    
    public int top() {
        if(top == -1)
        {
            System.out.println("Stack Underflow");
            return 0;
        }
        else
        {
            return array[top];
        }
    }
    
    public int getMin() {
        return minElm;
    }
    
    private void findMin() {
        minElm = Integer.MAX_VALUE;
        for(int i=top; i >= 0; --i)
        {
            if(array[i] <= minElm)
                minElm = array[i];
        }
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
