/*
Time Complexity- O(1)
Space Complexity- O(N), where N is the number of elements/items in the stack
The code passes all test cases on Leetcode and run successfully 
I had to work around the special case of empty stack. 
*/


import java.util.* ; 

class MinStack {
        
    //to keep track of min
    List<Integer> minA ;
    
    //the actual stack 
    Stack<Integer> stack ;
    //index for minA
    int minIndex ; 
    //variable that contains minimum
    int min ; 
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>() ; 
        minA = new ArrayList<>(); 
        minIndex = 0 ;
        //initially, when stack in empty
        min = Integer.MAX_VALUE ; 
        minA.add(minIndex++, min) ; 
    }
    
    public void push(int x) {
        stack.push(x) ; 
        //updating min
        if (x < min)
            min = x ; 
        //adding min to minA
        minA.add(minIndex++, min) ; 
    }
    
    public void pop() {
        stack.pop() ; 
        //we remove the min from minA
        minA.remove(--minIndex); 
        //we update the min to the last min in minA after pop
        min = minA.get(minIndex - 1) ; 
    }
    
    public int top() {
      return  stack.peek() ; 
    }
    
    public int getMin() {
        return min ;
    }
}