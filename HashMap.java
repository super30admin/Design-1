public class HashMap {
	ListNode[] nodes = new ListNode[10000];
	
	public class ListNode{
		int key,value;
		ListNode next;
		
		public ListNode(int key,int value) {
			this.key=key;this.value=value;
		}
	}
	
	public void add (int key, int value) {
		int i = index(key);
		if(nodes[i]==null) {
			nodes[i]= new ListNode(-1,-1);
		}
		
		ListNode prev = find(nodes[i],key);
		if(prev.next==null) {
			prev.next= new ListNode(key,value);
		}else {
			prev.next.value=value;
		}
		
		
	}
	
	public int get (int key) {
		int i = index(key);
		if(nodes[i]==null) {
			return -1;
		}
		ListNode prev = find(nodes[i],key);
		return prev.next==null ? -1: prev.next.value;
	}

	public void remove(int key) {
		int i = index(key);
		if(nodes[i]==null) return;
	    
		ListNode prev = find(nodes[i],key);
		if(prev.next==null) return;
		
		prev.next = prev.next.next;
	}
	
	int index(int key) {
		return Integer.hashCode(key)%nodes.length;
		
	}
	
	ListNode find(ListNode bucket, int key) {
		ListNode node = bucket;
		ListNode prev = null;
		while(node!=null && node.key!=key) {
			prev = node;
			node = node.next;
		}
		return prev;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 HashMap obj = new HashMap();
	      obj.add(1, 20);
	      System.out.println(obj.get(1));
	      obj.remove(1);
	      System.out.println(obj.get(1));
	}
}

