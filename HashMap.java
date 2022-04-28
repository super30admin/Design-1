//-----------------Double Hashing using node class----------------
// Time Complexity :All methods O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :I was initiating the array everytime at index 0
class MyHashMap {
    private int keyList;
    private int keyItem;
    private HashPair[][] map;

    private static class HashPair {
        private int key;
        private int value;

        HashPair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.keyList = 1000;
        this.keyItem = 1000;
        this.map = new HashPair[keyList][];
    }

    private int getKey(int key) {
        return key % keyList;
    }

    private int getItem(int key) {
        return key / keyItem;
    }

    public void put(int key, int value) {
        if (map[getKey(key)] == null && getKey(key) == 0) {
            map[getKey(key)] = new HashPair[keyItem + 1];
        }
        if (map[getKey(key)] == null) {
            map[getKey(key)] = new HashPair[keyItem];
        }
        map[getKey(key)][getItem(key)] = new HashPair(key, value);

    }

    public int get(int key) {
        if (map[getKey(key)] == null) {
            return -1;
        } else if (map[getKey(key)][getItem(key)] != null) {
            return map[getKey(key)][getItem(key)].value;
        }
        return -1;

    }

    public void remove(int key) {
        if (map[getKey(key)] != null) {
            map[getKey(key)][getItem(key)] = null;
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

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// ------------DOUBLE HASHING BY STORING VALUE AT INDEX KEY-------------

// Time Complexity :All methods O(1)
// Space Complexity :O(1) BETTER THAN ABOVE SOLUTION
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :I was initiating the array everytime
// at index 0

// we'll use double hashing to make hashmap and will store values inside the
// array while key will refer to index

class MyHashMap {
    private int keyList;// declaring keylist,keyitem and map
    private int keyItem;
    private int[][] map;

    public MyHashMap() {
        this.keyList = 1000;
        this.keyItem = 1000;
        this.map = new int[keyList][];
    }

    private int getKey(int key) {
        return key % keyList;
    }

    private int getItem(int key) {
        return key / keyItem;
    }

    public void put(int key, int value) {
        int x = getKey(key);
        int y = getItem(key);
        if (map[x] == null && x == 0) {
            map[x] = new int[keyItem + 1];
        }
        if (map[x] == null) {
            map[x] = new int[keyItem];
        }
        if (value == 0) {
            map[x][y] = -1;
            return;
        }
        map[x][y] = value;

    }

    public int get(int key) {
        int x = getKey(key);
        int y = getItem(key);
        if (map[x] == null) {
            return -1;
        } else if (map[x][y] == -1) {
            return 0;
        } else if (map[x][y] != 0) {
            return map[x][y];
        }

        return -1;

    }

    public void remove(int key) {
        int x = getKey(key);
        int y = getItem(key);
        if (map[x] != null) {
            map[x][y] = 0;
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
// ------------------------ CHAINING--------------------------
// Time Complexity :All methods O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

class MyHashMap {
    private int KeySize;// declaring size of array
    Node[] result;

    public class Node {
        Node next;// creating node class for key value pair
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public Node searchPrevious(int key) {// to search previous pointer
        int x = getIndex(key);// first find the index
        Node curr = result[x];
        Node prev = null;
        while (curr != null && curr.key != key) {// traverse through array until we find prev node to key element
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public MyHashMap() {
        this.KeySize = 10000;
        result = new Node[KeySize];
    }

    public int getIndex(int key) {
        return key % KeySize;// returning index of key by hashing
    }

    public void put(int key, int value) {
        int x = getIndex(key);
        if (result[x] == null) {// if array has no chain at the index
            result[x] = new Node(-1, -1);// we'll first make new dummy node
            Node dummy = result[x];
            dummy.next = new Node(key, value);// then will insert the key value pair
            dummy.next.next = null;
        } else {
            Node prev = searchPrevious(key);// else will search previous
            if (prev.next == null) {// if key is not found make new
                prev.next = new Node(key, value);
                prev.next.next = null;
            } else {
                Node temp = prev.next;// else replace the value
                prev.next.value = value;
            }

        }
    }

    public int get(int key) {
        int x = getIndex(key);
        if (result[x] == null) {// if no chain is tehre retirn -1
            return -1;
        }
        Node prev = searchPrevious(key);
        if (prev.next == null) {// else find prev, if that is also null return -1
            return -1;
        } else {
            return prev.next.value;// if it is tehre return next to prev ie current element
        }

    }

    public void remove(int key) {
        int x = getIndex(key);
        if (result[x] == null) {
            return;
        }
        Node prev = searchPrevious(key);
        if (prev.next == null) {
            return;
        } else {
            Node temp = prev.next.next;// if node is there to remove we'll point prev pointer to next to next node
            prev.next = temp;
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