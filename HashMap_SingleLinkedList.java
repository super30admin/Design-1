//hashmap implementation as single linked list refrence from LEETCODE SOLUTION.
//Reference https://leetcode.com/problems/design-hashmap/discuss/304270/My-Java-61ms-Solution-using-SLL-or-Beats-96
//Did not  understand in remove function why prev is initialize to null.

class HashMap_Sll {
   
	//array of singlelinked list
	ListNode[] bucket;

	//constructor
	HashMap_Sll() {
		bucket = new ListNode[16];
	}

   //put element key and value	 
	void put(int key, int value) {
		//fetch hash code from given key
		int hashCode = hash(key);
		ListNode node = bucket[hashCode];
		ListNode prev = node;
		//if node is null then creating new node with key and value.
	    if(node == null) {
	    	System.out.println("putting key:"+key);
	    	System.out.println("putting value:"+value);
	    	bucket[hashCode] = new ListNode(key,value);
	    	return;
	    }else {
	    	
	    	while(node!=null) {
	    		//if found element with same key then updating old value with new value.
	    		if(prev.key == key) {
	    			System.out.println("putting key:"+key);
	    	    	System.out.println("putting value:"+value);
	    			prev.value =  value;
	    			return;
	    		}
	    		prev =  node;
	    		node = node.next;
	    	}
	    	
	    }
	    if(node == null) {
	    	//checked at end of linked list -node is null
	    	System.out.println("putting key:"+key);
	    	System.out.println("putting value:"+value);
	    	if(prev.key == key) prev.value = value;
	    	prev.next = new ListNode(key,value);
	    }
	}

	//get element at key
	int get(int key) {
		System.out.println("gettting value of key ="+key);
		
		//fetch hashcode from given key
		int hashCode = hash(key);
		ListNode node = bucket[hashCode];
		ListNode prev =node;
		
		//if node is null then return -1
		if(node == null) {
			return -1;
			
		}
		
		while(node!=null) {
			//if found element with given key
			if(prev.key == key) {
				System.out.println("value is ="+prev.value);
				return prev.value;
			}
				prev = node;
				node = node.next;
		}
		//checked at end of linked list 
		if(node == null) {
			// if key is equal to key of element at end-1  
			if(prev.key == key) {
				System.out.println("value is ="+prev.value);
				return prev.value;
			}
			prev = node;
			node =node.next;
		}
		return 0;
		
	}

	//remove element at key
	void remove(int key) {
		int hashCode = hash(key);
		ListNode node = bucket[hashCode];
		ListNode prev =null;
		
		if(node!=null) {
			while(node.next!=null) {
				if(node.key == key) {
					if(prev == null) {
						bucket[hashCode] = node.next;
						System.out.println("removed key ="+key);
						return;
								
					}
					prev.next = node.next;
					System.out.println("removed key ="+key);
					return;
					
			    }
				prev = node;
				node = node.next;
				
		}
			
			
			if(node.key == key) {
				if(prev == null) {
					bucket[hashCode] = node.next;
					System.out.println("removed key ="+key);
					return;
				}
				prev.next = node.next;
				
			}
		
		}
		
	}
	
	//calculate hash value based on key 
	
	int hash(int key) {
		return Integer.hashCode(key)%bucket.length;
		
	}
}

//single linked list
class ListNode {
	int key;
	int value;
	ListNode next;

	ListNode(int k, int v) {
		this.key = k;
		this.value = v;
	}
}

// Driver code
class HashMap_SingleLinkedList {
	public static void main(String args[]) {
		HashMap_Sll map = new HashMap_Sll();
		map.put(1, 10);
		map.put(2, 20);
		map.put(3, 30);
		map.get(1);
		map.remove(1);

	}
}
