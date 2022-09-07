import java.util.PriorityQueue;

// constant time complexity
// priority queue operations can be of logarithmic time complexity but its constant on an average for large values of number of elements

public class MinStack {

    int top;
    int[] stack;
    PriorityQueue<Integer> pq;

    //initializing an array for the stack and a priority queue for the minimum element
    public MinStack() {
        this.top=-1;
        stack = new int[30000];
        pq = new PriorityQueue<>();
    }

    //add the value in the stack at top and also into the priority queue
    public void push(int value){
        stack[++top] = value;
        pq.add(value);
    }
    
    // returns the top value from the stack without removing
    public int peek(){
        if(top!=-1){
            return stack[top];
        }
        else{
            return -999991;
        }
    }

    // returns the top value from the stack by removing it, and also removes it from the priority queue
    public int pop(){
        if(isEmpty()){
            System.out.println("Empty stack");
            return -999991;
        }
        pq.remove(this.peek());
        return stack[top--];
    }

    // empty stack when top is -1
    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        else{
            return false;
        }
    }

    // full stack when top is 29999
    public boolean isFull(){
        if(top < 30000){
            return false;
        }
        else{
            return true;
        }
    }

    // returns the value in the priority queue
    public int getMin(){
        if(pq.isEmpty()){
            return -999991;
        }
        return pq.peek();
    }

    public static void main(String[] args){
        MinStack mst = new MinStack();
        mst.push(10);
        mst.push(20);
        mst.push(6);
        System.out.println(mst.pop());
        mst.push(100);
        System.out.println(mst.getMin());
        System.out.println(mst.pop());
        mst.push(2);
        System.out.println(mst.getMin());
    }
}
