/*
Space Complexity: O(N+K) where N is the number of unique key nodes stored and K is the size of the array.
Time Complexity: O(1) in average case, O(N) if all the N inputs fall under a single array index as a linked list.
Chosen a prime number hash value for finding a spot in the array for the keys. Chose a linked list for same keys to fall under that index. chose the SIZE as 10007 as that is the closest prime number to the 10^4 operations count, which gives us average load factor of 1. 
*/

class MyHashSet {

    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    private final int SIZE = 10007;
    private final Node[] hashArray;

    public MyHashSet() {
        hashArray = new Node[SIZE];
    }
    
    public void add(int key) {
        int modulo = key % SIZE;

        if (hashArray[modulo] == null) {
            hashArray[modulo] = new Node(key);
            return;
        }
        
        Node inspectorNode = hashArray[modulo];
        while (true) {
            if (inspectorNode.key == key) return; // already exists
            if (inspectorNode.next == null) break; // reached end of list
            inspectorNode = inspectorNode.next;
        }
        inspectorNode.next = new Node(key);
    }
    
    public void remove(int key) {
        int modulo = key % SIZE;

        if (hashArray[modulo] == null) {
            return; 
        }
        
        if (hashArray[modulo].key == key) {
            hashArray[modulo] = hashArray[modulo].next;
            return;
        }

        Node curr = hashArray[modulo];
        while (curr.next != null) {
            if (curr.next.key == key) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }
    
    public boolean contains(int key) {
        int modulo = key % SIZE;
        Node curr = hashArray[modulo];
        
        while (curr != null) {
            if (curr.key == key) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }
}
