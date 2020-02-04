/*
Time Complexity- O(1)

*/


import java.util.* ; 

class MinStack {

    //stack to be used
    private Stack<Integer> stack ; 
    //to keep track of minimum value
    private ArrayList<Integer> min ; 
    private int minimum ; 
    private int minIndex ; 
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>() ; 
        this.minimum = Integer.MAX_VALUE ;
        this.min = new ArrayList<>() ;
        this.minIndex = 0 ; 
    }
    
    public void push(int x) {
        stack.push(x); 
        if (x < minimum) {
            minimum = x ;
            min.add(minIndex++, minimum); 
        }
    }
    
    public void pop() {
        if (top() == minimum) {
             stack.pop() ;
            if (!stack.contains(minimum)) {
            min.remove(--minIndex) ; 
            minimum = min.get(--minIndex) ; 
        }
    } else
        {
            stack.pop() ; 
        }
    }
    
    public int top() {
        return stack.peek() ; 
    }
    
    public int getMin() {
        return minimum ; 
    }
}