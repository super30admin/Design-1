
//Asymtomatic Time Complexity: O(1).
//Space Complexity: O(1)


class MyHashMap {

    class Node{
        int key;
        int val;
        Node next;

        public Node(int key, int value){

            this.key=key;
            this.val=value;

        }
    }

    Node[] storage;
    int bucket;
    public MyHashMap() {

        this.bucket=10000;
        this.storage = new Node[bucket];
    }

    private int hashIndex(int key){
        return key%bucket;
    }

    private Node find(Node head,int key){
        Node prev =null;
        Node current=head;

        while(current!=null && current.key!=key){
            prev=current;
            current=current.next;
        }

        return prev;
    }

    public void put(int key, int value) {

        int bucket = hashIndex(key);
        if(storage[bucket] == null){
            storage[bucket] = new Node(-1,-1);
        }
        Node prev = find(storage[bucket],key);
        if(prev.next==null){
            prev.next = new Node(key,value);
        }else{
            prev.next.val = value;
        }

    }

    public int get(int key) {
        int bucket = hashIndex(key);
        if(storage[bucket] == null){
            return -1;
        }else{
            Node prev = find(storage[bucket],key);
            if(prev.next == null){
                return -1;
            }else{
                return prev.next.val;
            }
        }
    }

    public void remove(int key) {
        int bucket = hashIndex(key);
        if(storage[bucket] == null){
            return;
        }else{
            Node prev = find(storage[bucket],key);
            if(prev.next==null){
                return;
            }else{
                prev.next = prev.next.next;
            }
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