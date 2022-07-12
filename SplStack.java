package Day1;

import java.util.Stack;

public class SplStack {

    Stack<Integer> myStack = new Stack<>();

    public void push(int x){
        System.out.println("Pushing: "+x);
        myStack.push(x);
    }

    public void pop(){
        if(myStack.peek()!=-1)
            myStack.pop();
    }

    public void isEmpty(){
        if(myStack.empty()){
            System.out.println("Stack is empty");
        }
        else{
            System.out.println("Stack is not empty");
        }
    }

    public int getMin(){
        int min = Integer.MAX_VALUE;

        Stack<Integer> temp = new Stack<>();

        if(!myStack.empty()){
            int x = myStack.pop();
            temp.push(x);

            if(x < min){
                min = x;
            }
        }
        return min;
    }

    public static void main(String args[]){
        SplStack obj = new SplStack();

        obj.isEmpty();

        obj.push(-2);
        obj.push(0);
        obj.push(-1);
        obj.push(2);
        obj.push(10);
        obj.push(-100);


        System.out.println("Finding the minimum element in the stack " +obj.getMin());

        System.out.println("Popping the top element");
        obj.pop();

        System.out.println("Finding the minimum element in the stack "+obj.getMin());

    }

}
