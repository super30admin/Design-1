/**
 * Design a HashMap without using any built-in hash table libraries.
 * To be specific, your design should include these functions:
 * 		Follow up: How would you handle collisions in HashMap?
 * 		put(key, value) : Insert a (key, value) pair into the HashMap.
 * 						 If the value already exists in the HashMap, update the value.
 *		get(key): Returns the value to which the specified key is mapped,
 *					or -1 if this map contains no mapping for the key.
 *		remove(key) : Remove the mapping for the value key
 *					if this map contains the mapping for the key.
 *
 *
 * System.out.println("HashMap is a part of java.util package.");
 * System.out.println("HashMap doesn’t allow duplicate keys but allows duplicate values.");
 * System.out.println("HashMap allows null key also but only once and multiple null values.");
 * System.out.println("HashMap allows null key also but only once and multiple null values.");
 *
 */

class MyHashMap {

    //TEst comment

    boolean[] on = new boolean[1000001];
    int[] val = new int[1000001];
    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        on[key] = true;
        val[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (on[key]) return val[key];
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        on[key] = false;
    }
}

public class HashMp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * The following class is example with lot of space usage.
		 * Idea is simple , just used to arrays with input size here. One is the boolean array to store the keys
		 * and other one is store values.
		 */
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		System.out.println(hashMap.get(1));            // returns 1
		System.out.println(hashMap.get(3));            // returns -1 (not found)
		hashMap.put(2, 1);         					   // update the existing value
		System.out.println(hashMap.get(2));            // returns 1
		hashMap.remove(2);          			       // remove the mapping for 2
		System.out.println(hashMap.get(2));            // returns -1 (not found)
	}

}
