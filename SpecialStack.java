import java.util.Stack;

public class SpecialStack {
    private int length;
    private int maxlength;
    Stack<Integer> stack ;
    Stack<Integer> dupe ;


    public SpecialStack(){
        stack = new Stack<Integer>();
        dupe = new Stack<Integer>();
        this.length = 0;
        this.maxlength = 1000;
    }

    boolean isEmpty(){
        if(length<1)
            return true;
        else
            return false;
    }


    boolean isFull(){
        if(length>maxlength)
            return true;
        else
            return false;
    }

    void push(int data){
        //stack.push(data);
        if(stack.isEmpty()){
            stack.push(data);
            dupe.push(data);
        }
        else{
            int temp = dupe.peek();
            stack.push(data);
            if(temp<data)
                dupe.push(temp);
            else
                dupe.push(data);
        }

        length++;
    }

    int pop() {
        if (this.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            dupe.pop();
            return stack.pop();
        }
    }

    public int getMin() {
        if(stack.isEmpty()){
            System.out.println("Stack Underflow");
            return -1;
        }
        else{
            return dupe.peek();
        }

    }
    public static void main(String[] args) {
        SpecialStack ss = new SpecialStack();
        int min;
        ss.pop();
        ss.getMin();
        ss.push(2);
        ss.push(3);
        min = ss.getMin();
        ss.push(1);
        min = ss.getMin();
        ss.pop();
        min = ss.getMin();
        ss.push(5);
        ss.push(4);
        min = ss.getMin();
    }
}
