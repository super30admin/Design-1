class MyHashMap {
    
    public static class Node{
        int key, value;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node[] head = new Node[10000];
    /** Initialize your data structure here. */
    public MyHashMap() {    
    }
    
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % head.length;
        if(head[index] == null){
            head[index] = new Node(key, value);
            return;
        }
        else{
            Node current = head[index];
            if(current.key == key){
                current.value = value;
                return;
            }
            while(current.next != null){
                if(current.next.key == key){
                    current.next.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = new Node(key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % head.length;
        if(head[index] == null){
            return -1;
        }
        else{
            Node current = head[index];
            while(current != null){
                if(current.key == key){
                    return current.value;
                }
                current = current.next;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % head.length;
        if(head[index] == null){
            return;
        }
        if(head[index].key == key){
            head[index] = head[index].next;
        }
        Node current = head[index], prev = head[index];
        while(current != null){
            if(current.key == key){
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
            
        
    }
}
