import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
public class HashMap
{
    class Node
    {
        int key, val;
        Node next;
        public Node (int key, int val)
        {
            this.key = key;
            this.val =val;
        }
    }
    Node[] hashmap;
    //constructor
    HashMap()
    {
        hashmap = new Node[15];
    }

    public void put(int key, int value)
    {   int index = getIndex(key);
        Node prev = getPreviousNode(index, key);

        //this returns nothing, but just add the key valu pair node to the index.
        //if it exists
        //if it doesn't exist
        if(prev.next == null)
        {
            Node node = new Node(key,value);
            prev.next = node;

        }
        else
        {
            prev.next.val = value;
        }
    }

    public int get(int key) // give key and get value from this helper function
    {
        int index = getIndex(key);
        Node prev = getPreviousNode(index, key);

        //if key exists
        if(prev.next.key == key)
        {
            System.out.println(prev.next.val);
            return prev.next.val;
        }
        else
        {
            System.out.println("No g key found.");
            return -1;
        }//if key deoesn't exist!

    }
    public void remove(int key)
    {
        int index = getIndex(key);
        Node prev = getPreviousNode(index, key);
        //this returns nothing and removes link to the node with the key given.

        //if key exists
        if(prev.next != null)
        {
            prev.next = prev.next.next;
        }
        else
        {
            System.out.println("Node Doesn't exists.");
        }
        //if key doesn't exists
    }

    //Helper Function
    private int getIndex(int key)
    {
        return Integer.hashCode(key%hashmap.length);
    }

    private Node getPreviousNode(int index, int key)
    {
        if(hashmap[index] == null)
        {
            hashmap[index] = new Node(-1,-1);
        }
        Node prev = hashmap[index];
        while (prev.next !=null && prev.next.key != key)
        {
            prev = prev.next;
        }
        return prev;
    }

}



