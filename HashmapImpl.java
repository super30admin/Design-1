
public class HashmapImpl {
    
    class Node{
        int key;
        int value;
        Node next;
        
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    
    Node [] map;
    
    public HashmapImpl() {
        map = new Node[1000];
    }
    
    private Node findNode(int key){
        int hashKey = key%1000;
        
        Node head = map[hashKey];
        
        Node curr = head;
        Node prev = head;
        if(head == null){
            return null;
        }else{
            while(curr.next != null && curr.key != key ){
                prev = curr;
                curr= curr.next;
            }
        }
        return prev;
    }
    public void put(int key, int value) {
        
        int hashKey = key % 1000;
        Node temp = findNode(key);
        Node newNode = new Node(key,value);
        if(temp == null){
          
            map[hashKey]= newNode;
            return;
        } else {
            if(temp.key == key){
                temp.value = value;
            }else if( temp.next !=null && temp.next.key==key){
                temp.next.value= value;
            }else if(temp.next !=null){
                temp.next.next = newNode;
            }else{
                temp.next = newNode;
            }
        }
    }
    
    public int get(int key) {
        Node node = findNode(key);
        
        if(node!=null){
            if(node.key==key){
                return node.value;
            }
            
            if(node.next!=null && node.next.key== key){
                return node.next.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        Node node = findNode(key);
        if(node!=null){
            if(node.key== key){
                map[key%1000]= node.next;
                return;
            }
            if(node.next != null && node.next.key==key){
                node.next = node.next.next;
            }
        }
    }


}
