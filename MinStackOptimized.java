import java.util.EmptyStackException;
import java.util.Stack;

public class MinStackOptimized {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min;

    public MinStackOptimized(){
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public int pop(){
        int val = stack.pop();
        if(min == val){
            minStack.pop();
            min = minStack.peek();
        }
        return val;
    }

    public int peek(){
        return stack.peek();
    }

    public void push(int val){
        stack.push(val);
        if(min >= val){
            min = val;
            minStack.push(min);
        }
    }


    public int getMin(){
        return min;
    }

    public static void main(String []args) {
        MinStackOptimized stack = new MinStackOptimized();
        try{
            System.out.println(stack.peek());//Expected Exception
        }catch(EmptyStackException ex){
            System.out.println("Stack Underflow");
        }
        try{
            System.out.println(stack.getMin());//Expected Exception
        }catch(EmptyStackException ex){
            System.out.println("Stack Underflow");
        }

        stack.push(10);
        System.out.println(stack.peek());//10
        System.out.println(stack.getMin());//10

        stack.push(22);
        System.out.println(stack.peek());//22
        System.out.println(stack.getMin());//10

        stack.push(7);
        System.out.println(stack.peek());//7
        System.out.println(stack.getMin());//7
        stack.push(15);
        System.out.println(stack.peek());//15
        System.out.println(stack.getMin());//7

        System.out.println(stack.pop());//15
        System.out.println(stack.peek());//7
        System.out.println(stack.getMin());//7
        System.out.println(stack.pop());//7
        System.out.println(stack.peek());//22
        System.out.println(stack.getMin());//10

    }
}