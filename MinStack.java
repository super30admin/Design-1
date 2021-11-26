// Time Complexity :O(1)
// Space Complexity : O(n)
//Executed successfully on Leetcode - 155

class MinStack {
    Stack<Integer> original;

    int min;
    public MinStack() {
        min=Integer.MAX_VALUE;
        original=new Stack<Integer>();

    }

    public void push(int val) {

        if(val<=min){
        original.push(min);
        min=val;

        }
         original.push(val);

    }

    public void pop() {
        int popped=original.pop();
        if(min==popped)
        min=original.pop();


    }

    public int top() {
     return original.peek();
    }

    public int getMin() {
        return min;

    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */