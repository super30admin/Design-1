// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I was first tying using array, 
// then tried with 2 stack with O(n) complexity, then finally moved to this solution


// Your code here along with comments explaining your approach
// min variable will keep minimum till now and it will be updated on push and pop.
//we only push min if we get new min. we pop twice if min is popped to get updated min.

class MinStack {

    Stack<Integer> s;
    int min;
    public MinStack() {
        s = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if (x <= min) {
            s.push(min);
            min = x;
        }
        s.push(x);
    }
    
    public void pop() {
        if (s.pop() == min) {
            min = s.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}