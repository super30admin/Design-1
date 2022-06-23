//Microsoft Interview question
//Time complexity =O(1)
//Space complexity =O(1)
class MyQueue {
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>(); 
    }
    //Time complexity =O(1)
    public void push(int x) {
        in.push(x);
    }
    //Time complexity =O(n)
    public int pop() {
        peek();
        return out.pop();
    }
    //Time complexity =O(1)
    public int peek() {
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }   
        return out.peek();
    }
    //Time complexity =O(1)
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */