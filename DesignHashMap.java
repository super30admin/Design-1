public class DesignHashMap {

    private ListNode[] nodes;

    class ListNode {
        int key, value;
        ListNode next;
   

    ListNode(final int key, final int value) {
        this.key = key;
        this.value = value;
    }
}

    private DesignHashMap(){
        nodes = new ListNode[10000];
    }

    public void put(final int key, final int value) {
         int index = getIndex(key);
         ListNode previous = find(index, key);
        if (previous.next != null) {
            previous.next.value = value;
        } else {
            previous.next = new ListNode(key, value);
        }

    }

    public int get(final int key) {
         int index = getIndex(key);
         ListNode previous = find(index, key);
        if (previous.next != null) {
            return previous.next.value;
        }
        return -1;
    }

    public void remove(final int key) {
         int index = getIndex(key);
         ListNode previous = find(index, key);
        if(previous.next!=null){
            previous.next = previous.next.next;
        }
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }
    

    private ListNode find(int index, int key) {
        if (nodes[index] == null) {
            nodes[index] = new ListNode(-1, -1);
            return nodes[index];
        }

        ListNode previous = nodes[index];
        while (previous.next != null && previous.next.key != key) {
            previous = previous.next;
        }
        return previous;
    }

    public static void main(String[] args) {
        DesignHashMap hashMap = new DesignHashMap();
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