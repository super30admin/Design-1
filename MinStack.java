/*
 * Create two stacks, stack for pushing all values and minstack fro pushing values which are lesser than prev value
 * this will be checked by min, whatever value is in min variable, it will be in minStack as well.
 * Time Complexity: O(1) for push, pop, top and
 * Space Complexity: O(2n) for stack and minStack
 * Author: Shubhangi
 */
import java.util.Stack;

public class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public static void main(String args[]){
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        obj.getMin(); // return -3
        obj.pop();
        obj.top();    // return 0
        obj.getMin(); // return -2
    }

    public MinStack(){
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        //push min value in minStack initially which is infinity
        minSt.push(min);
    }

    public void push(int val) {
        //update min
        min = Math.min(val,min);
        st.push(val);
        minSt.push(min);
    }

    public void pop(){
        st.pop();
        minSt.pop();
        min = minSt.peek();
    }

    public int top(){
        System.out.println("Get Top " + st.peek());
       return st.peek();
   }

   public int getMin(){
       System.out.println("Get Min " + minSt.peek());
       return min;
   }

}
