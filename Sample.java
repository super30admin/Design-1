
// Time Complexity : Amortized O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {
    static class Node {
        int key;
        int value;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    int bucketsize;
    Node[] arr;
    public MyHashMap() {
         bucketsize = 10000;
         arr = new Node[bucketsize];

    }
    public int getHash(int key){
        return key%bucketsize;
    }
    public Node find(int key, Node node){
       Node prev = node;
       Node curr = node.next;
       while(curr!=null && curr.key != key){
           prev= curr;
           curr = curr.next;
       }
       return prev;
    }
    
    public void put(int key, int value) {
        int hash = getHash(key);
        if(arr[hash]==null){
            arr[hash]= new Node(-1,-1);
        }
        Node prev = find(key, arr[hash]);
        if(prev.next ==null){
            prev.next = new Node(key, value);
        }
        else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int hash = getHash(key);
        if(arr[hash]!=null){
            Node prev = find(key, arr[hash]);
            if(prev.next!=null){
                return prev.next.value;
            }

        }
        return -1;
        
    }
    
    public void remove(int key) {
        int hash = getHash(key);
        if(arr[hash]!=null){
            Node prev = find(key, arr[hash]);
            if(prev.next!=null){
                prev.next= prev.next.next;
            }

        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */