// Time Complexity : put-O(n), get-O(n), remove-O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : no
// Any problem you faced while coding this : I think the implementation is fine, but not working, I need to spend some more time on this to debug and correct them.

public class MyHashMap {
    LkdListNode nodes[]=new LkdListNode[100];

//creating a Node user defined class
class LkdListNode{
int key;
int value;
LkdListNode next;
}

public int _hash(int key){
return key%100;
}
/** Initialize your data structure here. */
public MyHashMap() {
//creating a new node with -1,-1 as key value pairs for every array element
for(int i=0;i<nodes.length;i++){
    nodes[i]=new LkdListNode();
    nodes[i].key=-1;
    nodes[i].value=-1;
    nodes[i].next=null;
}

}

/** value will always be non-negative. */
public void put(int key, int value) {
int index=_hash(key);
LkdListNode head=nodes[index];
LkdListNode dummy=head;
boolean nodeExists=false;
//Checking if linkedList is empty
while(dummy.next!=null){
    if(dummy.key==key){
        //overwriting the existing key's value
        dummy.value=value;
        nodeExists=true;
    }
        dummy=dummy.next;
}
if(dummy.next==null && (!nodeExists)){
LkdListNode newNode=new LkdListNode();
//inserting new Node Values
newNode.key=key;
newNode.value=value;
newNode.next=null;
//assigning the next pointer to the new Node.
dummy.next=newNode;
}
}

/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
public int get(int key) {
int index=_hash(key);
LkdListNode head=nodes[index];
LkdListNode dummy=head;

while(dummy.next!=null){
    //if node with key is found then it's value is returned else iterated to the next nodes
    if(dummy.key==key){
        return dummy.value;
    }
    dummy=dummy.next;
}
//if element not found
return -1;
}

/** Removes the mapping of the specified value key if this map contains a mapping for the key */
public void remove(int key) {
int index=_hash(key);
LkdListNode head=nodes[index];
LkdListNode dummy=head;
LkdListNode prevNode=null;

while(dummy.key!=key){
    // assigning the previous Node node and moving the current node(dummy node)
    prevNode=dummy;
    dummy=dummy.next;
    
}

//after element is found the previous node's next is pointed to the next node of the next node , removing the node with the key deleted.
prevNode.next=dummy.next;
}
}

/**
* Your MyHashMap object will be instantiated and called as such:
* MyHashMap obj = new MyHashMap();
* obj.put(key,value);
* int param_2 = obj.get(key);
* obj.remove(key);
*/