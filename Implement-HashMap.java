// Time Complexity : Put - O(n), Get - O(n), Remove - O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyHashMap {
    class Node{
        int key, value;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    Node[] nodes;

    public MyHashMap() {
        nodes = new Node[10000];
    }

    public int hash(int key){
        return key % nodes.length;
    }

    public Node search(Node head, int key){
        Node curr = head;
        Node prev = curr;
        while(curr!=null && curr.key!=key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if(nodes[index]==null){
            nodes[index] = new Node(-1,-1);
        }
        Node curr = search(nodes[index], key);
        if(curr.next==null) curr.next = newNode;
        else curr.next.value = value;
    }

    public int get(int key) {
        int index = hash(key);
        if(nodes[index]==null) return -1;
        Node prev = search(nodes[index], key);
        if(prev.next==null) return -1;
        return prev.next.value;
    }

    public void remove(int key) {
        int index = hash(key);
        if(nodes[index]==null) return;
        Node prev = search(nodes[index], key);
        if(prev.next==null) return;
        prev.next = prev.next.next;
    }
}
