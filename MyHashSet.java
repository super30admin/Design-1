// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashSet {

  boolean[][] primary;
  int primarySize = 1000;
  int secondarySize = 1000;

  public MyHashSet() {
    primary= new boolean[primarySize][];
  }

  public void add(int key) {
    int hash= key%primarySize;
    if(primary[hash] == null ){
      boolean[] s= new boolean[secondarySize+1];
      int h=key/secondarySize;

      s[h]=true;
      primary[hash]= s;
    }
    else{
      boolean[] s= primary[hash];
      int h=key/secondarySize;
      s[h]=true;
    }
  }

  public void remove(int key) {
    int hash= key%primarySize;
    if(primary[hash] == null ){
      return;
    }
    else{
      boolean[] s= primary[hash];
      int h=key/secondarySize;
      s[h]=false;
    }

  }

  public boolean contains(int key) {
    int hash= key%primarySize;
    if(primary[hash] == null ){
      return false;
    }
    else{
      boolean[] s= primary[hash];
      int h=key/secondarySize;
      return s[h];
    }
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */