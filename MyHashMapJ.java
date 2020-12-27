class ListNodes{
    int key;
    int value;
    ListNode next;

    public ListNode(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMapJ{

    ListNodes[] nodes;
    private static final int SIZE = 10000;

    public MyHashMapJ(){
        this.nodes = new ListNodes[SIZE];
    }

    private int getIndex(int key){
        return Integer.hashCode()%SIZE;
    }

    private ListNode findElement(int key, int index){
        int index = getIndex(key);
        if (nodes[index] == null){
            return new ListNode(-1,-1);
        }
        else{
            ListNode prev = nodes[index];
            while (((ListNodes) prev).next!= null && ((ListNodes) prev).next.key!=key){
                prev = prev.next;
            }
            return prev;
        }
    }

    private void put(int key, int value){
        int index = getIndex(key);
        ListNode prev = findElement(key,index);
        if (prev.next == null){
            prev = new ListNode(key,value);
        }
        else{
            prev.next.val = value;
        }
    }

    private int get(int key){
        int index = getIndex(key);
        ListNode prev = findElement(key,index);
        return prev.next == null ? -1 : prev.next.val;
    }

    private void remove(int key){
        int index = getIndex(key);
        ListNode prev = findElement(key, index);
        if (prev.next == null){
            return;
        }
        else{
            prev.next = prev.next.next;
        }
    }
}