class MyHashMap {

    /** Initialize your data structure here. */
    private static class node{
        int key, value;
        node next;
        node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    node[] head = new node[1000];

    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % head.length;
        if(head[index] == null){
            head[index] = new node(key,value);
            return;
        }
        else{
            node current = head[index];
            if(current.key == key){
                current.value = value;
                return;
            }
            while(current.next!=null){
                if(current.next.key == key){
                    current.next.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = new node(key,value);
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % head.length;
        if(head[index] == null){
            return -1;
        }
        else{
            node current = head[index];
            while(current!=null){
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
        node current = head[index], previous = head[index];
        while(current != null){
            if(current.key == key){
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }

    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        hashMap.get(1);            // returns 1
        hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        hashMap.get(2);            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        hashMap.get(2);            // returns -1 (not found)
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */