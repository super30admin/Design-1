// Time Complexity : O(N)
// Space Complexity : O(M + N) Where M is your fixed array of 1,000 buckets, N is the actual number of nodes created to store data
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
// The CustomHashSet uses an array of 1,000 buckets, where each bucket acts as a Linked List to store keys that share the same hash index.
// The add, remove, and contains methods calculate the index using the modulo operator and then traverse the corresponding list to perform the operation.
// By using a dummy node at the start of every bucket, the code simplifies deletion logic and ensures unique keys by checking for duplicates before every insertion.

public class CustomHashSet {
    class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
            this.next = null;
        }
    }
    public static final int size = 1000;
    public Node[] buckets;


    public CustomHashSet() {
        buckets = new Node[size];
    }

    public int getHash(int key) {
        return key % size;
    }
    
    public void add(int key) {
        int index = getHash(key);

      if (buckets[index] == null) {
        buckets[index] = new Node(-1);
      }
        Node previousNode = this.buckets[index];
        Node currentNode = previousNode.next;

        while (currentNode != null) {
            if (key == currentNode.key) {
                currentNode.key = key;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        Node newNode = new Node(key);
        previousNode.next = newNode;

    }
    
    public void remove(int key) {
       int index = getHash(key);
        if (buckets[index] == null) return;
            Node previousNode = buckets[index];
            Node currentNode = previousNode.next;

            while(currentNode != null) {
                if (key == currentNode.key) {
                    previousNode.next = currentNode.next;
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
            } 
    }
    
    public boolean contains(int key) {
       int index = getHash(key);
        if (buckets[index] == null) return false;
                Node currentNode = buckets[index].next;
                while(currentNode != null) {
                if (key == currentNode.key) {
                    return true;
                }
                currentNode = currentNode.next;
                }
        return false; 
    }
}
