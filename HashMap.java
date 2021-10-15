class Node{
    Node next;
    int val;
    int key;
    public Node(int key, int val){
        this.next = null;
        this.val = val;
        this.key = key;

    }
}

class MyHashMap {
    Node[] map;
    public MyHashMap() {
        map = new Node[2069];
    }

    public void put(int key, int value) {
        if(map[key%2069] == null){
            map[key%2069] = new Node(key, value);
            return;
        }
        Node head = map[key%2069];
        while(head.next!=null){
            if(head.key == key){
                head.val = value;
                return;
            }
            head = head.next;
        }
        if(head.key == key){
            head.val = value;
            return;
        }
        head.next = new Node(key,value);
    }

    public int get(int key) {
        if(map[key%2069] == null){
            return -1;
        }
        Node head = map[key%2069];
        while(head!=null){
            if(head.key == key){
                return head.val;
            }
            head = head.next;
        }
        return -1;
    }

    public void remove(int key) {
        if(map[key%2069] == null){
            return;
        }
        Node head = map[key%2069];
        if(head.key==key){
            map[key%2069] = head.next;
            return;
        }
        while(head.next!=null && head.next.key!=key){
            head = head.next;
        }
        if(head.next!=null && head.next.key == key){
            head.next = head.next.next;
        }
        return;

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */