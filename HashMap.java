// o(1) for put and get opearations
// o(n) space complexity
//passed all test cases in leetcode
//a hash function is used to generate hash for the given key and result is index for key in a list of nodes

class MyHashMap {

    final double load_factor = 0.9;
    List<Node>[] map1;
    int size;
    int presentSize;

    /** Initialize your data structure here. */
    public MyHashMap() {
        size = 10;
        presentSize = 0;
        map1 = new List[size];
        for(int i = 0; i < size; i++) {
            map1[i] = new LinkedList<>();
        }

    }

    private int hash(int key){
        key = (key + size + 13) * 53;
        return key % size;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        resize();

        int index = hash(key);
        List<Node> list = map1[index];
        Node found = getNode(key);
        if(found != null) {
            found.val = value;
        } else {
            list.add(new Node(key, value));
            presentSize ++;
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Node present = getNode(key);
        if(present!=null){
            return present.val;
        }
        return -1;
    }

    private Node getNode(int key) {
        Node found = null;
        int index = hash(key);
        List<Node> list = map1[index];
        for(Node n: list) {
            if(key == n.key) {
                found = n;
                break;
            }
        }
        return found;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Node found = null;
        int index = hash(key);
        List<Node> list = map1[index];
        for(Node n: list) {
            if(key == n.key) {
                found = n;
                break;
            }
        }
        if(found != null) {
            list.remove(found);
        }

    }
    public void resize(){
        if(presentSize / size < load_factor) return;
        int oldSize = size;
        size *= 2;
        List<Node>[] map2 = new List[size];
        for(int i = 0; i < size; i++) {
            map2[i] = new LinkedList<>();
        }
        for(int i = 0; i < oldSize; i++) {
            List<Node> list = map1[i];
            for(Node node: list) {
                int index = hash(node.key); // rehash
                List<Node> list2 = map2[index]; // reput
                Node found = null;
                for(Node node2: list2) {
                    if(node2.key == node.key) {
                        found = node2;
                        break;
                    }
                }
                if(found != null) {
                    found.val = node.val;
                } else {
                    list2.add(node);
                }
            }
        }
        map1 = map2;

    }

    class Node {
        int key;
        int val;
        Node(int _key, int _val) {
            key = _key;
            val = _val;
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