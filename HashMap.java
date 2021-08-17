import java.util.ArrayList;
import java.util.List;

class MyHashMap {
    int size;

    class MyHashNode {
        int key;
        int value;
        MyHashNode next;

        MyHashNode(int key, int value) {
            this.key = key;
            this.value = value;
        } 
    }

    List<MyHashNode> hashTable;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.size = 31;
        hashTable = new ArrayList<>();
        for (int i = 0; i < this.size; i++) {
            hashTable.add(i, null);
        }
    }

    private int getIndex(int key) {
        return key % this.size;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        MyHashNode head = hashTable.get(index);
        while (head != null) {
            if (head.key == key) {
                head.value = value;
            }
            head = head.next;
        }
        head = hashTable.get(index);
        MyHashNode hashNode = new MyHashNode(key, value);
        hashNode.next = head;
        hashTable.set(index, hashNode);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        MyHashNode head = hashTable.get(index);
        while (head != null) {
           if (head.key == key) {
               return head.value;
           } 
           head = head.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        MyHashNode head = hashTable.get(index);
        if (head != null && head.key == key) {
            hashTable.add(index, head.next);
            return;
        }
        if (head.next != null) {
            while (head.next.key != key) {
                head = head.next;
            }
        }
        if (head != null) {
            MyHashNode temp = head.next;
            head.next = temp.next;
        }
    }
}


class Main {
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        for (int i = 0; i < 50; i++) {
            hashMap.put(i, i*3);
        }
        System.out.println(hashMap.get(3));
        hashMap.remove(3);
        System.out.println(hashMap.get(3));
        System.out.println(hashMap.get(49));
    }
}