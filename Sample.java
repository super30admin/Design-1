// Your code here along with comments explaining your approach

//****dESIGN HASHMAP USING DOUBLE HASHING****
//Time complexity:o(1);
//space complexity:o(1);
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


class MyHashMap {
    
    private boolean [][] storage;
    int buckets;
    int bucketlists;

    public MyHashMap() {
        buckets=1000;
        bucketlists=1000;
      //Not inititalizing the secondary array here itself to save the space;
        storage=new boolean[buckets][];
        
    }
    //Hashfunction for primary array
    public int bucket(int key) {
        return key%buckets;
        }
    //Hashfunction for secondary array
    public int bucketlist(int key) {
        return key/bucketlists;    
    }
    
    public void add(int key){
        int bucket=bucket(key);
        int bucketlist=bucketlist(key);
        //check if whether there is a reference of secondary array to the current bucket;
        if(storage[bucket]==null){
            //edge case of last element so for 0th index of bucket creating a secondary array of +1 size;
            if(bucket==0)
            {
                storage[bucket]=new boolean [bucketlists+1];
            }
            else{
                storage[bucket]=new boolean [bucketlists];
            }
        }
        storage[bucket][bucketlist]=true;
        
    }
    public void remove(int key) {
        int bucket=bucket(key);
        int bucketlist=bucketlist(key);
        if(storage[bucket]==null) return;
        storage[bucket][bucketlist]=false;
        
        
    }
    
    public boolean contains(int key) {
        int bucket=bucket(key);
        int bucketlist=bucketlist(key);
      //if already the bucketlist is not initialized it is for sure that item doesnt exists.
        if(storage[bucket]==null)  return false;
        return storage[bucket][bucketlist];
        
        
        
    }
}


//****HASHMAP USING LINEAR CHAINING****
//Time complexity:o(1);
//space complexity:o(1);
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO
class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        
        public Node(int key, int val)
        {
            this.key=key;
            this.val=val;
        }
    }
    Node [] nodes;

    public MyHashMap() {
        nodes=new Node[10000];
        
    }
    
    public int idx(int key)
    {
        return key%10000;
    }
    
    private Node find(Node head, int key)
    {
        Node prev=null;
        Node curr=head;
        
        while(curr!=null && curr.key!=key)
        {
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        int idx=idx(key);
        if(nodes[idx]==null)
        {
            nodes[idx]= new Node(-1,-1);
        }
        //If already exists in out list;
        Node prev=find(nodes[idx], key);
        if(prev.next==null)
        {
            prev.next = new Node(key, value);
        }
        else
        {
            prev.next.val=value;
        }
        
    }
    
    public int get(int key) {
        
        int idx=idx(key);
        if(nodes[idx]==null) return -1;
        
        Node prev= find(nodes[idx], key);
        if(prev.next==null)
        {
            return -1;
        }
            return prev.next.val;
        
        
        
    }
    
    public void remove(int key) {
         int idx=idx(key);
        if(nodes[idx]==null) return;
         Node prev= find(nodes[idx], key);
        if(prev.next==null) return;
        prev.next=prev.next.next;
        
    }
        
        
    }

//****DESIGN A MINSTACK****
//Time Complexity:o(1);
//Space Complexity:o(n);
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO
class MinStack {
    Stack<Integer> stack;
    int min;

    public MinStack() {
        min=Integer.MAX_VALUE;
        stack =new Stack<>();
        
    }
    
    public void push(int val) {
        if(val<=min)
        {
            stack.push(min);
            min=val;
        }
        stack.push(val);
        
    }
    
    public void pop() {
        if(min==stack.pop())
        {
            min=stack.pop();
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
        
    }
}
