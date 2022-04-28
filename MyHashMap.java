import java.util.*;

class MyHashMap {
  class Node {
    int key;
    int val;
    Node next;

    public Node(int key, int value) {
      this.key = key;
      this.val = value;

    }

  }

  Node[] storage;
  int buckets;

  public MyHashMap() {
    this.buckets = 10000;
    this.storage = new Node[buckets];
  }

  public int bucket(int key) {
    return key % buckets;
  }

  private Node find(Node head, int key) {
    Node prev = null;
    Node curr = head;
    while (curr != null && curr.key != key) {
      prev = curr;
      curr = curr.next;
    }
    return prev;
  }

  public void put(int key, int value) {
    int bucket = bucket(key);
    if (storage[bucket] == null) {
      storage[bucket] = new Node(-1, -1);
    }
    Node prev = find(storage[bucket], key);
    if (prev.next == null) {
      prev.next = new Node(key, value);
    } else {
      prev.next.val = value;
    }
  }

  public int get(int key) {
    int bucket = bucket(key);
    if (storage[bucket] == null)
      return -1;
    Node prev = find(storage[bucket], key);
    if (prev.next == null)
      return -1;
    return prev.next.val;
  }

  public void remove(int key) {
    int bucket = bucket(key);
    if (storage[bucket] == null)
      return;
    Node prev = find(storage[bucket], key);
    if (prev.next == null)
      return;
    prev.next = prev.next.next;
  }

  /**
   * Your MyHashMap object will be instantiated and called as such:
   * MyHashMap obj = new MyHashMap();
   * obj.put(key,value);
   * int param_2 = obj.get(key);
   * obj.remove(key);
   */

  public static void main(String[] args) {
    /* Start with the empty list. */
    MyHashMap hashMap = new MyHashMap();

    hashMap.put(1, 2);

    hashMap.put(2, 3);

    hashMap.get(1); // returns 2

    hashMap.get(3); // returns -1 (not found)

    hashMap.put(2, 4); // update the existing value

    System.out.println(hashMap.get(2));
    hashMap.get(2); // returns 4

    hashMap.remove(2); // remove the mapping for 2

    hashMap.get(2); // returns -1 (not found)
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */