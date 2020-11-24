// Time Complexity - O(1) for push, pop, and getMin()
// Space Complexity - O(2N), N elements in stack

class MinStack {

    Stack<Integer> s1;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<=min) {
            s1.push(min);
            min = x;
        }
        s1.push(x);
    }
    
    public void pop() {
        int x = s1.pop();
        if(x == min) {
           min = s1.pop();
        }
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return min;
    }
}
