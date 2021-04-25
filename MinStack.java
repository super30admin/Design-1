/** Leet Code Problem 155
    Min Stack
    Language Used : Java
    Link: https://leetcode.com/problems/min-stack/
    Runtime: 5 ms, faster than 52.99% of Java online submissions for Min Stack.
    Memory Usage: 40.9 MB, less than 23.38% of Java online submissions for Min Stack.

Explaination:

 Data Structures Used : 2 Stacks s1 and s2
 S1 stores the stack itself and s2 stores the minimum of every addition as the history of min also needs to be maintained.
 The reason why the history of min is maintained is because every time the stack is pop-ed the value of min changes. 
 Two approaches - one with 2 stacks and one with a single stack.
 */

// Approach 1 
// Using Two Stacks
class MinStack {
    Stack<Integer> s1;
    Stack<Integer> s2;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>(); 
        s2.push(Integer.MAX_VALUE);
        min = s2.peek();
    }
    
    public void push(int val) {
        s1.push(val);
        min = Math.min(min,val);
        s2.push(min);
    }
    
    public void pop() {
        s1.pop();
        s2.pop();
        min = s2.peek();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return min;
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

// Approach 2
// Here we store the history also in a single task to know if its the history or element, we make sure we only put the min if there is a value change. 

/**
Runtime: 5 ms, faster than 52.99% of Java online submissions for Min Stack.
Memory Usage: 40.3 MB, less than 93.57% of Java online submissions for Min Stack.
 */

class MinStack {
    Stack<Integer> s1;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        s1.push(Integer.MAX_VALUE);
        min = s1.peek();
    }
    
    public void push(int val) {
        if(val<=min){
            s1.push(min);
            min=val;
        }
        s1.push(val);
    }
    
    public void pop() {
        if(s1.pop()==min){
            min=s1.pop();
        }
        
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
        return min;
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