package com.design1;


class MyHashMap {


    class ListNode {
        int key, val;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public ListNode[] bucket;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        bucket = new ListNode[10000];
    }

    public int hash(int key) {
        return Integer.hashCode (key) % 10000;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {

        int hc = hash (key);

        if (bucket[hc] == null) {
            bucket[hc] = new ListNode (key, value);
            return;
        }
        ListNode head = bucket[hc];
        while ((head != null)) {
            if (head.key == key) {
                head.val = value;
                return;
            }
            if (head.next == null) break;
            head = head.next;
        }
        head.next = new ListNode (key, value);
        return;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int hc = hash (key);
        if (bucket[hc] == null) return -1;
        ListNode head = bucket[hc];
        while (head != null) {
            if (head.key == key) return head.val;
            head = head.next;
        }
        return -1;

    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {

        int hc = hash (key);
        if (bucket[hc] == null) return;
        ListNode prev = null;
        ListNode head = bucket[hc];
        while (head != null) {
            if (head.key == key) {
                if (prev == null) {
                    bucket[hc] = head.next;
                    return;
                } else {
                    prev.next = head.next;
                    return;
                }
            }
        }
        return;
    }


    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */

    public static void main(String args[]) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println (hashMap.get (1));
        hashMap.get(1);            // returns 1
        hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        hashMap.get(2);            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        hashMap.get(2);            // returns -1 (not found)


    }
}