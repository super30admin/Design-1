
//Problem-1
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
/* I didn't have much previous knowledge about the hashSet
 But after going through lecture I was able to do*/


// Your code here along with comments explaining your approach
/* Using the double hashing approach. Here we are building our own double hashMap.
We take the 2d array sizes depending on the data amount.Optimally we take sqrt(n)
for each and hashfunctions depending on the data to divide data equally and try to avoid collisions as much as possible.
For adding we calculate the index using the hashfuntions and go to that location and set it to true. In the same way
remove and contains we will do the required operations.
*/

class MyHashSet {
    private boolean [][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets=1000;
        bucketItems=1000;
        storage = new boolean[buckets][];

    }
    private int bucket(int key){
        return key%buckets;
    }
    private int bucketItem(int key){
        return key/bucketItems;
    }
    public void add(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null){
            if(bucket==0){
                storage[bucket]= new boolean[bucketItems+1];
            }
            else{
                storage[bucket]= new boolean[bucketItems];
            }
        }
        storage[bucket][bucketItem]= true;
    }

    public void remove(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null) return;
        storage[bucket][bucketItem]=false;

    }

    public boolean contains(int key) {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null) return false;
        return storage[bucket][bucketItem];

    }
}

//Problem-2
// Time Complexity :O(1)
// Space Complexity :O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
/* NO*/


// Your code here along with comments explaining your approach
/*
Here the basic idea is to maintain two stacks one for the mainStack and other
for the minStack. In minStack we store the min for that specific element in the
mainStack. SO that we can get minimum in constant time
*/

class MinStack {
    private  Stack<Integer> stack ;
    private Stack<Integer> minStack ;
    int min;


    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min=Integer.MAX_VALUE;
        minStack.push(min);

    }

    public void push(int val) {
        min=Math.min(min,val);
        stack.push(val);
        minStack.push(min);

    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min=minStack.peek();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}