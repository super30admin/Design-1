// Time Complexity :

/**
 * put() : O(n) if there are multiple values at a particular node, the entire list has to be traversed
 * get() : O(n)
 * remove() : O(n)
 */
// Space Complexity : O[n]
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class HashMap {


    class Node{
        int key;
        int value;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    Node[] nodes = new Node[10000];


    /** Initialize your data structure here. */
    public HashMap() {

    }

    private int index(int key){
        return Integer.hashCode(key)% nodes.length;
        //We do mod operation to get values in the ranges of the node array
    }

    //returns the prev node
    public Node find(int key,Node head){
        Node prev = null;
        Node current = head;
        while(current!= null && current.key!=key){
            prev = current;
            current = current.next;
        }
        return prev;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        // int index = key % 10000;

        int i = index(key);

        if(nodes[i] == null){   //Dummy node insertion
            nodes[i] = new Node(-1,-1);
        }
        Node prev = find(key,nodes[i]);
        //If an element does not exist
        if(prev.next == null)
            prev.next = new Node(key,value);
        //if a node already exists, replace the value
        else
            prev.next.value = value;

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        int i = index(key);

        if(nodes[i]==null)
            return -1;

        Node prev = find(key,nodes[i]);

        if(prev.next == null) //The element was not found.
            return -1;

        return prev.next.value; //Return the element.

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int i = index(key);

        if(nodes[i]==null)
            return ;

        Node prev= find(key,nodes[i]);

        if(prev.next == null)
            return;

        prev.next = prev.next.next;

    }
}

class Main{
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        hm.put(1,2);
        System.out.println(hm.get(1));
        System.out.println(hm.get(2));
        hm.remove(1);
        System.out.println(hm.get(1));

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */