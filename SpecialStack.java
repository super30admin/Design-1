import java.util.*;
public class SpecialStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    SpecialStack(){
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public boolean isEmpty() 
    {         
        return stack.empty();
    }

    public void push(int x){

        stack.push(x);
        
        // to maintain a minStack
        Stack<Integer> tempStack = new Stack<Integer>();
        
        if(minStack.empty()){
            minStack.push(x);
            return;
        }
        if(minStack.peek() >= x){
            minStack.push(x);
        }
        else{
            while(!minStack.empty() && minStack.peek() < x ){
                tempStack.push(minStack.pop());                
            }

            minStack.push(x);

            while(!tempStack.empty()){
                int element = (int)tempStack.pop();
                minStack.push(element);
            }
        }       
    }

    public int pop(){
        return stack.pop();
    }

    public int peek(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }

    public static void main(String[] args){
        System.out.println("Special Stack");
        SpecialStack specialStack = new SpecialStack();
        specialStack.push(10);
        specialStack.push(9);
        specialStack.push(8);
        System.out.println(specialStack.peek());
        specialStack.push(20);
        specialStack.push(15);
        System.out.println(specialStack.getMin());
        specialStack.push(1);
        System.out.println(specialStack.getMin());

    }
}