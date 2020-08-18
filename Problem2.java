import java.util.*;
class MinStack{

    public Stack<Integer> stk = new Stack<>();
    public Stack<Integer> minStk = new Stack<>();

    public MinStack(){

    }

    public void push(int x){
        if (minStk.isEmpty() || x <= minStk.peek()){
            minStk.push(x);
        }
        stk.push(x);
    }

    public void pop(){
        if (minStk.peek().equals(stk.peek())){
            minStk.pop();
        }
        stk.pop();
    }

    public int top(){
        return stk.peek();
    }

    public int getMin(){
        return minStk.peek();
    }

    public static void main(String[] args){
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }


}