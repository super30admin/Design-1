// Time Complexity : O(1) for all operations
// Space Complexity : O(n) for storing elements in the hash table
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
import java.util.LinkedList;
import java.util.Stack;

class MyHashSet { // API --> add, remove, contains
    Bucket[] bucketArr;
    int S = 769;

    public MyHashSet() { // HashTable consists of an array of linked lists
        bucketArr = new Bucket[S];
        for (int i = 0; i < S; ++i)
            bucketArr[i] = new Bucket();
    }

    private int _hash(int key) { // returns hash_code
        return key % S;
    }

    public void add(int key) {
        int index = this._hash(key);
        bucketArr[index].insert(key);
    }

    public void remove(int key) {
        int index = this._hash(key);
        bucketArr[index].delete(key);
    }

    public boolean contains(int key) {
        int index = this._hash(key);
        return bucketArr[index].exists(key);
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();

        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println("Contains 1? " + myHashSet.contains(1)); // true
        System.out.println("Contains 3? " + myHashSet.contains(3)); // false
        myHashSet.add(2);
        System.out.println("Contains 2? " + myHashSet.contains(2)); // true
        myHashSet.remove(2);
        System.out.println("Contains 2 after removal? " + myHashSet.contains(2)); // false
    }
}

class Bucket { // API --> insert, delete, exists
    public LinkedList<Integer> container;

    public Bucket() {
        container = new LinkedList<>();
    }

    public void insert(Integer key) {
        if (!container.contains(key)) {
            container.add(key);
        }
    }

    public void delete(Integer key) {
        container.remove(key);
    }

    public boolean exists(Integer key) {
        return container.contains(key);
    }
}

// Time Complexity : O(1) for all operations
// Space Complexity : O(n) for storing elements in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        // If minStack is empty, push x as the first minimum
        int min = minStack.isEmpty() ? x : Math.min(minStack.peek(), x);
        minStack.push(min);
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("Minimum element in the stack: " + minStack.getMin()); // Output should be -3

        minStack.pop();

        System.out.println("Top element in the stack: " + minStack.top()); // Output should be 0

        System.out.println("Minimum element in the stack: " + minStack.getMin()); // Output should be -2
    }
}
