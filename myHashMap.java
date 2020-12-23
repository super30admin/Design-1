public class myHashMap {
		private static int numOfBuckets = 1000;
		private node[] buckets = null;
	
	private static class node{
		int key;
		int value;
		node next;
	
	node(int key, int value){
		
		this.key = key;
		this.value = value;
		this.next = null;
	}
}
	public myHashMap() {
	buckets = new node[numOfBuckets];     	
	}
	
	public void put(int key, int value) {
	int index = hashFunc(key);
	node currentNode = buckets[index];
	if(buckets[index]== null) {
		buckets[index] = new node(key,value);
		return;
	}
	while(currentNode.next!= null) {
		if(currentNode.key == key) {
			currentNode.value = value;
			return;
		}
		currentNode = currentNode.next;
	}
	if(currentNode.key == key) {
		currentNode.value = value;
	}else {
		currentNode.next = new node(key,value);
	}
}
	
	public int get(int key) {
		int index = hashFunc(key);
		node currentNode = buckets[index];
		while(currentNode!=null){
			if(currentNode.key == key) {
				return currentNode.value;
			}
			currentNode = currentNode.next;
		}return -1;
	}
	
	public void remove(int key) {
		if(get(key) == -1) {
			return;
        }
	int index = hashFunc(key);
	node currentNode = buckets[index];
	node nextNode = buckets[index].next;
	if(buckets[index].key==key) {
		buckets[index]= buckets[index].next;
		return;
	}while(nextNode!=null) {
		if(nextNode.key == key) {
			currentNode.next= nextNode.next;
		}
	}
	}
	public int hashFunc(int key) {
		int hash = 0;
		return hash%64;
	}
	public static void main(String[] args) {
		myHashMap hashMap = new myHashMap();
		hashMap.put(1, 2);          
		hashMap.put(2, 3);         
		hashMap.get(1);            // returns 2
		hashMap.get(3);            // returns -1 (not found)
		hashMap.put(2, 4);          // update the existing value
		//System.out.println(hashMap.get(3));            // returns 4 
		System.out.println(hashMap.get(2));
		hashMap.remove(2);          // remove the mapping for 2
		//System.out.println(hashMap.get(2));            // returns -1 (not found)
	}
}
/**
 * Your MyHashMap object will be instantiated and called as such:
 * myHashMap obj = new myHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 
 */
