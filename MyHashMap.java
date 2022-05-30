// average Time Complexity Find,Put,get,remove = O(1), Worst case = O(n)
// space complexity = O(n) - with the increase of the number of entries, the hashmap's space will increase linearly.
class MyHashMap {

class Node{
    int key;
    int val;
    Node next;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
        this.next=null;
    }
}

    int size=1000;
    Node[] arr;
    public MyHashMap() {
        arr= new Node[size];
    }

    public int hashFunc(int key){
        return key%1000;
    }

    public Node find(int key){
        int index = hashFunc(key);
        if(arr[index]==null){
            arr[index]=new Node(-1,-1);
            return arr[index];
        }
        Node head = arr[index];
        while(head.next!=null){
            if(head.next.key==key) return head;
            head=head.next;
        }
        return head;
    }

    public void put(int key, int value) {
        // int index = hashFunc(key);
       Node prev = find(key);
         if(prev.next==null){
             //Adding a new Node
             prev.next=new Node(key,value);
             return;
         }
        // updating exisiting node
        prev.next.val=value;

    }

    public int get(int key) {
       Node prev = find(key);
        if(prev.next != null && prev.next.key==key) return prev.next.val;
        return -1;
    }

    public void remove(int key) {
         // int index = hashFunc(key);
       Node prev = find(key);
        if(prev.next != null && prev.next.key==key){
            prev.next=prev.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */