
// Time Complexity : 
// add, remove -> O(1)
// contains -> O(n)
// Space Complexity : O(n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.ArrayList;

public class MyHashSet {

  ArrayList<Integer> set = new ArrayList<>();

  public MyHashSet() {
  }

  public void add(int key) {
    if (!set.contains(key)) {
      set.add(key);
    }
  }

  public void remove(int key) {
    if (set.contains(key)) {
      set.remove(set.indexOf(key));
    }
  }

  public boolean contains(int key) {
    return set.contains(key);
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
