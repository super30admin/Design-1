/**
 * Time Complexity: O(1);
 * Space Complexity: O(n);
 * Successfully ran on LeetCode;
 */

class MinStack {
    
    /** Created two stacks main and min. min-stack will store the min values */  
    Stack<Integer> main;
    Stack<Integer> min;
    int ele;
    
    /** MinStack Data Structure Initialization */
    public MinStack() {
        main = new Stack<Integer>();
        min = new Stack<Integer>();
    }
    
    /** Push function to push ele in main stack and update the min stack with latest min values */
    public void push(int x) {
        if(main.size() == 0) {
            ele = x;        
        }
        else if(x < ele){
            ele = x;
        }
        main.push(x);
        min.push(ele);        
    }
    
    /** Pop function to pop ele in main stack and update the min-ele in min stack */
    public void pop() { 
        if(main.size() > 0) 
        {
             main.pop();
        }
        if(min.size() > 0){       
            min.pop();    
            ele = min.peek();
        }       
    }
    
    /** top function to get the peek ele  */
    public int top() {
        if (main.size() > 0) {
            return main.peek();
        }
        return -1;
    }
    
    /** getMin function to get the min ele  */
    public int getMin() {
        if(min.size() > 0) {
            return min.peek(); 
        }
        return -1;
    }
}

