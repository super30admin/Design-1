// Time Complexity :O(1)
// Space Complexity : O(n^2) - 2d array for storing values
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[][] storage; //storage for items, can be decided according to hashfunctions
    int buckets; // number of buckets, basically column
    int bucketitems; // number of items in a bucket, basically row
    public MyHashSet() {
        this.buckets=1000;
        this.bucketitems=1000;
        this.storage=new boolean[buckets][];
    }
    //2 custom hashfunctions.
    private int hash1(int key){
        return key%1000;
    }

    private int hash2(int key){
        return key/1000;
    }

    public void add(int key) {
        int bucket=hash1(key); //getting bucket from first hash
        int bucketitem=hash2(key); //getting item from second hash
        if(storage[bucket]==null){ // checking if there is no item assigned to the bucket
            if(bucket == 0) //if no array is assigned, assign a new array to value bucketItems+1
                storage[bucket]=new boolean[bucketitems+1];
            else
                storage[bucket]=new boolean[bucketitems];
        }
        storage[bucket][bucketitem]=true; //set element loction as true, 
    }
    
    public void remove(int key) {
        int bucket=hash1(key);
        int bucketitem=hash2(key);
        if(storage[bucket]==null) return; //if no element at bucket, return
        storage[bucket][bucketitem]=false; // false indicates no element, basically removal.
    }
    
    public boolean contains(int key) {
        int bucket=hash1(key);
        int bucketitem=hash2(key);
        if(storage[bucket]==null) return false;
        return storage[bucket][bucketitem]; // just return the boolean value
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

//Problem 2: MinStack
// Time Complexity :O(1)
// Space Complexity : O(n) - stack for storing values
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//basically we are maintaining minvalue for every single push operation and popping associated min value in pop operation
class MinStack {
    Stack<Integer> in;
    int minEle;
    public MinStack() {
        this.in= new Stack<>();
        //this.min= new Stack<>();
        this.minEle=Integer.MAX_VALUE;
        this.in.push(minEle); //pushing initial minValue
    }
    
    public void push(int val) {
        if(minEle>=val){ //if current value is less, assign to min and push minEle again.
            in.push(minEle);
            minEle=val;
        }
        in.push(val); 
    }
    
    public void pop() {
        if(in.pop()==minEle) //if popped value is current MinElement, pop the next value and assign to MinElement
            minEle=in.pop();
    }
    
    public int top() {
       return in.peek();
    }
    
    public int getMin() {
        return minEle;
    }
}
