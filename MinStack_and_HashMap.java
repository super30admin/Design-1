
class MinStack {
    
    private Stack<Integer> stack;
    private int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        if(val <= min)
        {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop() == min)
            min = stack.pop();
    }
    
    public int top() {
        return stack.peek();
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

class MyHashMap {
    class Node {
        int key;
        int val;
        Node next;
        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    private Node[] nodes;
    private int buckets;

    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }
    
    private int hash(int key) {
        return key%buckets;
    }
    
    public Node find(Node head, int key) {
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if(nodes[index] == null) {
            nodes[index] = new Node(-1, -1);
        }
        Node prev = find(nodes[index], key);
        if(prev.next == null)
            prev.next = new Node(key, value);
        else 
            prev.next.val = value;
    }
    
    public int get(int key) {
        int index = hash(key);
        if(nodes[index] == null) return -1;
        Node prev = find(nodes[index], key);
        if(prev.next == null) return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
        int index = hash(key);
        if(nodes[index] == null) return;
        Node prev = find(nodes[index], key);
        if(prev.next == null) return;
        prev.next = prev.next.next;  
    }
}