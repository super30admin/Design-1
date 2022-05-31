// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    class MyHashMap {
        //  I am using liner chaining for collision strategy so each bucket will have a linkedlist
        class Node {
            int key;
            int value;
            Node next;

            Node (int key, int value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }

        Node[] hashMap;

        public MyHashMap() {
            hashMap = new Node[10000];
        }

        // this is a helper function to get the prev node for the node that matches our key
        // prev node because we need previous node's reference for remove() and it also works with other operations
        private Node find (int key, Node head) {
            Node prev = null;
            Node curr = head;

            while (curr != null && curr.key != key) {
                prev = curr;
                curr = curr.next;
            }

            return prev;
        }

        // hash function to get bucket number
        private int bucketNo (int key) {
            return key % 10000;
        }

        public void put(int key, int value) {
            int index = bucketNo(key);

            // if the bucket is accessed for the first time, we assign a dummy node
            if (hashMap[index] == null) {
                hashMap[index] = new Node(-1, -1);
            }

            Node prev = find(key, hashMap[index]);
            if (prev.next == null) {
                prev.next = new Node(key, value);
            } else {
                prev.next.value = value;
            }
        }

        public int get(int key) {
            int index = bucketNo(key);
            String out ="";
            Node s = hashMap[index];
            while (s != null) {
                out += "( "+ s.key + " , " + s.value+ " ) ->";
                s = s.next;
            }

            if (hashMap[index] == null) {
                return -1;
            }

            Node prev = find(key, hashMap[index]);
            if (prev.next != null) {
                return prev.next.value;
            } else {
                return -1;
            }

        }

        public void remove(int key) {
            int index = bucketNo(key);
            if (hashMap[index] == null) {
                return ;
            }
            Node prev = find(key, hashMap[index]);
            if (prev.next != null) {
                prev.next = prev.next.next;
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
}
