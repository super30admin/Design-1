Question 1)
class MyHashMap {
    public static final int length=10000;
   
    private class Node {
        int value, key;
        Node next;
        Node(int key, int value){
            this.key=key;
            this.value=value; 
        }
    }
    private Node[] a;
    public MyHashMap() {
       a= new Node[length];
        
        
    }
    private Node getprevNode(int key){
        int key1=key%10000;
        if(a[key1] == null){
           return null; 
            
        }
        Node prev=a[key1];
        Node curr=prev.next;
        while(curr!=null && curr.key != key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
    
    public void put(int key, int value) {
        Node prev= getprevNode(key);
        if(prev==null){
            int key1=key%10000;
            a[key1]=new Node(-1,-1); 
            prev=a[key1];
        }
        if(prev.next!=null){
            prev.next.value=value;
            
        }
        else{
            
            prev.next=new Node(key,value);
        }
        
    }
    
    public int get(int key) {
        Node prev=getprevNode(key);
        if(prev==null || prev.next==null){
            return -1;
            
        }
       
            return prev.next.value;
     
        
    }
    
    public void remove(int key) {
        Node prev=getprevNode(key);
        if(prev==null || prev.next==null){
            return ;
        }
       prev.next=prev.next.next;
        
        
    }
}
