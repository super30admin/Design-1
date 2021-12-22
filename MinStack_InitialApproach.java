import java.util.Stack;

public class MinStack_InitialApproach {

    Stack<Integer> mStack;
    int firstMinElement, secondMinElement;

    public MinStack_InitialApproach() {
        mStack = new Stack<>();
        firstMinElement = Integer.MAX_VALUE - 1;
        secondMinElement = Integer.MAX_VALUE;
    }

    public void push(int val) {
        mStack.push(val);

        if( val <= firstMinElement){
            secondMinElement = firstMinElement;
            firstMinElement = val;
        }else if ( val < secondMinElement){
            secondMinElement = val;
        }
        System.out.println("-----------After push----------------"+ val);
        System.out.println("firstMinElement : "+ firstMinElement);
        System.out.println("secondMinElement : "+ secondMinElement);
        System.out.println("-----------------------------");
    }

    public void pop() {
        int poppedEle = mStack.pop();
        if(poppedEle == firstMinElement){
            firstMinElement = secondMinElement;
        }
        System.out.println("-----------After pop----------------" + poppedEle);
        System.out.println("firstMinElement : "+ firstMinElement);
        System.out.println("secondMinElement : "+ secondMinElement);
        System.out.println("-----------------------------");
    }

    public int top() {
        return mStack.peek();
    }

    public int getMin() {
        return firstMinElement;
    }

    public static void main(String[] args)
    {
        MinStack_InitialApproach minStack = new MinStack_InitialApproach();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        System.out.println("getMin : "+ minStack.getMin());
        minStack.pop();
        System.out.println("getMin : "+ minStack.getMin());
        minStack.pop();
        System.out.println("getMin : "+ minStack.getMin());

    }
}
