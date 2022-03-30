// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MinStack {
    int min;
    Stack<Integer> stack;
    public MinStack() {    // Initialising the minstack.
        stack = new Stack<>();
        min = Integer.MAX_VALUE; //Storing the maximum value of integer
    }
    
    public void push(int val) {
        if(val<=min){
            stack.push(min); //if the value we want to push is less than the current minimum, then we will push the current minimum and then we will update the minimum to the new value and then we will push the new value. Else, we will simply push the element.
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.peek()== min){  //if the value we want to pop is equal to the current minimum, then we will pop the element and then we will check the topmost element of the stack and put that value in minimum. And then we will pop that old minimum as well. while in other cases, we will simply pop the element.
            stack.pop();
            min = stack.peek();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek(); //returning the topmost element of the stack.
    }
    
    public int getMin() {
        return min;		//returning the value of current minimu element in the stack which is stored in min variable
    }
}

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

class MyHashSet {
    int buckets;
    int bucketItems;
    boolean [][] storage;
    public MyHashSet() {
        buckets = 1000;			//since there are elements from 0-10^6 we will make a 2d matrix of 1000*1000.
        bucketItems = 1000;
        storage = new boolean[buckets][];	//Intialising the 2D array with primary array having the length 1000 with null stored in them.
    }
    private int getBucket(int key){
        return key%buckets;			//finding the index of primary array
    }
    private int getBucketItem(int key){
        return key/bucketItems;			//finding the index of secondary array
    }
    
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);		
        if(storage[bucket]==null){		//initialising the secondary if the secondary array at a particular index has not been initialised.
            if(bucket==0){
                storage[bucket] = new boolean[bucketItems+1];	//putting bucketItems+1 to take into account the case of 10^6 where 10^6/1000 = 1000 which is more than 999.
            }
            else{
            storage[bucket] = new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem]=true;	//putting true at an index in 2d array to mark that it is present.
    }
    
    public void remove(int key) {		
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null){		//if primary array has null value at that index that means secondary array has not been initialised anf hence we will return without putting false;
            return;
        }
            storage[bucket][bucketItem]=false;	//putting false at a particular index.
    }
    
    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);		
        if(storage[bucket]==null)		//if primary array has null value at that index that means secondary array has not been initialised anf hence we will return false;
            return false;
        return storage[bucket][bucketItem];	//else we will return the value at that index.
    }
}

