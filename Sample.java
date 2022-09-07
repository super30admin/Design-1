// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class MyHashMap {

    private int size = 500;
    private Node[] nodeHeads = new Node[size];
    private class Node {
        Node next;
        int key;
        int val;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public MyHashMap() {

    }

    public void put(int key, int value) {
        int index = hash(key);
        Node temp = nodeHeads[index];
        if (temp == null){
            nodeHeads[index] = new Node(key, value);
            return;
        }
        Node prev = temp;
        while (temp != null){
            if (temp.key == key){
                temp.val = value;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        prev.next = new Node(key,value);
    }

    public int get(int key) {
        int index = hash(key);
        Node temp = nodeHeads[index];
        while (temp != null ){
            if (temp.key == key){
                return temp.val;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node temp = nodeHeads[index];
        if (temp == null){
            return;
        }
        if (temp.key == key){
            nodeHeads[index] = nodeHeads[index].next;
        }
        while (temp.next != null ){
            if (temp.next.key == key){
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
    
    private int hash(int key){
        return key % size;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// Your code here along with comments explaining your approach
