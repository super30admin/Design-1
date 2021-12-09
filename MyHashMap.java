// Time Complexity : O(max LL length)
// Space Complexity : O(buckets) + O(LL length)
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this : no


class MyHashMap {

    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int buckets = 10000;

    private int hashFunc(int key) {
        return key%buckets;
    }

    Node[] arr = new Node[buckets];

    private Node find(int key) {
        int index = hashFunc(key);

        Node prev;
        if(arr[index] == null) {
            prev = new Node(-1, -1);
            arr[index] = prev;
            return prev;
        }
        prev = arr[index];
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
        Node prev = find(key);
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
