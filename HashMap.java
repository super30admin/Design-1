class MyHashMap {
  class Node {
      int key;
      int value;
      Node next;

      public Node(int key, int value) {
          this.key = key;
          this.value = value;
          this.next = null;
      }
  }

  int size = 1000;
  Node[] array;

  public MyHashMap() {
      array = new Node[size];
  }
      
  public void put(int key, int value) {
      int index = getIndex(key);
      
      if(array[index] == null) {
         array[index] = new Node(-1, -1); 
      }
      
      Node prev = findNode(key, array[index]);
      if (prev.next == null) {
          prev.next = new Node(key, value);;
      } else {
          prev.next.value = value;
      }
  }
  
  public int get(int key) {
      int index = getIndex(key);
      
      if(array[index] == null){
          return -1;
      }
      
      Node prev = findNode(key, array[index]);
      if(prev.next == null) {
          return -1;
      }
      
      return prev.next.value;
  }
  
  public void remove(int key) {
      int index = getIndex(key);
      
      if(array[index] == null){
          return;
      }else{
          Node prev = findNode(key, array[index]);
          if(prev.next == null) {
              return;
          } else {
              prev.next = prev.next.next;
          }
      }
  }
  
  public int getIndex(int key) {
      return Integer.hashCode(key) % size;
  }
  
  public Node findNode(int key, Node node) {
      Node prev = null;
      Node curr = node;
      
      while(curr != null && curr.key != key) {
          prev = curr;
          curr = curr.next;
      }
      
      return prev;        
  }
}