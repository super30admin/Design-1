// Time Complexity :
//getHash : O(1)
//findPrev : O(N) where N is number of Nodes
//put : O(N) where N is number of Nodes
//get : O(N) where N is number of Nodes
//remove : O(N) where N is number of Nodes
//
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashMap {
    
    class Node{//creating a class called Node, which consists of key,val a next pointer of type Node
        
        private int key,val;  
        private Node next;
        Node(int key,int val,Node next){//initializing constructor
            this.key=key;
            this.val=val;
            this.next=next;
        }
    }
    public static final int NUM_BUCKETS=10000;//to create 10000 buckets(according to constraints) 
    Node[] buckets;//array of buckets

    public MyHashMap() {
        buckets=new Node[NUM_BUCKETS];//initializing array
    }
    
    public int getHash(int key){//to get hashcode
        return key%NUM_BUCKETS;
    }
    
    private Node findPrev(int key){//finding prev node which will be helpful for performing diff operations
        int hash=getHash(key);     //getting hashcode by passing key
        if(buckets[hash]==null) //checking if bucket of that particular hashcode is created or not
            return null;
        Node prev=buckets[hash]; //if bucket is created, finding prev 
        Node cur=prev.next;
        while(cur!=null && cur.key!=key){
            prev=cur;
            cur=cur.next;
        }
        return prev;
    }
    public void put(int key, int value) {// to put a key in to map
        Node prev=findPrev(key);//finding prev
        Node cur=new Node(key,value,null);//creating a Node using given key,value pair
        if(prev==null){// if prev is null create a bucket by getting hashcode and insert the created node
            int hash=getHash(key);
            buckets[hash]=new Node(-1,-1,null);//creating dummy node
            prev=buckets[hash];//assigning dummy to prev
             prev.next=cur;//assigning created node to next pointer of prev
        }
        else if(prev.next==null)//if bucket is created then inserting created node at the end
            prev.next=cur;
        else{
            prev.next.val=value;//if key already exists updating the value
        }
    }
    
    public int get(int key) {//to get value by of a key
        Node prev=findPrev(key);//finding prev
        if(prev==null || prev.next==null){//if prev is null or prev.next is null that means key is not present in the map
            return -1;
        }
        return prev.next.val;//if key is present then returning the value 
    }
    
    public void remove(int key) {//to remove key 
        Node prev=findPrev(key);//finding prev
        if(prev==null || prev.next==null){// if prev is null and prev.next is null, that means key is not present
            return;
        }
        prev.next=prev.next.next;//removing key node by pointing prev.next to prev.next.next
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
