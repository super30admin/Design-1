/*

/*Complexity will O(n/k)
 * where n = number of keys we add
 * K is the size of bucket array we create 
 * Time Complexity  once collision occurs wont be considered as it will be less than O(n/k)
 * Space Complexity : O(n)
 * */
/*
public class designhashmap {
	class ListNode{
		int key,value;
		ListNode next;
		public ListNode(int key, int value) {
			// TODO Auto-generated constructor stub
			this.key=key;
			this.value=value;
		}
		
	}

	ListNode nodes[] = new ListNode[10000];
	
	void designhashmap() {
		
	}
	
	public void put(int key,int value) {
		int i =idx(key);
		if(nodes[i]==null)
			nodes[i]= new ListNode(-1,-1);
		ListNode prev = find(nodes[i],key);
		
		if(prev.next==null) {
			prev.next= new ListNode(key,value);
		}else {
			prev.next.value=value;
		}
		
	
		
		
	}
	
	public void remove(int key) {
		int i=idx(key);
		if(nodes[i]==null) return;
		ListNode prev = find(nodes[i],key);
	
		if(prev.next==null) return;
		prev.next=prev.next.next;
	}

	public int get(int key) {
		
		int i= idx(key);
	/*	if(nodes[i]==null)return -1;
		ListNode prev = find(nodes[i],key);
		
		if(prev==null)return -1;
		
		return prev.next==null ? -1 : prev.next.value;
		
	}
	
	
	public ListNode find(ListNode node,int key) {
		ListNode bucket=node,prev = null;
		int i = idx(key);
		while(bucket!=null && bucket.key!=key) {
			prev = bucket;
			bucket=bucket.next;
		}
		return prev;
		
	}
	
	public int idx(int key) {
		return Integer.hashCode(key)%nodes.length;
	}
	public static void main(String args[]) {
		designhashmap map = new designhashmap();
		map.put(1,1);
		map.put(12,51);
		map.put(13,18);
		map.put(13,1);
		map.remove(13);
		System.out.println(map.get(12));
	}
}*/
