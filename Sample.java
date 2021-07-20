import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MinStack{
    int Size = 10;     // declaring the size of stack 
    Stack<Integer> st1 = new Stack<>();  // declaring stack 1 a
    Stack<Integer> min = new Stack<>();   // declaring stack 2 (which keeps adding only the min value on the peek)
    public MinStack(){
        int top = 0;         // top which keeps count of the number of elements in stack 
    }

    /* here we check if the stack size is not exceeded and if the size is not exceeded we push to st1
     and then check if the min stack peek element is less than the element we are adding now. if the min 
     stack peek element is lesser than val we ignore else we add the val*/

    public void push(int val) { 
        if (top != size){
        st1.push(val);
        top++;
        if (min.peek() > val || min.isEmpty() ){
            min.push(val);
        }
    }
    else{
        System.out.print("Stack overflow");
    }
    }

    /*
    check if top is not zero and then check if both peek elements are equal and pop from both else pop from the st stack
    */
    public int pop(){
    if (top !=0){
        if(st1.peek().equals(min.peek())){
            min.pop();
        }
        return st1.pop();
    }
    else{
        return 0;
    }

    }
    // As we add the min value to min stack we can say that the peek element of min stack is always the min element of all the elements
    // so we can just return the peek of the min stack
    public int getMin(){
        return min.peek();

    }

    public Boolean isEmpty(){
        return st1.isEmpty();

    }
    //check if the top is equal to the size 
    public Boolean isFull(){
        return (top==size);

    }
}
