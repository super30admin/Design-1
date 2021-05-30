public class MyHashMap {
    Node[] list;

    class Node{
        int val;
        public Node(int val){
            this.val = val;
        }
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
        //list = new Node[1000000];
        list = new Node[1000001]; //corrected after the comment
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node newNode = new Node(value);
        list[key] = newNode;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Node Node = list[key];
        if (Node != null)
            return Node.val;
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        list[key] = null;
    }
    public static void main(String args[])
    {
        MyHashMap obj = new MyHashMap();
        int key=0;
        int value=0;
        obj.put(key,value);
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(2));
        System.out.println();
        int param_2 = obj.get(key);
        obj.remove(key);
    }
}