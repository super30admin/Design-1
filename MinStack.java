  
// Time Complexity : Push(x), pop(), top(), getMin() - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach:
Done using single stack approach. Storing Previous Min value under the new min Value.
class MinStack {
    Stack<Integer> s1;
    int mini=Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        s1=new Stack<>();
    }
    
    public void push(int x) {
        if(x<=mini)
        {
            s1.push(mini);
            mini=x; 
        }
        s1.push(x);
        
    }
    
    public void pop() {
      
        if(s1.pop()==mini)
        {
           // s1.pop();
            mini=s1.pop();
        }
    }
    
    public int top() {
        return s1.peek();
        
    }
    
    public int getMin() {
        return mini;
    }
}

