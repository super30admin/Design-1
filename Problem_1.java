//Time Complexity :O(n)
//Space Complexity :O(n)
//Did this code successfully run on Leetcode : No
//Any problem you faced while coding this : Yes


//Your code here along with comments explaining your approach

class MyHashSet {
    private Node[] hset;
    public static final int SIZE = 10000;
    public MyHashSet() {
        hset = new Node[SIZE];
    }
    
    public int hashFunc(int key){
        return key%1000;
    }
    public void add(int key) {
        int k = hashFunc(key);
        Node n = hset[k];
        if (n == null){
            hset[k] = new Node(key);
        }
        else{
            if(!contains(key)){
                while(n.next != null){
                    n = n.next;
                }
                Node n1 = new Node(key);
                n.next = n1;
            }
        }
    }
    
    public void remove(int key) {
        int k = hashFunc(key);
        Node n = hset[k];
        Node prev = hset[k];
        if(n != null){
            if(contains(key)){
                if (n.next == null){
                    hset[k] = null;
                }
                else{
                    while(n.value != key){
                        prev = n;
                        n = n.next;
                    }
                    prev.next = n.next;
                }
            }
        }
    }
    
    public boolean contains(int key) {
        int k = hashFunc(key);
        Node n = hset[k];
        boolean contain = false;
        if(n != null){
           while((n != null) && (contain == false)){
               if (n.value == key){
                   contain = true;
               }
               else{
                   n = n.next;
               }
           }
        }
        return contain;
    }
}

class Node {
    public int value;
    public Node next;
    public Node(int v){
        this.value = v;
        this.next = null;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */