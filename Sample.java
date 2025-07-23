// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Idea is to create a single linked list of custom nodes. This custom node will have 2 properties.
//One property refers to value and the other refers to min value it holds till all the nodes present before it
//While Pushing a value  , we  create this node according to min value found
class MinStack {

   StackNode headnode;
    // Time Complexity :  O(1)
    // Space Complexity : O(n)
    public MinStack() {
     headnode = new StackNode(-1, Integer.MAX_VALUE);
    }
    
    // Time Complexity :  O(1)
    // Space Complexity : O(1)
    // Calculate Min for the current node, before creating.
    public void push(int val) {
        StackNode temp;
        if(val<headnode.minhead)
        {
           temp = new StackNode(val,val);
        }
        else
        {
          temp = new StackNode(val,headnode.minhead);
        }
           temp.next = headnode;
           headnode = temp;
    }
    
    // Time Complexity :  O(1)
    // Space Complexity : O(1)
    public void pop() {
        StackNode temp = headnode.next;
        headnode.next = null;
        headnode = temp;
    }
    
    // Time Complexity :  O(1)
    // Space Complexity : O(1)
    public int top() {
        return headnode.val;
    }
    
    // Time Complexity :  O(1)
    // Space Complexity : O(1)
    public int getMin() {
        return headnode.minhead;
    }
}

class StackNode{
    //MinStack is made of special node. This Node has value and min value.
    //Min value represents minimum value found till the node inserted.
    int val;
    int minhead;
    StackNode next;
    StackNode(int val,int minhead){
        this.val = val;
        this.minhead = minhead;
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


 //Idea is to use List of LinkedLists as HashSet.These individual LinkedLists act as buckets.
 //The number of buckets are chosen to avoid collisions.
 //We use hashfunction to categorize the incoming key into respective bucket.
class MyHashSet {
    private int size = 10000;
    private List<LinkedList<Integer>> buckets; 

    public MyHashSet() {
        buckets = new ArrayList<>(size); 
        for (int i = 0; i < size; i++) {
            buckets.add(new LinkedList<>()); // Adding empty LinkedList to each bucket
        }
    }


    //TimeComplexity: average-O(1)
    //SpaceComplexity: average-O(1)
    public void add(int key) {
        int bucketIndex = key % size;
        LinkedList<Integer> bucket = buckets.get(bucketIndex);
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }
    //TimeComplexity: average-O(1)
    //SpaceComplexity: average-O(1)
    public void remove(int key) {
        int bucketIndex = key % size;
        LinkedList<Integer> bucket = buckets.get(bucketIndex);
         if (bucket.contains(key)) {
        bucket.remove((Integer) key); 
         }
    }
    //TimeComplexity: average-O(1)
    //SpaceComplexity: average-O(1)
    public boolean contains(int key) {
        int bucketIndex = key % size;
        LinkedList<Integer> bucket = buckets.get(bucketIndex);
        return bucket.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */