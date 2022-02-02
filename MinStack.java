/**
// Time Complexity :
    push- O(1)
    pop - O(1)
    top - O(1)
    getMinimum O(1) 
// Space Complexity :
    Total space complexity = Auxilary space + space used towards input.
    O(n) where n is the size of stack which contains collection of StackElement objects.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

## problem statement - Design Minimum Stack
push-
pop
top
getMinimum

all of those in constant time.


## Assumptions
- Stack will contains all integers
- Using Standard Stack datastructure in java

## possible Solutions

stack1 -  8 9
minimum - 8   

min - O(1)
space - O(n)

class Element
{
    int value;
    int min;
}
Stack -> element 
## TestCases
- check stack with zero elements
- perform all the operations.
**/

class StackElement{
    int value;
    int minSoFar;
    
    StackElement(int value)
    {
        this.value = value;
    }
}


class MinStack {
    
    Stack<StackElement> splStack;

    public MinStack() {
        splStack = new Stack<>();
    }
    
    public void push(int val) {
        
        StackElement stackElement = new StackElement(val);
        
        if (splStack.isEmpty())
        {
            stackElement.minSoFar = val;
            splStack.push(stackElement);
            return;
        }
        
        if (val < splStack.peek().minSoFar)
        {
            stackElement.minSoFar = val;
        }
        else
        {
            stackElement.minSoFar = splStack.peek().minSoFar;
        }
        
        splStack.push(stackElement);
    }
    
    public void pop() {
        
        if(!isEmpty())
        {
            splStack.pop();
        }
    }
    
    
    private boolean isEmpty(){
        return splStack.isEmpty();
    }
    
    public int top() {
        
        if (isEmpty())
        {
            return -1;
        }
        
        return splStack.peek().value;
    }
    
    public int getMin() {
        
        if (isEmpty())
        {
            return -1;
        }
        
        return splStack.peek().minSoFar;
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
 
 
 /**

Optimal approach using single stack.

// Time Complexity :
    push- O(1)
    pop - O(1)
    top - O(1)
    getMinimum O(1) 
// Space Complexity :
    Total space complexity = in worst case O(2n - 1) where n is the size of stack. Wrst case happens when incoming elements is alway <= minSofar.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

push- O(1)
top - O(1)
pop - O(1)
get - O(1)

5 5 4 4 3 3 2       5 4 3 2

min = 2


**/
class MinStack {
    
    Stack<Integer> splStack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        splStack = new Stack<>();
    }
    
    public void push(int val) {
        
        if (min == Integer.MAX_VALUE)
        {
            min = val;
            splStack.push(val);
            return;
        }
        
        if (val <= min)
        {
            splStack.push(min);
            min = val;
        }
        
        splStack.push(val);
    }
    
    public void pop() {
        
        if (splStack.peek() == min)
        {
            splStack.pop();
            
            if (!splStack.isEmpty())
            {
                min = splStack.pop();
            }
            else
            {
                min = Integer.MAX_VALUE;
            }
            
            return;
        }
        
        splStack.pop();
    }
    
    public int top() {

        return splStack.peek();
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