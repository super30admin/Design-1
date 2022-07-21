// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {

    static ArrayList a;
    
    public MyHashSet() {
        
        this.a = new ArrayList<>();
        
    }
    
    public void add(int key) {
        if(!a.contains(key))
            a.add(key);
    }
    
    public void remove(int key) {
        if(a.contains(key))
            a.remove(a.indexOf(key));
        
    }
    
    public boolean contains(int key) {
        return a.contains(key);
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */// Time Complexity :O(1)
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO
class MyHashMap {
    public class Node{
        int key;
        int val;
        Node next;
        Node(int key,int val){
        this.key=key;
        this.val=val;
        this.next = null;
        }
      }
        Node storage[];
        public int hash(int key){
            return key%10000;
        }

        public MyHashMap() {
           storage=new Node[10000];
        }

        public Node find(Node node,int key){
            Node prev=null;
            Node curr=node;
            while(curr!=null && curr.key!=key){
                System.out.println(curr.key + " " + key);
                prev=curr;
                curr=curr.next;
            }
            return prev;
        }

        public void put(int key, int value) {
            System.out.println(key);
            int index=hash(key);
            if(storage[index]==null){
                storage[index]=new Node(-1,-1);
            }
            Node prev=find(storage[index],key);
            if(prev.next==null){
                prev.next=new Node(key,value);
            }
            else{
                prev.next.val=value;
            }
        }

        public int get(int key) {
            int index=hash(key);
            if(storage[index]==null) return -1;
            Node prev=find(storage[index],key);
            if(prev.next==null) return -1;
            return prev.next.val;
        }

        public void remove(int key) {
            int index=hash(key);
            if(storage[index]==null) return;
            Node prev=find(storage[index],key);
            if(prev.next==null) return;
            prev.next=prev.next.next;
        }
    }

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);