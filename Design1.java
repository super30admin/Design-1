// Time Complexity : O(k) -> no. of keys
// Space Complexity : O(K) -> no. of Keys
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Have to practice again for better understanding of BUCKET SIZE SELECTION + Substitute of PREV in remove func() +  remembering to add RETURN statement. 


// Your code here along with comments explaining your approach

public class Design1 {		
		
		static class LinkedListNode {	
			int key;
			int val;
			LinkedListNode next;
			
			LinkedListNode(int key,int val) {
				this.val = val;
				this.key = key;
			}
		}
		
		LinkedListNode[] nodeArray = new LinkedListNode[10000];
		
		Design1() {
			
		}
		
		public void put(int key, int val) {
			int index = key % nodeArray.length;
			/*IF bucket is empty, initialize it with new node*/
			if(nodeArray[index] == null) {
				nodeArray[index] = new LinkedListNode(key,val);
				return;
			}else {
				LinkedListNode curr = nodeArray[index];
				/*1->If key already exists at initial position*/
				if(curr.key==key) {
					curr.val= val;
					return;
				}
				/*2->If key is present but not at initial position, travel to the end of linkedlist of that bucket to insert new node at the end*/
				while(curr.next!=null) {
					if(curr.next.key==key) {
						curr.next.val = val;
					}
					curr = curr.next;
				}
				//Now we have traversed whole linked list and curr is at the end of LL
				/*3-> If no key found, create new entry at the end of linkedlist of that bucket*/
				curr.next = new LinkedListNode(key,val);
			}
		}

		public int get(int key) {
			int index = key % nodeArray.length;
			if(nodeArray[index]==null) {
				return -1;
			}else {
				LinkedListNode curr = nodeArray[index];
			
				while(curr!=null) {
					if(curr.key==key) {
						return curr.val;
					}
					curr = curr.next;
				}
			}
			return -1;

		}


		public void remove(int key) {
			int index = key % nodeArray.length;
			/*If bucket is null, return*/
			if(nodeArray[index]==null) {
				return;
			}
			
			if(nodeArray[index].key==key) {
				nodeArray[index] = nodeArray[index].next;
			}
			
			LinkedListNode curr = nodeArray[index];
			LinkedListNode prev = nodeArray[index];
			
			while(curr!=null) {
				if(curr.key==key) {
					prev.next = curr.next;
					return;
				}
				prev = curr;
				curr = curr.next;
			}
			
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Design1 hashMap = new Design1();
		hashMap.put(1, 2);          
		hashMap.put(2, 3);         
		hashMap.get(1);            // returns 2
		hashMap.get(3);            // returns -1 (not found)
		hashMap.put(2, 4);          // update the existing value
		hashMap.get(2);            // returns 4 
		hashMap.remove(2);          // remove the mapping for 2
		hashMap.get(2);            // returns -1 (not found)
	}

}
