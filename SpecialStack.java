/*
Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. All these operations of SpecialStack must be O(1). To implement SpecialStack, you should only use standard Stack data structure and no other data structure like arrays, list, .. etc.
*/

import java.util.Stack;

class SpecialStack{

    int maxSize = 100;
    Stack<Integer> s ;
    Stack<Integer> auxilaryStack; //This can be used to get the special funcion getMin(). we can same for getMax();

    public SpecialStack(){
        s = new Stack<Integer>();
        auxilaryStack = new Stack<Integer>();
    }

    public void push(){

        if(isEmpty() == true)
        {
            s.push(x);
            auxilaryStack.push(x);
        }
        else
        {
            s.push(x);
            int y = auxilaryStack.pop();
            auxilaryStack.push(y);
            if(x < y)
                auxilaryStack.push(x);
            else
                auxilaryStack.push(y);
        }

    }

    public void pop(){
        int x = s.pop();
        auxilaryStack.pop();
        return x;

    }

    public boolean isEmpty(){
        return s.empty();
    }

    public boolean isFull(){
        return s.size() == MAX - 1;
    }

    public void getMin(){
         int x = s.pop();
        auxilaryStack.push(x);
        return x;
    }

}

public class MySpecialStack{

    public static void main(Strings[] args){
        SpecialStack stk = new SpecialStack();

        stk.push(10);
        stk.push(20);
        stk.push(30);
        System.out.println(stk.getMin());
        stk.push(5);
        System.out.println(stk.getMin());
    }
}
