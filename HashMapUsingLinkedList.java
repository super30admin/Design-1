public class HashMapUsingLinkedList {
	Node head;
	class Node{
		int key;
		int value;
		Node next;
		
		Node(int key,int value){
			this.key=key;
			this.value=value;
		}
	}
	
	public void put(int key,int value) {
		Node temp = head;
		Node add = new Node(key,value);
		Node previous = null;
		
		if(temp==null) {
			head=add;
		}else {
			while(temp!=null) {
				previous=temp;
				  if(temp.key==key){
		                temp.value=value;
		                return;
		            } 
				temp=temp.next;
			}
			previous.next=add;
			
		}
	}
	
	public int get(int key) {
		Node temp=head;
		while(temp!=null) {
			if(temp.key==key) {
				return temp.value;
			}
			temp=temp.next;
			
		}
		return -1;
	}
	
	public void remove(int key) {
		Node temp=head;
		Node deleted = null;
		Node previous = null;
		if(temp==null) {
			return;
		}
		while(temp!=null) {
			if(temp.key==key) {
				deleted = temp;
				break;
			}
			previous = temp;
			temp=temp.next;
		}
		if(deleted==null) return;
		if(previous==null) {
			head=deleted.next;
		}else {
			previous.next=deleted.next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 HashMap obj = new HashMap();
	      obj.put(1, 20);
	      System.out.println(obj.get(1));
	      obj.remove(1);
	      System.out.println(obj.get(1));
	}

}
