class HashMap()
{

    private class Node{
        int key;
        int value;
        Node next;

        Node(int key , int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    private static final int NUM_BUCKETS= 10000;
    private Node[] buckets;
    public MyHashMap()
    {
        buckets = new Node[NUM_BUCKETS];
    }
    private Node findPrev(int key)
    {
        int hash = getHash(key);
        if(buckets[hash] == null)
        {
            return null;
        }
        Node prev = buckets[hash]; //dummy
        Node curr = prev.next;

        while(curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;

    }
    public int getHash(int key)
    {
        return key%10^4;
    }

    public void put(int key , int value)
    {
        Node prev = findPrev(key);
        if(prev == null)
        {
            int hash = getHash(key);
            buckets[hash] = new Node(-1, -1); //dummy
            prev = buckets[hash];
        }

        //if exists update

        if(prev.next != null)
        {
            prev.next.value = value;
        }
        else
        {
            prev.next = new Node(key,value);
        }
    }

    public int get(int key)
    {
        Node prev = findPrev(key);
        if(prev == null || prev.next ==null)
        {
            return -1;
        }
        return prev.next.value;
    }


    public void remove (int key)
    {
        Node prev = findPrev(key);
        if(prev == null || prev.next == null)
        {
            return;
        }
        prev.next = prev.next.next;
    }
}