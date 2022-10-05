// Time Complexity : O(1)
// Space Complexity : O(1e6)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class MyHashSet {

  boolean arr[][];
  private static final int b1 = 1000;
  private static final int b2 = 1000;

  private int hash1(int key) {
    return key/b1;
  }

  private int hash2(int key) {
    return key%b2;
  }

  public MyHashSet() {
    arr = new boolean[b1+1][];
  }

  public void add(int key) {
    int v1 = hash1(key);
    int v2 = hash2(key);

    if(arr[v1]==null) {
      if(key == 1e6) {
        arr[v1] = new boolean[1];
        arr[v1][v2] = true;
      }
      else {
        arr[v1] = new boolean[b2];
        arr[v1][v2] = true;
      }
    }
    arr[v1][v2] = true;

  }

  public void remove(int key) {
    int v1 = hash1(key);
    int v2 = hash2(key);

    if(arr[v1] != null) {
      arr[v1][v2] = false;
    }

  }

  public boolean contains(int key) {
    int v1 = hash1(key);
    int v2 = hash2(key);

    if(arr[v1] != null) {
      return arr[v1][v2];
    }
    return false;

  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
