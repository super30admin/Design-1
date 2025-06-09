//PROBLEM -1

// Time Complexity : O(1) for add, remove and contains
// Space Complexity : 0(1) for add, remove and contains
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.Stack;

class MyHashSet {
    //Intuition is to create a 2d array of boolean type to check if the data is present or not
    boolean[][] storage;

    public MyHashSet() {
        //intialized the 1d of size sq.rt(1000000) as a stating point
        storage=new boolean[1000][];
    }

    public void add(int key) {
        //added double hasing to avoid collisions and initialize the inner array with 1000 to
        // accomodate the range 1000000
        int bucket=key%1000;
        int bucketValue=key/1000;

        if(storage[bucket]==null){
            if(bucket==0){
                //edge case to accomodate 1000
                storage[bucket]=new boolean[1000+1];
                System.out.print("added");
            }else{
                storage[bucket]=new boolean[1000];
            }
        }
        storage[bucket][bucketValue]=true;
    }

    public void remove(int key) {
        //Double hash and remove the data if present else do nothing
        int bucket=key%1000;
        int bucketValue=key/1000;
        if(storage[bucket]==null){
            return;
        }
        storage[bucket][bucketValue]=false;
    }

    public boolean contains(int key) {
        //double hash and return false if null else return the value
        int bucket=key%1000;
        int bucketValue=key/1000;
        if(storage[bucket]==null){
            return false;
        }
        return storage[bucket][bucketValue];
    }
}

//Separate chaining
//TC:0(n)
//SC:0(n)
class MyHashSet {
    Node[] storage;
    int bucket;

    private class Node{
        int key;
        Node next;
        public Node(int key){
            this.key=key;
        }
    }

    private Node find(Node dummy,int key){
        Node prev=dummy;
        Node curr=dummy.next;
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }

    private int getBucket(int key){
        return key%bucket;
    }

    public MyHashSet() {
        this.bucket=1000;
        storage=new Node[this.bucket];
    }

    public void add(int key) {
        int bucketValue=getBucket(key);
        if(storage[bucketValue]==null){
            storage[bucketValue]=new Node(-1);
        }
        Node prev=find(storage[bucketValue],key);
        if(prev.next==null){
            Node newNode=new Node(key);
            prev.next=newNode;
        }
    }

    public void remove(int key) {
        int bucketValue=getBucket(key);
        if(storage[bucketValue]!=null){
            Node prev=find(storage[bucketValue],key);
            if(prev.next!=null){
                prev.next=prev.next.next;
            }
        }
    }

    public boolean contains(int key) {
        int bucketValue=getBucket(key);
        if(storage[bucketValue]!=null){
            Node prev=find(storage[bucketValue],key);
            if(prev.next!=null){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

// PROBLEM - 2

// Time Complexity : 0(1) for all operations
// Space Complexity : 0(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MinStack {
    int min;
    Stack<Integer> main_stack;
    //intution is to have a variable to store min and have the prev min
    //stored whenever there is an update to min(double push) and while popping
    //check the popped element and do double popping if the popped element matches
    public MinStack() {
        main_stack=new Stack<>();
        min=Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val<=min){
            main_stack.push(min);
            min=val;
        }
        main_stack.push(val);
    }

    public void pop() {
        int popped=main_stack.pop();
        if(popped==min){
            min=main_stack.pop();
        }
    }

    public int top() {
        return main_stack.peek();
    }

    public int getMin() {
        return min;
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

