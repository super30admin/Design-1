//TC : O(n) worst case for all get(), put(), remove() operations
//SC : O(n), n is the number of entries in a hashmap
// Did this code successfully run on Leetcode : Yes, 97% faster and 65% less memeory usage
// Any problem you faced while coding this : No
class MyHashMap
{

    //create an array of ListNodes with size as maximum possible values
    ListNode[] nodes = new ListNode[10000];



    public int get(int key)
    {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);

        //if prev.next is null that means element doesnt exist in map, hence return -1 else return the value
        return prev.next == null ? -1 : prev.next.val;
    }

    public void put(int key, int value)
    {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);

        //if prev.next is null that means the element does exist. Hence create a listNode and append it at the end.
        if (prev.next == null)
            prev.next = new ListNode(key, value);
            //else just update the value
        else
            prev.next.val = value;
    }

    public void remove(int key)
    {
        int index = getIndex(key);
        ListNode prev = findElement(index, key);

        //if the element exists then skips the element by modifying pointers
        if(prev.next != null)
            prev.next = prev.next.next;
    }

    private int getIndex(int key)
    {
        //hash function to return index
        return key % nodes.length;
    }

    private ListNode findElement(int index, int key)
    {

        //check whether a list exists for particular node index, if it doesnt then create one
        if(nodes[index] == null)
            return nodes[index] = new ListNode(-1, -1);

        ListNode prev = nodes[index];

        //traverse till the node that is just previous to the target node and return it
        while(prev.next != null && prev.next.key != key)
        {
            prev = prev.next;
        }
        return prev;
    }

    //use a class where each node contains a key-value pair
    private static class ListNode
    {
        int key, val;
        ListNode next;

        ListNode(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String args[]) {


        MyHashMap hashMap = new MyHashMap();

        hashMap.put(2,10);
        hashMap.put(3,15);
        hashMap.put(4,20);
        System.out.println("The value stored against key 3 is :"+hashMap.get(3));
        hashMap.remove(2);
        System.out.println("The key 2 doesnt exist :" + hashMap.get(2));
    }

    //Output :
    //The value stored against key 3 is :15
    // The key 2 doesnt exist :-1
}

