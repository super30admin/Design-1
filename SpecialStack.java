import java.util.*;
public class SpecialStack {

    private Stack<Integer> stack;
    //private Stack<Integer> minStack;
    private int min;

    SpecialStack(){
        stack = new Stack<Integer>();
       // minStack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
        
    }

    public boolean isEmpty(){
        return true;
    }

    public void push(int x){
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);        
    }

    public void pop(){
        int popped = stack.pop();
        if(popped == min){
            min = stack.pop();
        }
    }

    public int peek(){
        return stack.peek();
    }

    public int getMin(){
        return min;
    }



    public static void main(String[] args){
        System.out.println("Special Stack implementation");
        SpecialStack specialStack = new SpecialStack();

        specialStack.push(0);
        specialStack.push(1);
        specialStack.push(0);

        System.out.println(specialStack.getMin());
        System.out.println(specialStack.stack);
        specialStack.pop();
        System.out.println(specialStack.stack);
        // System.out.println(specialStack.peek());

        //specialStack.push(2);
        System.out.println(specialStack.getMin());


    }
}