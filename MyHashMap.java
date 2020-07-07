package Design1;

public class MyHashMap {

	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 2);          
		hashMap.put(2, 3);         
		System.out.println("Get 1 " +hashMap.get(1));            // returns 2
		System.out.println("Get 3 " +hashMap.get(3));            // returns -1 (not found)
		hashMap.put(2, 4);          // update the existing value
		System.out.println("Get 2 " +hashMap.get(2));             // returns 4 
		hashMap.remove(2);          // remove the mapping for 2
		System.out.println("After removing 2 " +hashMap.get(2));           // returns -1 (not found
	}
	
	class ListNode{
		int key;
		int value;
		ListNode next;
		
		ListNode(int key,int value){
			this.key = key;
			this.value = value;
			
		}
		
	}

	 ListNode myHashMap [] = new ListNode[100000];
	
	
	private int hashFunction(int key) {
		return Integer.hashCode(key)%myHashMap.length;
	}
	
	//helper function to search the element
	private ListNode findElement(int index ,int key) {

		index = hashFunction(key);
		//initialize
		if(myHashMap[index] == null) {
			myHashMap[index] = new ListNode(-1,-1);
			return myHashMap[index];
			/*ListNode current = new ListNode(-1,-1);
			return current;  doesnt point to any thing hence always gives -1*/
		}
		else {

			ListNode current = myHashMap[index];
			while(current.next != null && current.next.key != key) {
				current = current.next;
			}

			return current;
		}		

	}
	
	
	public int get(int key)	{
		int index = hashFunction(key);
		ListNode previous =findElement(index,key);

		if(previous.next != null)
			return previous.next.value;
		else
			return -1;
	}

	public void remove(int key) {
		int index = hashFunction(key);
		ListNode previous =findElement(index,key);

	/*	if(previous.next == null)
			return;
		else*/
		if(previous.next != null) {
			previous.next = previous.next.next;
	}
		return;
	}
	public void  put(int key,int value) {
		int index = hashFunction(key);
		ListNode previous =findElement(index,key);
		
		//override value with same key
		if(previous.next != null) {
			previous.next.value = value;
		}
		else 
			previous.next  = new ListNode(key,value);				
	}
	
}
// Used separate chaining. Linked list of records to avoid collision 
//Space: O(1)
//Time: O(1)

/*Get 1 2
Get 3 -1
Get 2 4
After removing 2 -1
 *  */