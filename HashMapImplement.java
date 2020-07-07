// Time Complexity : Amortized O(1) for put, get and remove
// Space Complexity : O(n) where n is number of element in th hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : for get(-8) i faced problem while handling it, but figured out the way


public class HashMapImplement {
    class ListNode
    {
        //creating structure for each listnode
        int val;
        int key;
        ListNode next;

        ListNode(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    // using array of linkedlist to implement hashmap
    ListNode[] map;
    public HashMapImplement() {
        map = new ListNode[10000];
    }
    public void put(int key, int value) {
        int index = getIndex(key); // gets the index
        ListNode valNode = findElement(index, key); // goes to the index and finds key
        if(valNode.next == null)
        {
            valNode.next = new ListNode(key, value);//if empty will insert this value
        }
        else
        {
            valNode.next.val = value;//if already present will over write the value
        }

    }
    public int get(int key) {
        int index = getIndex(key);// gets the index
        ListNode valNode = findElement(index, key);// goes to the index and finds key
        if(valNode == null) return -1; // for cases where index goes out of bound ex. get(-8)
        if(valNode.next == null){ // for cases where element was not found ex.get(8)
            return -1;
        }
        else{
            return valNode.next.val; //if found will return its value
        }

    }
    public void remove(int key) { // for removal of key,val
        int index = getIndex(key);// gets the index
        ListNode valNode = findElement(index, key);// goes to the index and finds key
        //if null we cannot remove it so we will do nothing
        if(valNode.next != null)
        {
            //if present the present node will now point to the next of its next
            valNode.next = valNode.next.next;
        }

    }
    public int getIndex(int key)
    {
        if(key < 0)// for out of bound case
        {
            return -1;
        }
        return Integer.hashCode(key) % 10000;// for others will return the index
    }
    public ListNode findElement(int index, int key)
    {
        if(index == -1) // for out of bound case
        {
            return null;
        }
        if(map[index] == null){//if the index is empty
            return map[index] = new ListNode(-1,-1);
        }
        ListNode prev = map[index];
        while(prev.next != null && prev.next.key != key)// if index is not emty we will go till the end
        {
            prev = prev.next;
        }
        return prev;
    }
    public static void main(String args[])
    {
        HashMapImplement obj = new HashMapImplement();
        obj.put(1,10);
        System.out.println("Inserted 1 -> 10");
        obj.put(2,3);
        System.out.println("Inserted 2 -> 3");
        obj.put(1,20);
        System.out.println("Inserted 1 -> 20");
        obj.put(3,8);
        System.out.println("Inserted 3 -> 8");
        obj.put(4,9);
        System.out.println("Inserted 4 -> 9");
        
        int param_1 = obj.get(1);
        System.out.println("get(1) is "+param_1);
        obj.remove(1);
        System.out.println("removed key 1");
        int param_2 = obj.get(2);
        System.out.println("get(2) is "+param_2);

        int param_3 = obj.get(-8); // get of anything invalid
        System.out.println("get(-8) is "+param_3);
        int param_4 = obj.get(8); // get of anything not present
        System.out.println("get(8) is "+param_4);


       
    }
}