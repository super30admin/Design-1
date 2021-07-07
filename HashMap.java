class HashMap{
	
	/*
	 * Creating a Linked List class to handle collision scenario
	 */
	
	Node[] map;
	int len;
	
	class Node{
		int key;
		int val;
		Node next;
		
		//Initializing Node structure
		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			next = null;
		}
		
	}
	
	//Initializing the data structure
	public HashMap() {
		len = 100000;
		map = new Node[len];
	}
	
	/*
	 * Method to put values for specific keys
	 */
	public void put(int key, int value) {
		int hVal = hashing(key);
		if(map[hVal] == null) {
			map[hVal] = new Node(key, value);
		}
		else {
			Node curr = map[hVal];
            if(exists(hVal, key, value))
                return;
			while(curr.next != null) {
                if(exists(hVal, key, value))
                    return;
				curr = curr.next;
			}
			curr.next = new Node(key, value);
		}
	}
    
    /*
     * Method to check if key already exists
     */
    public boolean exists(int hVal, int key, int value) {
        Node curr = map[hVal];
        if(curr.key == key) {
            curr.val = value;
            return true;
        }
        return false;
    }
	
	/*
	 * Method to get the value of the specified key
	 */
	public int get(int key) {
		int hVal = hashing(key);
		if(map[hVal] != null) {
			Node curr = map[hVal];
			while(curr != null) {
				if(curr.key == key) {
					return curr.val;
				}
				curr = curr.next;
			}
		}
		
		return -1; //return -1 if no key if found
	}
	
	/*
	 * method to remove key, value pair from map
	 */
	public void remove(int key){
		int hVal = hashing(key);
		Node curr = map[hVal];
		Node prev = null;
		if(map[hVal] != null) {
			if(curr.next != null) {
				while(curr.next != null) {
					prev = curr;
					curr = curr.next;
				}
				prev.next = null;
			}
			else {
				map[hVal] = null;
			}
		}
		else {
			System.out.println("Key not found");
		}
	}
	
	/*
	 * hashing function
	 */
	public int hashing(int key) {
		return key%len;
	}
	
	public static void main(String[] args) {
		int val;
		HashMap hm = new HashMap();
		hm.put(1, 1);
		val = hm.get(1);
		System.out.println("Get result:"+val);
		hm.remove(1);
		hm.put(1, 10);
		val = hm.get(1);
		System.out.println("Get result:"+val);
		hm.put(10, 100);
		
		
	}
}

//Time Complexity : O(1) in most cases. If hashing function results in same bucket/index for 
//multiple keys, in that case it will be O(n) as we'll have to traverse the linked list 
//Space Complexity : O(n); n - > array size
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No