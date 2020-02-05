// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this :
// Yes. I couldn't solve the problem before class by myself. I had to look at available solutions to understand the concept. I also took the logic from yesterday's class and then wrote my code.

// Your code here along with comments explaining your approach


class MinStack {

    private Stack<Integer> s1, s2;


    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    /** performing push operation */
    public void push(int x) {
        s1.push(x);
        if(s2.isEmpty() || x <= s2.peek()) // instead of using infinity I am using an empty check here itself.
            s2.push(x);
    }
    
    public void pop() {
        int x = s1.pop();
        if(x == s2.peek()) // am checking if the item poped from s1 is equivalent to the last item stored in s2, if yes then performing pop operation in s2.
            s2.pop();
    }
    
    public int top() {
       return s1.peek(); 
    }
    
    public int getMin() {
        return s2.peek();
    }
}

