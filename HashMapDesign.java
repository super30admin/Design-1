public class HashMapDesign {
    
    class Node {
        int key;
        int value;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] nodes;

    public HashMapDesign () {
        nodes = new Node[1000];
    }

    private int getHashedIndex(int key) {
        return key % nodes.length;
    }

    public void put(int key, int value) {
        Node temp = new Node(key, value);
        int index = getHashedIndex(key);
        if(checkBase()) {
            nodes[index] = temp;
            return;
        }
        Node currentNode = nodes[index];
        while(currentNode.next!=null && currentNode.key!=key) {
            currentNode = currentNode.next; 
        }
        currentNode.next = temp;
    }

    public void remove(int key) {
        if(checkBase()) {
            System.out.println("Failed to remove the element from the hashmap");
            return;
        }
        int index = getHashedIndex(key);
        if(nodes[index] == null) {
            System.out.println("Failed to remove the element from the hashmap");
            return; 
        }
        Node currentNode = nodes[index];
        if(currentNode.key == key) {
            nodes[index] = null;
            return;
        }
        boolean isFound = false;
        Node nextNode =  currentNode.next;
 
        while(currentNode!=null) {
            nextNode = currentNode;
            if(nextNode.key == key) {
                isFound = true;
                return;
            }
            currentNode = currentNode.next;
        }

        if(isFound) {
            currentNode.
        } else {
            System.out.println("Failed to remove the element from the hashmap");
            return; 
        }
    }

    private boolean checkBase() {
        return nodes.length >0;
    }

}
