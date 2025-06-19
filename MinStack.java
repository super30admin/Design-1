// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Used two stack approach, one stack for pushing normal elements and other stack to keep track of minimum at every level
// min variable stores the running minimum and is pushed alongside each value
// When popping, both stacks are updated and the previous min is restored
// If stack is empty i return -1 (edge case)




import java.util.*;

public class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack(){
        st = new Stack<>();
        minSt = new Stack<>();
        min=Integer.MAX_VALUE;
        minSt.push(min);
       
    }

    public void push(int val){
        if (val<=min){
            min=val;
        }
        st.push(val);
        minSt.push(min);

    }
    public void pop(){
        st.pop();
        minSt.pop();
        min = minSt.peek();

    }
    public int top(){
        return st.peek();

    }

    public int getMin(){
        if(st.isEmpty()){
            System.out.println("Stack Empty");
            return -1;
        }
        return min;

    }



public static void main(String[]args){
    MinStack ob = new MinStack();
    ob.push(10);  
    ob.push(7);   
    ob.push(14);  
    ob.push(5);    
    ob.pop();      
    ob.push(6);   
    ob.pop();      
    ob.pop();     
    ob.pop();  

    System.out.println("Min Elem in the stack is: "+ob.getMin());

}
}




