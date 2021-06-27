//Time Complexity: Best Case:0(n/k) n: size of array; k : number of unique keys
// Space Complexity: O(n+k) n: size of array; k : number of unique keys
class MyHashMap {
    LinkedList<Node> []list;
    int size = 1769;
    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new LinkedList[size];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = key % size;
        Node newNode = new Node(key,value);
        if(list[bucket] == null){
            list[bucket] = new LinkedList<Node>();
            list[bucket].add(newNode);
        } else {
            for (Node node:list[bucket] ) {
                if( node.key == key){
                    node.value = value;
                    return;
                }
            }
            list[bucket].add(newNode);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = key % size;
        if(list[bucket] == null){
            return -1;
        } else{
            for (Node node:list[bucket] ){
                if( node.key == key){
                    return node.value;
                }
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Node nodeToRemove = null;
        int bucket = key % size;
        if(list[bucket] == null){
            return;
        } else{
            for (Node node:list[bucket] ){
                if( node.key == key){
                    nodeToRemove = node;
                }
            }
        }
        if(nodeToRemove == null){
            return;
        } else {
            list[bucket].remove(nodeToRemove);
        }
    }
}
class Node {
    public int key;
    public int value;
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */