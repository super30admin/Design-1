class MyHashMap {

    final int NO_OF_BUCKETS = 16;

    class Node{
        int key;
        int value;

        Node next;

        Node() {

        }
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return key == node.key;
        }

    }

    Node[] nodes;

    public MyHashMap() {
        nodes = new Node[NO_OF_BUCKETS];
        for(int i = 0; i < NO_OF_BUCKETS;i++){
            nodes[i] = new Node();
        }
    }

    public void put(int key, int value) {
        int index = calculateIndex(key);
        Node head = insert(nodes[index], new Node(key, value));
        System.out.println("Node added successfully. Printing the list now");
        assert head != null;
        printList(head);
    }

    public int get(int key) {
        int index = calculateIndex(key);
        Node head = nodes[index];
        Node currentNode = head.next;

        while(currentNode != null && currentNode.key != key) {
            currentNode = currentNode.next;
        }

        if(currentNode != null) {
            System.out.println("Found the node. currentNode = " + currentNode);
            return currentNode.value;
        }

        return -1;
    }

    public void remove(int key) {
        int index = calculateIndex(key);
        Node head = delete(nodes[index], key);
        System.out.println("Node deleted successfully. Printing the list now");
        if(head != null) printList(head);
    }

    private Node insert(Node head, Node nodeToInsert) {
        if(isListNull(head)){
            System.out.println("This bucket is empty so far.");
            head.next = nodeToInsert;
        }else {
            System.out.println("This bucket is not empty.");
            Node tempNode = head.next;

            while(tempNode != null && tempNode.next != null) {
                if(tempNode.equals(nodeToInsert)){
                    System.out.println("Key already exists. So, updating it.");
                    tempNode.value = nodeToInsert.value;
                    return head;
                }
                tempNode = tempNode.next;
            }

            if(tempNode != null && tempNode.equals(nodeToInsert)) {
                System.out.println("Key already exists. So, updating it.");
                tempNode.value = nodeToInsert.value;
                return head;
            }

            tempNode.next = nodeToInsert;
        }
        return head;
    }

    private Node delete(Node head, int key) {
        if(isListNull(head)){
            System.out.println("key - " + key  + " was never added to the hashMap");
            return null;
        }else{
            Node prevNode = head;
            Node nextNode = head.next;

            while(nextNode != null && nextNode.key != key) {
                prevNode = prevNode.next;
                nextNode = nextNode.next;
            }

            if(nextNode != null) prevNode.next = nextNode.next;
            return head;
        }
    }

    private void printList(Node list) {
        if(isListNull(list)){
            System.out.println("No elements in this bucket");
            return;
        }

        Node tempNode = list.next;
        System.out.print("[ " + list.key + " , " + list.value + " ] -> ");
        while(tempNode != null) {
            System.out.print("[ " + tempNode.key + " , " + tempNode.value + " ] -> ");
            tempNode = tempNode.next;
        }
        System.out.println(" END ");
    }

    private boolean isListNull(Node head) {
        return null == head.next;
    }

    private int calculateIndex(int key) {
        return Integer.hashCode(key) & (NO_OF_BUCKETS - 1);
    }

    // Driver code here
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        for(Node node : obj.nodes) {
            System.out.println("node = " + node);
        }
        obj.put(0,0);
        obj.put(1,111);
        obj.put(2,222);
        obj.put(3,333);
        obj.put(4,444);
        obj.put(5,555);
        obj.put(6,666);
        obj.put(7,777);

        obj.put(2, 313);
        // Should append to the buckets created above
        obj.put(16,161616);
        obj.put(17, 171717);
        obj.put(18,181818);
        obj.put(19,191919);
        System.out.println("obj.get(5) = " + obj.get(5));
        obj.remove(6);
    }
}