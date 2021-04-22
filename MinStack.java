// Time Complexity : push-O(1), pop-O(1), top-O(1), getMin-O(1)
// Space Complexity :0(2*30000) or O(2n)->O(n) where n is size of stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : during the pop operation I forgot to change the currMin, hence it was failing for
//                                           some test cases. But I figured it out with some print statment and corrected it
class MinStack {
    int[][] stack;
    int currMin;
    int top;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[30000][];
        currMin = Integer.MAX_VALUE;
        top = -1;
    }

    public void push(int val) {
        int[] data = new int[2];
        data[0] = val;
        currMin = Math.min(val, currMin);
        data[1] = currMin;
        stack[++top] = data;
    }

    public void pop() {
        top--;
        if(top==-1){
            currMin = Integer.MAX_VALUE;
        }
        else{
            currMin = Math.min(stack[top][1], Integer.MAX_VALUE);
        }
    }

    public int top() {
        return stack[top][0];
    }

    public int getMin() {
        return stack[top][1];
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