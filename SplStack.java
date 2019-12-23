// Time Complexity :
//      push() - O(1)
//      pop() - O(1)
//      top() - O(1)
//      getMin() - O(1)
//      
// Space Complexity :
//      overall - O(n)
//      push() - N/A
//      pop() - N/A
//      top() - N/A
//      getMin() - N/A
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class SplStack {

    static final int MAX = 1000;
    int[] array;    // array to keep the stack elements
    int[] minA;     // array to track minimum values at each time instant
    int top;        // variable to track the top of the stack

    /** initialize your data structure here. */
    public SplStack() {
        //instantiate the array to max size
        array = new int[MAX];
        //instantiate the array to keep local minima
        minA = new int[MAX];
        //instantiate top to -1;
        top = -1;
    }
    
    public void push(int x) {
        //check for stack overflow
        if(top == MAX - 1)
        {
            System.out.println("Stack Overflow");
        }
        else
        {
            //assign x to the (top+1)th element in the array
            array[++top] = x;
            if(top < 1)
            {
                //The first element inserted will be the minimum element at the start
                minA[top] = array[top];
            }
            else
            {
                //We check if the new element is lesser than the minimum value before this operation 
                if(array[top] <= minA[top-1])
                {
                    minA[top] = array[top];
                }
                else
                {
                    //assign previous minimum to the current time instant
                    minA[top] = minA[top - 1];
                }
            }
        }
    }
    
    public void pop() {
        //check for stack underflow
        if(top == -1)
        {
            System.out.println("Stack Underflow");
        }
        else
        {
            //decrement top variable
            --top;
        }
    }
    
    public int top() {
        //check for stack underflow
        if(top == -1)
        {
            System.out.println("Stack Underflow");
            return 0;
        }
        else
        {
            //return the top most element
            return array[top];
        }
    }
    
    public int getMin() {
        //get the current time instant mimimum value
        return minA[top];
    }

    public static void main(String[] args) {
        SplStack splStack = new SplStack();
        splStack.push(-2);
        splStack.push(0);
        splStack.push(-3);
        System.out.println("Minimum Value = " + splStack.getMin());   //--> Returns -3.
        splStack.pop();
        System.out.println("Popped Item = " + splStack.top());     //--> Returns 0.
        System.out.println("Minimum Value = " + splStack.getMin());   //--> Returns -2.
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
