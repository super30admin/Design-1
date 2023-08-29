import java.util.Stack;



//MinStack Implementation using single stack
//Time complexity is O(1)
//Space complexity will be O(n) but not all the time by using less memory and not pushing min value every time.
public class MinStackSingle {

    Stack<Integer> s;
    int min;


    public MinStackSingle(){
        s= new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val){
    if (val<=min){
        s.push(min);
        min=val;
    }
    s.push(val);
    }

    public void pop(){
        if (min==s.pop()){
            min=s.pop();
        }
    }

    public int top(){
        return s.peek();

    }
    public int getMin(){
        return min;
    }


    public static void main(String[] args){
        MinStackSingle ms= new MinStackSingle();
        ms.push(3);
        ms.push(5);
        ms.push(2);
        ms.push(7);

        System.out.println("Top element: " + ms.top());
        System.out.println("Minimum element: " + ms.getMin());

        ms.pop();
        System.out.println("Top element after pop: " + ms.top());
        System.out.println("Minimum element after pop: " + ms.getMin());
    }
}
