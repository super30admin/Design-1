// Time Complexity : O(1) for all operations
// Space Complexity : O(N), if elements are pushed in descending order.
// Leetcode : https://leetcode.com/problems/min-stack/

// Your code here along with comments explaining your approach

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> data;
    Integer minEl;
    public MinStack() {
        data = new Stack<>();
        minEl = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
	//push element and also the minimum element if currEl<=minEl
         if(x <= minEl){
            data.push(minEl);
            minEl=x;
        }
        data.push(x);
        
    }
    
    public void pop() {
	//pop both the elements if the popped element is equal to the min Element
        int popped=data.pop();
        if(popped==minEl){
            minEl=data.pop();
        }
        
    }
    
    public int top() {
	//return top element aka using peek
        return data.peek();
    }
    
    public int getMin() {
	//return minEl
        return minEl;
        
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


