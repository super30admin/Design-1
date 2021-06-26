

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
        hashmap = new Node[10000];
    }

    public void put(int key, int value)
    {   int index = getIndex(key);
        Node prev = getPreviousNode(index, key);

        //this returns nothing, but just add the key valu pair node to the index.
        //if it exists
        //if it doesn't exist
        if(prev.next == null)
        {
            System.out.println("We are adding a new Node with key: "+key+ "  ,and value: "+value);

            Node node = new Node(key,value);
            prev.next = node;

            System.out.println("********");
        }
        else
        {
            System.out.print("Key already exists");
            prev.next.val = value;
            System.out.println("Value updated.");
        }


    }

    public int get(int key) // give key and get value from this helper function
    {
        int index = getIndex(key);
        Node prev = getPreviousNode(index, key);

        //if key exists
        if(prev.next.key == key)
        {
            System.out.println("Value is: "+prev.next.val);
            return prev.next.val;
        }
        else
        {
            System.out.println("Returning -1 ,No exisitng key found.");
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
            System.out.println("Node removed succefully. ");
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

class Main
{
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put(1,500);
       // map.remove(1);
       map.put(1,900);
        //map.remove(1);

        map.put(1,700);
        map.put(1,900);
        map.remove(2);

        map.get(1); //900
        map.put(1,1020);
        map.get(1); //1020

    }
}


/*
* SPace Complexity: O(1)
* Time Complexity: Node Removal,Node, get Value, updating Node adding =  O(n);
* Approach: by default every object is set null in array.
* when an index is found null, I intialize it and set to (-1,-1) - this  value os put of our input range.
* Now, to do any operation, such as Add, remove, update; we always need a previous node as a reference to update the values, and so
* I made a heper function of getting prev node. with that node I can refer to the next node of actual operation.
* Also, I am calculation Hashcode by key%map.length to get the values alloted to each of the indices.
*
* */