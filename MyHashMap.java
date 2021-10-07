// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {
    
    class Node{
        int key;
        int value;
        Node next;
        
        Node(int key,int value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }
    Node[] map;
    
    public MyHashMap() {
        map=new Node[10000];
    }
    
    public int getHash(int key){
        return (Integer.hashCode(key))%10000;
    }
    
    public void put(int key, int value) {
        int hash=getHash(key);
        if(map[hash]==null){
            map[hash]=new Node(-1,-1,null);
        }
        
        Node n=map[hash];
        while(n.next!=null){
            if(n.key==key){
                break;
            }
            n=n.next;
        }
        if(n.key==key){
           n.value=value; 
        }else{
            n.next=new Node(key,value,null);
        }
    }
    
    public int get(int key) {
       int hash=getHash(key);
        if(map[hash]==null){
            return -1;
        }
        
        Node n=map[hash];
        while(n!=null){
            if(n.key==key){
                return n.value;
            }
            n=n.next;
        }
        return -1;  
    }
    
    public void remove(int key) {
        int hash=getHash(key);
        if(map[hash]==null){
            return;
        }
        Node n=map[hash];
        Node prev=n;
        Node curr=n.next;
        while(curr!=null){
            if(curr.key==key){
                prev.next=curr.next;
                break;
            }
            prev=prev.next;
            curr=curr.next;
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