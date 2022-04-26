// Time Complexity : best case - O(1)/wosrt case- O(LL size)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, concept wise

import java.util.LinkedList;
class MyHashMap {
    static class Entry{
        public int key;
        public int val;
        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    LinkedList<Entry>[] arr;
    static final int bucketSize = 992;
    public MyHashMap() {
        arr = new LinkedList[bucketSize];
    }

    public void put(int key, int value) {
        int calcedBucketIndex = bucketIndex(key);
        LinkedList<Entry> entry = arr[calcedBucketIndex];
        boolean updated = false;
        if(entry != null) {
            for(Entry e: entry) {
                if(e.key == key) {
                    e.val = value;
                    updated = true;
                    break;
                }
            }
        } else {
            arr[calcedBucketIndex] = new LinkedList();
        }
        if(!updated) arr[calcedBucketIndex].add(new Entry(key, value));
    }

    public int get(int key) {
        int calcedBucketIndex = bucketIndex(key);
        LinkedList<Entry> entry = arr[calcedBucketIndex];
        if(entry == null) return -1;
        for(Entry e: entry) {
            if(e.key == key) {
                return e.val;
            }
        }
        return -1;
    }

    public int bucketIndex(int key) {
        return key%bucketSize;
    }

    public void remove(int key) {
        int calcedBucketIndex = bucketIndex(key);
        LinkedList<Entry> entry = arr[calcedBucketIndex];
        if(entry != null) {
            for(int i=0;i<entry.size();i++) {
                if(entry.get(i).key == key) {
                    arr[calcedBucketIndex].remove(i);
                }
            }
        }
    }

    public static void main(String args[]) {
        MyHashMap m1 = new MyHashMap();
        m1.put(1,1);
        m1.put(1,24);
        m1.put(2,5);
        System.out.println(m1.get(2));
        m1.remove(2);
        System.out.println(m1.get(2));
    }
}