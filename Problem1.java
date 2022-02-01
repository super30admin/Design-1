class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;
    }

    Node(int key , int value) {
        this.key = key;
        this.value = value;

    }

    final Node[] nodes = new Node[10000];

    public MyHashMap() { }



    public void put(int key, int value) {

        int index = key % nodes.length ;

        Node entry = new Node(key, value);

        if()



    }

    public int get(int key) {

    }

    public void remove(int key) {

    }
}
