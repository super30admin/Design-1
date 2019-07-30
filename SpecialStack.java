import java.util.Stack;

public class SpecialStack{
    private int count;
    private static int MAX = 100;
    private int min = Integer.MAX_VALUE;
    private Stack<Element> specialStack = new Stack<Element>();

    class Element{
        private int value;
        private int currMin;

        Element(int value, int currMin){
            this.value = value;
            this.currMin = min;
        }
    }
    
    public void push(int value){
        if(isFull()){
            System.out.println("Stack is overflow");
            return;
        }
        if(isEmpty()){
            min = Integer.MAX_VALUE;
        }
        min = Math.min(min,value);
        specialStack.push(new Element(value, min));
        count++;
    }
    public int pop(){
        if(isEmpty()){
            return 0;
        }
        Element element = specialStack.pop();
        min = specialStack.peek().currMin;
        count--;
        return element.value;
       
    }

    public boolean isEmpty(){
        if(count < 0){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(count >= MAX){
            return true;
        }
        return false;
    }

    public int getMin(){
        return min;
    }

    public static void main(String[] args){
        SpecialStack obj = new SpecialStack();
        obj.push(5);
        obj.push(-1);
        System.out.println("Current minimum " +obj.getMin());
        obj.push(4);
        System.out.println("Current minimum " +obj.getMin());
        System.out.println(obj.pop() + " Popped from the stack");
        System.out.println("Current minimum " +obj.getMin());
        System.out.println(obj.pop() + " Popped from the stack");
        System.out.println("Current minimum " +obj.getMin());
        
    }
} 