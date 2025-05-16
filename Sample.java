// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {

    private boolean[][] storage;
    int buckets;
    int buckets2;
    private int hash1(int key){
        return key % 1000;
    }
    private int hash2(int key){
        return key/1000;
    }

    public MyHashSet() {
        this.buckets = 1000;
        this.buckets2 = 1000;
        this.storage = new boolean [buckets][];


    }

    public void add(int key) {
        int index = hash1(key);
        int index2 = hash2(key);
        if(storage[index] == null){
            if(index == 0){
                storage[index] = new boolean[buckets2+1];
            }
            else{
                storage[index] = new boolean[buckets2];
            }
        }

        storage[index][index2] = true;

    }



    public void remove(int key) {
        int index = hash1(key);
        int index2 = hash2(key);
        if(storage[index] == null)return;
        storage[index][index2] = false;
    }

    public boolean contains(int key) {
        int index = hash1(key);
        int index2 = hash2(key);
        if (storage[index]== null) return false;
        return storage[index][index2];
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


class MinStack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if(minStack.isEmpty() || val<= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        int rem = mainStack.pop();
        if (rem == minStack.peek()){
            minStack.pop();
        }

    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
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