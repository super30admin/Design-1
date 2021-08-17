// Problem1

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I had to use LinkedList. Could not make the array logics work well enough.

class MyHashMap {
    
    class Entry {
		public int key;
		public int val;

		public Entry(int key, int val){
			this.key = key;
			this.val = val;
		}
	}

    LinkedList<Entry>[] map;
	public static int SIZE = 1000;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new LinkedList[SIZE];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = key % SIZE;
			if(map[bucket] == null) {
				map[bucket] = new LinkedList<Entry>();
				map[bucket].add(new Entry(key, value));
			}
			else {
				for(Entry entry : map[bucket]){
					if(entry.key == key){
						entry.val = value;
						return;
					}
				}
				map[bucket].add(new Entry(key, value));
			}
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = key % SIZE;
			LinkedList<Entry> entries = map[bucket];
			if(entries == null) {
                return -1;
            }
			for(Entry entry : entries) {
				if(entry.key == key) return entry.val;
			}
			return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = key % SIZE;
			Entry toRemove = null;
			if(map[bucket] == null) return;
			else {
				for(Entry entry : map[bucket]){
					if(entry.key == key) {
						toRemove = entry;
					}
				}
				if(toRemove == null) return;
				map[bucket].remove(toRemove);
			}
    }
}


// Problem2

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {

    Stack<Integer> regStack = new Stack<Integer>();
    Stack<Integer> trackStack = new Stack<Integer>();
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(trackStack.isEmpty() || val <= trackStack.peek()) {
            trackStack.push(val);
        }
        regStack.push(val);
    }
    
    public void pop() {
        if(regStack.peek().equals(trackStack.peek())) {
            trackStack.pop();
        }
        regStack.pop();
    }
    
    public int top() {
        return regStack.peek();
    }
    
    public int getMin() {
        return trackStack.peek();
    }
}
