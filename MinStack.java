/**
    
    56
    45
    4
    48
    89
    STACK
    
    getMin = 4
    top = 56, and 56 not removed from the top of stack
    pop = 56, and 56 removed from the top of stack
    
    getMin operation:
    
    take two stacks, on preserving the order in which the elements have been added and other
    always keeping the track of the min element on the top
    
    push operation:
        add element to the top of the first stack
        int minVal = getTop from second stack
        if minVal > newVal, 
            then push the newVal to the top of the stack
        else
            keep on emptying the second stack and add to the third stack, till popped element is > than newVal
            then add the newVal to the second stack
            push back all the elements from third stack to second stack
            
    pop operation:
        int value = firstStack.pop();
        int minValue = secondStack.top();
        
        if(value == minValue) 
            secondStack.pop();
        else
            keep on poping the second value to the third stack till we found the value popped from firstStack
            when firstStack popped value is found in the second, than push all elements of third stack to second stack
            
            
    top operation:
        firstStack.top()
        
Time Complexity : 
    
    push: O(N)
    pop: O(N)
    peek: O(1)
    getMin: O(1)

Space Complexity : O(2N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :

    Yes I faced one problem where I a checking this.getMin() < x, 
    pop all elements to third stack, I kept on getting EmptyStackException 
    on getMin call, without checking the stack is empty


Collabedit: http://collabedit.com/7xg8d
**/

class MinStack {


    Stack<Integer> firstStack;
    Stack<Integer> secondStack;
    Stack<Integer> thirdStack;
    
    /** initialize your data structure here. */
    public MinStack() {
            firstStack = new Stack<>();
            secondStack = new Stack<>();
            thirdStack = new Stack<>();
    }
    
    public void push(int x) {
        
        boolean isFirstPush = this.isEmpty();
        
        
        firstStack.push(x);
        
        if(isFirstPush)
        {
            secondStack.push(x);
            return;
        }
        
        int minVal = this.getMin();
        
        if(minVal > x) {
            secondStack.push(x);
        }
        else
        {
            while(!this.secondStack.isEmpty() && this.getMin() < x) {
                
                int currentElem = secondStack.pop();
                thirdStack.push(currentElem);
               
            }
            
            secondStack.push(x);
            
            while(!thirdStack.isEmpty()) {
                
                int currentElem = thirdStack.pop();
                secondStack.push(currentElem);
            }
        }
    }
    
    public void pop() {
    
        int value = firstStack.pop();
        int minValue = this.getMin();
        
        if(value == minValue) {
            secondStack.pop();
            return;
        }
        else
        {
            while(!this.secondStack.isEmpty() && this.getMin() != value) {
                
                int currentElem = secondStack.pop();
                thirdStack.push(currentElem);
               
            }
            
            secondStack.pop();
            
            while(!thirdStack.isEmpty())
            {
                int currentElem = thirdStack.pop();
                secondStack.push(currentElem);
            }
            
        }
    }
    
    public int top() {
        return firstStack.peek();
    }
    
    public int getMin() {
        return secondStack.peek();
    }
    
    private boolean isEmpty() {
        return firstStack.isEmpty();
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