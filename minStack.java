/*
Author: Akhilesh Borgaonkar
Approach: I have implemented using 1 stack and a min variable which stores the minimum element at any given time.
Time Complexity: O(1) for getMin()
Space Complexity: O(n) where n is number of elements in stack
LC verified
*/

class MinStack {

    Stack<Integer> mystack;
    int min = Integer.MAX_VALUE;        //used to maintain minimum element in stack

    public MinStack() {
         mystack = new Stack<>();       //initializing my stack
    }
    
    public void push(int x) {
        
        if(x<=min){
            mystack.push(min);          //if the current element to be pushed is less than min then 
                                            push the old minimum first and then update min with current x
            min=x;
        }
        mystack.push(x);                //else push to stack
    }
    
    public void pop() {
        
        if(mystack.pop()==min)          //check if popped element is current min. If yes, pop twice.
            min=mystack.pop();
    }
    
    public int top() {
        return mystack.peek();          //peek gives top element in stack without poping
    }
    
    public int getMin() {
        return min;                     //returning min variable which is updated at every new element if required
    }
}
