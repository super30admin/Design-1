/**Time Complexity: O(1) 
 * Space Complexity: O(n) **/
public class MyHashMap {
	class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key= key;
            this.val= val;
        }
    }    
    
    private Node[] nodes;
    private int buckets;    
	
	public MyHashMap() {		
	    buckets= 10000;
        nodes= new Node[buckets];
	}
    
    private int hash(int key){
        //return Integer.hashCode(key)%buckets;
        return key%buckets;
    }
    
    public Node find(Node head, int key){
        Node prev= null;
        Node curr= head;
        while(curr != null && curr.key != key){
            prev= curr;
            curr= curr.next;
        }
        return prev;
    }

	public void put(int key, int value) {	
        //check if that ele is there in hashmap
		int index= hash(key);
        if(nodes[index] == null){
            nodes[index] = new Node(-1,-1);
        }
        Node prev= find(nodes[index], key);
        //prev is at the end of linked list
        if(prev.next == null){
            prev.next= new Node(key, value);
        }else{ //not at end
            prev.next.val= value;            
        }        
	}

	public int get(int key) {
		int index= hash(key);
        if(nodes[index] == null) return -1;
        Node prev= find(nodes[index], key);       
        if(prev.next == null) return -1;
        return prev.next.val;
	}

	public void remove(int key) {
		int index= hash(key);
        if(nodes[index] == null) return;
        Node prev= find(nodes[index], key);
        if(prev.next == null) return ;
        prev.next= prev.next.next;
	}
}
