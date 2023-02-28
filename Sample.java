// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

import com.sivakami.ds.implementation.hashSet.*;

public class Sample {
	public static void main(String[] args) {		
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);         
		hashSet.add(2);         
		hashSet.contains(1);    // returns true
		hashSet.contains(3);    // returns false (not found)
		hashSet.add(2);          
		hashSet.contains(2);    // returns true
		hashSet.remove(2);          
		hashSet.contains(2);    // returns false (already removed)
	}
}
