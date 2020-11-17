// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :none



// Your code here along with comments explaining your approach
class MinStack {
    
        int max= 8000;
        int top =-1;
        int[][] arr = new int[max][2];

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        int min;
        if(top>-1)
         min=arr[top][1];
        else
            min=x;
        if(x<=min){
            arr[++top]=new int[]{x,x};
        }
        else{
            arr[++top]=new int[]{x,min};
        }
    }
    
    public void pop() {
        top--;
    }
    
    public int top() {
            return  arr[top][0];
    }
    
    public int getMin() {
        return arr[top][1];
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