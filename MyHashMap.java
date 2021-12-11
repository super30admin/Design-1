// Time Complexity : O(max LL length)
// Space Complexity : O(buckets) + O(LL length), max length of the linked list can be 100 if there are 1-10^6 elements present
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : no


class MyHashMap {

    // Taking implementation with the Linked list to store the elements in case of collisions,
    // this technique is called linear chaining
    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Taking buckets as 10000 because the elements range can vary from 1-10^6
    // square root of 10^6 is 10^3, we have taken 10^4 so that the max linked list length in case of collisions is not large but 100 at max
    int buckets = 10000;

    // Taking simple hash function
    private int hashFunc(int key) {
        return key%buckets;
    }

    // This is the main array of type Node as it will store the address of HEAD nodes of our LinkedList
    Node[] arr = new Node[buckets];

    private Node find(int key) {
        // Find hash
        int index = hashFunc(key);

        Node prev;
        // Case when the key doesn't exist, we return empty Node.
        if(arr[index] == null) {
            prev = new Node(-1, -1);
            arr[index] = prev;
            return prev;
        }
        // If the key exist, find its head
        prev = arr[index];
        //Traverse the LinkedList to find the element
        while(prev.next!=null) {
            if(prev.next.key == key) {
                break;
            }
            prev = prev.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        Node myNode = new Node(key, value);
        Node prev = find(key);
        // key already exist
        if(prev.next!=null) {
            prev.next.value = value;
        } else {
            // key doesn't exist
            prev.next = myNode;
        }
    }

    public int get(int key) {
        Node prev = find(key);
        // key already exist
        if(prev.next!=null) {
            return prev.next.value;
        } else {
            // key doesn't exist
            return -1;
        }
    }

    public void remove(int key) {
        // Gives the node previous to the asked key, because we want to remove the current key, hence we need the previous node to move the pointers
        Node prev = find(key);
        // prev.next contains the key asked to be removed
        // Moving the pointer from next to next to remove the key element
        if(prev.next!=null) {
            prev.next = prev.next.next;
        }
    }

    public static void main(String[] args) {
         MyHashMap obj = new MyHashMap();
         obj.put(1,2);
         obj.remove(1);
         obj.get(1);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
