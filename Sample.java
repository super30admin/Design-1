// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : time complexity


// Your code here along with comments explaining your approach
class MinStack {
    private int min;
    private Stack<Integer> stack;
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    public void push(int val) {
        if (val <= min){
                stack.push(min);
                min = val;
            }
        stack.push(val);
    }
    public void pop() {
        int val = stack.pop();
        if (val == min){
        min = stack.pop();
        }
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min;
    }
}
problem 2 
class MyHashSet {
    boolean arr[] = new boolean[99999];
    public MyHashSet() {
    
    }
    public int hash(int key) {
        
        int hashfn=key%99999;
        return hashfn;
    }
    public void add(int key) {
        int i = hash(key);
        arr[i] = true;
    }
    
    public void remove(int key) {
        int i = hash(key);
        if (arr[i] == true){
            arr[i] = false;
        }
    }
    
    public boolean contains(int key) {
       int i = hash(key);
        if (arr[i] == true){
            return true;
        }else{
            return false;
        }
    }
}
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : time complexity
