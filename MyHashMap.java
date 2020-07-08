class MyHashMap {

    private int MAX_SIZE = 1000000;
    Node[] nodes = new Node[MAX_SIZE];

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {

    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hashValue = getHash(key);
        Node prevNode = findElement(hashValue, key);
        saveElement(prevNode, key, value);
    }

    private int getHash(int key) {
        /*Bounding the key values*/
        return Integer.hashCode(key) % MAX_SIZE;
    }

    private Node findElement(int hashValue, int key) {
        Node bucket = nodes[hashValue];

        /*For no modes at the hash location*/
        if (bucket == null) {
            return null;
        }

        /*For one node at the hash location*/
        if(bucket.key == key){
            return bucket;
        }

        /*For many nodes at the hash location*/
        while (bucket.next != null && bucket.next.key != key) {
            bucket = bucket.next;
        }
        return bucket;
    }

    private void saveElement(Node prevNode, int key, int value) {
        Node newNode = new Node(key, value);
        if (prevNode == null || prevNode.key == key) {
            int index = getHash(key);
            nodes[index] = newNode;
            return;
        }

        if (prevNode.next == null) {
            prevNode.next = newNode;
            return;
        }

        if (prevNode.next.key == key) {
            prevNode.next = newNode;
        }
    }


    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = getHash(key);
        Node element = findElement(index, key);

        /*If no value is present at index*/
        if(element == null) return -1;

        /*If only one value is present at index*/
        if(element.key == key) return element.value;

        /*If value is not present in the hashmap*/
        if(element.next == null) return -1 ;
        return element.next.value;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = getHash(key);
        Node element = findElement(hash, key);
        if (element == null) return;
        if(element.key == key){
            nodes[hash] = null;
            return;
        }
        if (element.next == null) return;
        element.next = null;
    }
}

class Node {

    int key;
    int value;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
