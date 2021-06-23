// Time Complexity : O(1)
// Space Complexity : (n)
// Did this code successfully run on Leetcode : Not for all testCases
// Any problem you faced while coding this :
Yes what to return if the stack is empty


// Your code here along with comments explaining your approach
class MinStack {
    Queue<Integer> q = new LinkedList<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        q.add(val);

        int size = q.size();
        while(size-->1){
            q.add(q.poll());
        }
    }

    public void pop() {
        q.poll();
    }

    public int top() {
        if(!q.isEmpty()){
            return q.peek();
        } return 0;

    }

    public int getMin() {
        if(!q.isEmpty()){
            int  min = q.poll();

            while(!q.isEmpty()){

                min = Math.min(min, q.poll());
            }
            return min;
        }
        return -2;
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