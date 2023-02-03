// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Yes


// Your code here along with comments explaining your approach
// Using a boolean 2 d array to store true and false. First array just stores the references of the boolean array. Using 2 hash functions to calculate the location in first array and then second array.
class MyHashSet {
    boolean[][] storage;
    int bucket;
    int bucketItems;
    
    public MyHashSet() {
        this.bucket = 1000; 
        this.bucketItems = 1000;
        this.storage = new boolean[bucket][];       
    }

    private int hash1(int key){
        return key%bucket;
    }

    private int hash2(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int arr1Loc= hash1(key);
        int arr2Loc = hash2(key);
        if(storage[arr1Loc]==null){
            if(arr1Loc==0){
                storage[arr1Loc] = new boolean[bucketItems+1];
            } else 
            {storage[arr1Loc] = new boolean[bucketItems];
            }
        }          
        storage[arr1Loc][arr2Loc] = true;

    }
    
    public void remove(int key) {
         int arr1Loc= hash1(key);
         int arr2Loc = hash2(key); 
        if(storage[arr1Loc]==null){
            return;
        } 
            storage[arr1Loc][arr2Loc] = false;
        }
    
    
    public boolean contains(int key) {
        int arr1Loc= hash1(key);
        int arr2Loc = hash2(key); 
        if(storage[arr1Loc]==null){
            return false;
        } 
         return storage[arr1Loc][arr2Loc] ;
    }
}

//Min Stack
// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Yes


// Your code here along with comments explaining your approach
// Using two stacks one to store min value so far and other to store all the values. Also using a variable just to capture the min value. Initially will push the min value in min stack as maximum int value so that stack is not empty.
class MinStack {

    private Stack<Integer> s1;
    private Stack<Integer> minStk;
    private int min;

    public MinStack() {
        s1 = new Stack<>();
        minStk = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minStk.push(min);

    }
    
    public void push(int val) {
        min = Math.min(min,val);
        minStk.push(min);
        s1.push(val);       
    }
    
    public void pop() {
        s1.pop();
        minStk.pop();
        min = minStk.peek();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int getMin() {
       return min;
          
    }
}

