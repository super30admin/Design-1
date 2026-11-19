/* 
Time Complexity :
push - O(1)
pop - O(1)
topElement - O(1)
getminElement - O(1)

Space Complexity :
For stack s1 - O(n)
For stack minStack - O(n)
O(n) + O(n) = O(2n) -> O(n)

*/

/*
Did this code successfully run on Leetcode : Yes

 Any problem you faced while coding this : No
 
Your code here along with comments explaining your approach
My approach is to use two stacks.
1. The first stack is used to store all the elements and perform the stack operations -  
push, pop, and top.
2. The second stack called minStack, is used to maintain the minimum element at 
that given point of time.

Push - First, I will push the element into the main stack. If minStack is empty or the new
 element is less than or equal to its top element, I push it into minStack as well.
Pop - I will pop element from main stack and then compare that with top element in the
 minstack, if both are equal i will remove it from the minstack.
Minimum element - we need to return the top element present in the minstack -> which
 is minimum element at that point of time.
*/

import java.util.*;

public class MinStack{

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    MinStack(){
        
    }
    void push(int value){

        s1.push(value);

        if(minStack.isEmpty() || value <= minStack.peek()){
            minStack.push(value);
        }
    }

    void pop(){
        int poppedElement = s1.pop();
        if(minStack.peek() == poppedElement){
            minStack.pop();
        }
    }

    int topElement(){
        int Element = s1.peek();
        return Element;
    }

    int getminElement(){
        int minElement = minStack.peek();
        return minElement;
    }

    public static void main(String[] args) {
        
        MinStack obj = new MinStack();
        obj.push(7);
        obj.push(4);
        obj.pop();
        System.out.println("Top Element is :" + obj.topElement());
        obj.push(6);
        System.out.println("Min Element is :" + obj.getminElement());
        obj.push(10);
        System.out.println("Top Element is :" + obj.topElement());
        System.out.println("Min Element is :" + obj.getminElement());
        obj.push(4);
        obj.push(8);
        obj.pop();
        obj.push(2);
        System.out.println("Top Element is :" + obj.topElement());
        System.out.println("Min Element is :" + obj.getminElement());
    }
}








