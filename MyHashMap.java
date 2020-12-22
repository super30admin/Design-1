
//using array of linklist because it helps to reduce space complexity.Although it takes more time than array still it's much more efficient.
public class MyHashMap
{
	//ListNode[] nodes = new ListNode[10000];
	Node[] nodes=new Node[1000];
	public int get(int key)
	{
		int index = getIndex(key);
		Node findnode = findElement(index, key);
		return findnode.val;
	}
	
	public void put(int key, int value)
	{
		int index = getIndex(key);
		if(nodes[index]==null) {
		
		nodes[index]=new Node(key, value);
			nodes[index].next=null;
			System.out.println("value inserted"+nodes[index].val);
			}
		else {
			Node node1=findElement(index, key);
			node1.val = value;
			System.out.println("value inserted updated"+node1.val);
		}
	}

	public void remove(int key)
	{
		int index = getIndex(key);
		Node node=nodes[index];
		System.out.println("node key"+node.key);
		if(node.key==key) {
			node.val=-1;
			//System.out.println("node.key"+node.key+"node.val"+node.val);
		}
		else
		{
			Node current = findPreviousElement(index, key);
			if(current.next != null)
		    current.next = current.next.next;
		}
	}

	private int getIndex(int key)
	{
		
		return Integer.hashCode(key) % nodes.length;
	}

	private Node findPreviousElement(int index, int key)
	{
		Node node=nodes[index];
		while(node.key!=key)
			node=node.next;
		return node	;
	}

	
	private Node findElement(int index, int key)
	{
		if(nodes[index] == null)
			return nodes[index] = new Node(-1, -1);
		Node node=nodes[index];
		System.out.print("key"+node.key+"val"+node.val);
		while(node.key!=key && node!=null)
			node=node.next;
		return node;
	}
	 public static void main(String [] args) 
	    { 
	       MyHashMap hashMap = new MyHashMap(); 
	       hashMap.put(1, 1);          
	       hashMap.put(2, 2);
	       hashMap.put(3, 6);
	       hashMap.put(4, 8);
	       hashMap.put(5, 10);
	       
	       
	     //  hashMap.put(2, 3);
	      hashMap.remove(4);
	       System.out.print("node getting"+hashMap.get(4));
	         
	    } 
	private static class Node
	{
		int key, val;
		Node next;

		Node(int key, int val)
		{
			this.key = key;
			this.val = val;
		}
	}
}