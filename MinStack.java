// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    ArrayList<Integer> list = new ArrayList<>();
    public MinStack() {
        pq = new PriorityQueue<>();
        list = new ArrayList<>();
    }

    public void push(int val) {
        pq.offer(val);
        list.add(val);
    }

    public void pop() {
        int ele = list.get(list.size()-1);
        list.remove(list.size()-1);
        pq.remove(ele);
    }

    public int top() {
        int ele = list.get(list.size()-1);
        return ele;
    }

    public int getMin() {
        return pq.peek();
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