
class MyHashMap {

  class Node{
    int key;
    int val;
    Node next;

    public Node(int key, int val){
      this.key = key;
      this.val = val;
    }
  }

  Node[] map;

  /** Initialize your data structure here. */
  public MyHashMap() {
    map =  new Node[1000];
  }

  /** value will always be non-negative. */
  //TC - O(1)
  //SC - O(1)
  public void put(int key, int value) {
    int idx = getIndex(key);

    if(map[idx] == null){
      map[idx] = new Node(-1, -1);
    }

    Node node = findElement(map[idx], key);
    if(node.next == null){
      node.next = new Node(key,value);
    }
    else{
      node.next.val = value;
    }

  }

  /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
  //TC - O(1)
  //SC - O(1)
  public int get(int key) {
    int idx = getIndex(key);
    if(map[idx] == null){
      return -1;
    }
    Node node = findElement(map[idx], key);
    return node.next == null ? -1 : node.next.val;
  }

  /** Removes the mapping of the specified value key if this map contains a mapping for the key */
  //TC - O(1)
  //SC - O(1)
  public void remove(int key) {
    int idx = getIndex(key);
    if(map[idx] == null){
      return;
    }
    Node node = findElement(map[idx], key);
    if(node.next == null){
      return;
    }
    node.next = node.next.next;
  }

  private int getIndex(int key){
    return Integer.hashCode(key) % map.length;
  }

  private Node findElement(Node node, int key){
    Node bucket = node, prev = null;
    while(bucket != null && bucket.key != key){
      prev = bucket;
      bucket = bucket.next;
    }
    return prev;
  }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
