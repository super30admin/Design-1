import java.util.Arrays;
//Time Complexity : O(n);
// Space Complexity : O(n); n = [0, 1000000]
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class MyHashMap {

    private class ListNode {
        int key, value;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }
    ListNode[] map ;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new ListNode[10000];
    }

    /** value will always be non-negative. */
    //Time Complexity: O(n)
    public void put(int key, int value) {
        int index = hashFunc(key);
        ListNode prev = find(index, key);

        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        }
        else {
            prev.next.value = value;
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    //Time Complexity: O(n)
    public int get(int key) {
        int index = hashFunc(key);
        ListNode cur = find(index, key).next;
        return cur == null ? -1 : cur.value;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    //Time Complexity: O(n)
    public void remove(int key) {
        int index = hashFunc(key);
        ListNode prev = find(index, key);
        if (prev.next != null) {
            ListNode tmp = prev.next;
            prev.next = tmp.next;
        }
    }

    //Time Complexity: O(1)
    private int hashFunc(int key) {
        return key % map.length;
    }

    //Time Complexity: O(n)
    private ListNode find(int index, int key) {

        if (map[index] == null) {
            map[index] = new ListNode(-1, -1);
        }

        ListNode prev = map[index];
        while (prev.next != null && prev.next.key != key)
            prev = prev.next;
        return prev;
    }

}

