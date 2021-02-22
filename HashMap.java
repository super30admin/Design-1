// Time Complexity :
//put operation :O(n)
//get operation :O(n)
//remove operation :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach

//I created a linked list with two values,key and value pairs and performed the operations
//and then performed the operations on the linked list.
class MyHashMap {
    	MyNode head;

	class MyNode {
		int key;
		int value;
		MyNode next;

		MyNode(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        MyNode temp = head;
		while (temp != null) {
			if (temp.key == key) {
				temp.value = value;
				return;
			}
			temp = temp.next;
		}
		MyNode newNode = new MyNode(key, value);
		if (get(key) == -1) {

		}
		if (head == null) {
			head = newNode;
			return;
		} else {
			temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        MyNode temp = head;
		while (temp != null) {
			if (temp.key == key) {
				return temp.value;
			}
			temp = temp.next;
		}
		return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if (get(key) == -1) {
			System.out.println("Key not found");
			return;
		}
		MyNode prev = null;
		MyNode present = head;
		while (present.key != key) {
			prev = present;
			present = present.next;
		}
		if (prev == null) {
			head = present.next;
			present.next = null;
		}else {
			System.out.println(prev.key+","+present.key);
			prev.next=present.next;
			present.next=null;
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
 
 ////////
 class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        Node(int ke,int v){
            this.key=ke;
            this.val=v;
            this.next=null;
        }
    }
    
    Node[] buckets;

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets=new Node[10000];
    }
    
    public int getIndex(int key){
        return Integer.hashCode(key)%buckets.length;
    }
    
    public Node findElement(int index,int key){
        if(buckets[index]==null){
            buckets[index]=new Node(-1,-1);
        }
        Node temp=buckets[index];
        Node prev=null;
        while(temp!=null && temp.key!=key){
            prev=temp;
            temp=temp.next;
        }
        
        return temp==null?null:prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index=getIndex(key);
        Node node=findElement(index,key);
        if(node==null){
            Node temp=buckets[index];
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=new Node(key,value);
        }else{
            node.next.val=value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index=getIndex(key);
        Node temp=buckets[index];
        while(temp!=null){
            if(temp.key==key){
                return temp.val;
            }
            temp=temp.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index=getIndex(key);
        Node node=findElement(index,key);
        if(node!=null){
            node.next=node.next.next;
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