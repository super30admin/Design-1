// Time Complexity : O(1) 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Node{
    int val;
    int key;
    Node next;
    
    Node(int key, int val){
        this.val =val;
        this.key=key;
    }
}
class MyHashMap {
Node[] map ;


public MyHashMap() {
    map = new Node[1000];
}

private int getHash(int val){
    return val % 1000;
}

public void put(int key, int value) {
    int i=getHash(key);
    if(map[i]==null)
        map[i] = new Node(-1,-1);
    
  Node prev= find(map[i],key);
if(prev.next==null)
    prev.next= new Node(key,value);
else
    prev.next.val=value;
    
}
public Node find(Node node, int key){
    Node prev=null;
while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
}

public int get(int key) {
    int i=getHash(key);
    if(map[i]==null)
        return -1;
    Node prev=find(map[i],key);
    if(prev.next==null)
        return -1;
    else
        return prev.next.val;
}

public void remove(int key) {
    int i=getHash(key);
    if(map[i]==null)
        return;
    
    Node prev = find(map[i],key);
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
*/
