//  Did this code successfully run on Leetcode : Yes
// TC: O(n/k) for all function calls where n is the number of keys and k is the size of hashset
// SC: O(k + m) k is the size of the hashset m is the number of unique keys.
// Solving hashset by using static array as base datastructure and node as the higher order data structure
// add - if first node then directly add to the static array hashset or add to the end of the LL
// remove - if only one node then point to the next node which will be null or use two pointers to point the previous node to the next node
// contains - traverse to check if the key is already present, if present return true else false
class MyHashSet {

    private class Node {
        int key;
        Node next;
        Node(int key){
            this.key = key;
            this.next = null;
        }
    }

    private Node[] hashSet;

    public MyHashSet() {
        hashSet = new Node[10_00];
    }
    
    public void add(int key) {
        int index = getKey(key);
        Node newNode = new Node(key);
        Node curr = hashSet[index];
        if(curr == null){
            hashSet[index] = newNode;
        } else {
            if(contains(key)) return;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }
    
    public void remove(int key) {
        if(!contains(key)) return;
        int index = getKey(key);
        Node curr = hashSet[index];
        Node prev = null;
        //One node
        if(curr.key == key) {
            hashSet[index] = curr.next;
            return;
        }
        //Other cases
        while(curr != null){
            if(curr.key == key){
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        int index = getKey(key);
        Node curr = hashSet[index];
        while(curr != null){
            if(curr.key == key) return true;
            curr = curr.next;
        }
        return false;
    }

    private int getKey(int val){
        return val % hashSet.length;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */