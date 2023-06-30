// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class MyHashSet {
    int buckets;
    int bucketItems;
    boolean[][] storage;
    public MyHashSet() {
        this.buckets=1000;
        this.bucketItems=1000;
        this.storage=new boolean[buckets][];
    }
    private int hash1(int key){
        return key%1000;
    }
    private int hash2(int key){
        return key/1000;
    }
    public void add(int key) {
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        if(storage[bucket]==null){
            if(bucket==0){
                storage[bucket]=new boolean[bucketItems+1];
            }
            else{
                storage[bucket]=new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem]=true;
    }
    
    public void remove(int key) {
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        if(storage[bucket]==null)return;
        storage[bucket][bucketItem]=false;
    }
    
    public boolean contains(int key) {
        int bucket=hash1(key);
        int bucketItem=hash2(key);
        if(storage[bucket]==null)
            return false;
        return storage[bucket][bucketItem];
    }
}

class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// Your code here along with comments explaining your approach
