import java.util.Stack;

class MinStack {
    Stack<Pair> s1;


    public MinStack() {
        s1=new Stack();

    }
    public class Pair{
        int key;
        int val;
        Pair(int key,int val){
            this.key=key;
            this.val=val;
        }
    }

    public void push(int x) {
        int min;
        if (s1.isEmpty()) {
            min = x;
        } else {
            min = Math.min(s1.peek().val, x);
        }
        s1.push(new Pair(x, min));
    }

    public void pop() {
        s1.pop();
    }

    public int top() {
        return s1.peek().key;
    }
    public int getMin() {
        return  s1.peek().val;
    }
}
