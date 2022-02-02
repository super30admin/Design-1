
// o(n space)
// o(n) for all operation
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Approach : Using linear sepearte chaining for collison resolution strategy.
class MyHashMap {

  class Entry{

    Integer key;
    Integer value;

    public Entry(Integer key, Integer value){
      this.key = key;
      this.value = value;
    }

  }

  class Node{

    Entry e;
    Node next;

    public Node(Entry e){
      this.e = e;
    }

  }

  final public int SIZE = 10000;
  Node[] map;

    public MyHashMap() {
      map = new Node[SIZE];
    }

    public void put(int key, int value) {
      Entry e = new Entry(key, value);
      Node n = new Node(e);
      remove(key);

      int index = getIndex(key);

      if(map[index] == null){
        map[index] = new Node(null);
        map[index].next = n;
      }
      else{
      Node temp =   map[index].next;
      map[index].next = n;
      n.next = temp;
      }


    }

    public int get(int key) {
      int index = getIndex(key);
      Node root = map[index];

      while(root != null){
        if(root.next != null && root.next.e.key == key){
          return root.next.e.value;
        }
        root = root.next;
      }
      return -1;

    }

    public void remove(int key) {

      int index = getIndex(key);
      Node root = map[index];

      while(root != null){
        if(root.next != null && root.next.e.key == key){
          root.next = root.next.next;
          return;
        }
        root = root.next;
      }

    }

    public boolean containsKey(int key) {
      int index = getIndex(key);
      Node root = map[index];

      while(root != null){
        if(root != null && root.e.key == key){
          return true;
        }
        root = root.next;
      }
      return false;

    }

    public int getIndex(int key){
      return key%(SIZE-1);
    }
}
