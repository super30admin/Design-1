//User has to specify the input range for this question 
//(to set for map[index] which will be out of range and will always act as previous node)
//Assume: key, value >= 0
//time complexity: O(1) average case
//worst case: O(n)

class Node{
	int key, value;
	Node next;
	Node(int key, int value){
		this.key = key;
		this.value = value;
		next = null;
	}
}
public class HashMap_706 {
	
	Node[] map;
	int capacity;
	
	HashMap_706(int capacity) {
		this.capacity = capacity;
		map = new Node[capacity];
	}
	
	public int hash_factory(int key) {
		return key%capacity;
	}
	
	// we return the node whose [ next node has KEY = key || whose next node is null]
	public Node search_key(Node node, int key) {
		Node prev = null;
		while(node != null && node.key != key) {
			prev = node;
			node = node.next;
		}
		return prev;
	}
	
	public void put(int key, int value) {
		int index = hash_factory(key);
		// index node will act as prev node for other node while traversing the list corresponding to index
		if(map[index] == null) {
			map[index] = new Node(-1, -1);
		}
		// look for the empty space or look for existing node with given key
		Node start_index = map[index];
		Node prev_node = search_key(start_index, key);
		if(prev_node.next == null) {
			prev_node.next = new Node(key, value);
		}
		else {
			prev_node.next.value = value;
		}	
	}
	
	public int get(int key) {
		int index = hash_factory(key);
		if(map[index] == null) {
			return -1;
		}
		Node start_index = map[index];
		Node prev_node = search_key(start_index, key);
		if(prev_node.next != null) {
			return prev_node.next.value;
		}
		return -1;
	}
	
	public void remove(int key) {
		int index = hash_factory(key);
		if(map[index] == null) {
			System.out.print("No node to remove");
			return;
		}
		Node start_index = map[index];
		Node prev_node = search_key(start_index, key);
		if(prev_node.next != null) {
			prev_node.next = prev_node.next.next;
		}
		else {
			System.out.print("Node with key doesn't exists");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int capacity = 10000;
		HashMap_706 hashmap = new HashMap_706(capacity);
		hashmap.put(1, 1000);
		hashmap.put(2, 2000);
		hashmap.put(3, 3000);
		System.out.println(hashmap.get(3));
		hashmap.remove(2);

	}

}


