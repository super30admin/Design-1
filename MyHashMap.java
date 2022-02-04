
// Time Complexity : Since operations put,get,remove needs list to be iterated for the key, TS is O(n)
// Space Complexity : Just getting list node reference, O(1). Nothing else required other than input data.
// Did this code successfully run on Leetcode : Yes (Submission link : https://leetcode.com/submissions/detail/634489018/)
// Any problem you faced while coding this : No
// My Notes :  Replace java linked list with custom linked list, use findPrev solution taught in class.

import java.util.Iterator;
import java.util.LinkedList;

class MyHashMap {
    int nodes_len = 10000;
    Object[] node_list = new Object[nodes_len];

    class Node {
        int val;
        int key;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }
    }

    public MyHashMap() {

    }

    public int getHashCode(int key) {
        return key % nodes_len;
    }

    public void put(int key, int value) {

        int hashCode = getHashCode(key);
        // Check if list created at that node
        if (node_list[hashCode] == null) {
            // Create a new Node
            Node node = new Node(key, value);
            LinkedList<Node> list = new LinkedList<>();
            list.add(node);
            node_list[hashCode] = list;
        } else {
            // System.out.println(" Already Exists ");
            // Get list, iterate, if key exists then replace else add node
            LinkedList<Node> list = (LinkedList<Node>) node_list[hashCode];
            Iterator iterator = list.iterator();
            boolean isKeyPresent = false;
            while (iterator.hasNext()) {
                Node node = (MyHashMap.Node) iterator.next();
                if (key == node.getKey()) {
                    // System.out.println(" Key already present "+node.getKey());
                    node.setVal(value);
                    isKeyPresent = true;
                    break;
                }
            }
            if (!isKeyPresent) {
                // Create a new Node and add
                // System.out.println(" Adding new Node");
                Node node = new Node(key, value);
                list.add(node);
            }
        }
    }

    public int get(int key) {
        int hashCode = getHashCode(key);
        if (node_list[hashCode] != null) {
            LinkedList<Node> list = (LinkedList<Node>) node_list[hashCode];
            Iterator iterator = list.iterator();
            boolean isKeyPresent = false;
            while (iterator.hasNext()) {
                Node node = (MyHashMap.Node) iterator.next();
                if (key == node.getKey()) {
                    // System.out.println(" Key Found present "+node.getKey());
                    return node.getVal();
                }
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hashCode = getHashCode(key);
        if (node_list[hashCode] != null) {
            LinkedList<Node> list = (LinkedList<Node>) node_list[hashCode];
            Iterator iterator = list.iterator();
            boolean isKeyPresent = false;
            while (iterator.hasNext()) {
                Node node = (MyHashMap.Node) iterator.next();
                if (key == node.getKey()) {
                    // System.out.println(" Removing node "+node.getKey());
                    list.remove(node);
                    break;
                }
            }
        }
    }

    public static void main(String args[]) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        myHashMap.get(1); // return 1, The map is now [[1,1], [2,2]]
        System.out.println("GET : " + myHashMap.get(1));
        myHashMap.get(3); // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        System.out.println("GET : " + myHashMap.get(3));
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2); // return 1, The map is now [[1,1], [2,1]]
        System.out.println("GET : " + myHashMap.get(2));
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2); // return -1 (i.e., not found), The map is now [[1,1]]
        System.out.println("GET : " + myHashMap.get(2));
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */