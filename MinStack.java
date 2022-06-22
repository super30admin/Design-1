/*
Time Complexity : O(1) since everything is done without traversing.
Space Complexity : Twice * O(n) since we create save value and minimum

Did this code successfully run on Leetcode :
Finished in 62 ms
Stack Underflow
Stack Underflow
10
10
22
10
7
7
15
7
15
7
7
7
22
10

Any problem you faced while coding this :
None

Your code here along with comments explaining your approach :
Approach is to save value and current minimum value till that stack level at every push.

The comments after sysouts were expected output and they matched.
*/
import java.util.EmptyStackException;
import java.util.Stack;

class Pair<A, B>{
    private A minValue;
    private B value;
    Pair(A minValue, B value){
        this.minValue = minValue;
        this.value = value;
    }

    boolean hasKey(A minValue){
        return this.minValue.equals(minValue);
    }

    A getMinValue(){
        return minValue;
    }

    B getValue(){
        return value;
    }
}

public class MinStack {
    private Stack<Pair<Integer, Integer>> stack;

    MinStack(){
        this.stack = new Stack<>();
    }

    public void push(int val){
        if(stack.isEmpty()){
            stack.push(new Pair(val, val));
        } else {
            int minVal = stack.peek().getMinValue();
            if(minVal < val){
                stack.push(new Pair(minVal, val));
            } else {
                stack.push(new Pair(val, val));
            }
        }
    }

    public int peek(){
        return this.stack.peek().getValue();
    }


    public int pop(){
        return this.stack.pop().getValue();
    }

    public int getMin(){
        return this.stack.peek().getMinValue();
    }

    public static void main(String []args) {
        MinStack stack = new MinStack();
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
