import java.util.Arrays;

//Time Complexity : O(n)
//Space Complexity : O(n)
// It did run successfully on Leetcode
// Problems :  As i'm not using a previous pointer in linked list, i could'nt remove first node
//Solution of the problem : i had to have a base pointer with key and value -1,-1




/* Here i'm initializing an array of linked list as my base data structure
In the case of collision a new node will be generated in the linked list*/
public class MyHashMap {
    private Node[] buckets;
    class Node
    {
        int key;
        int value;
        Node nextnode;
        Node(int key,int value)
        {
            this.key = key;
            this.value = value;
            this.nextnode = null;
        }

    }
    public MyHashMap() {
        buckets= new Node[10000];
        Arrays.fill(buckets,null);
    }
    public void put(int key, int value) {
        Node newNode = new Node(key,value);
        int hashkey = key%10000;
        if(buckets[hashkey]==null)
        {
            buckets[hashkey] = new Node(-1,-1);
            Node temp = buckets[hashkey];
            temp.nextnode = newNode;
        }
        else
        {
            Node temp = buckets[hashkey];
            while(temp.nextnode!=null)
            {
                if(temp.nextnode.key == key)
                {
                    temp.nextnode.value = value;
                    return;
                }
                temp = temp.nextnode;
            }
            temp.nextnode = newNode;
        }
    }
    public int get(int key) {
        int hashkey = key % 10000;
        if(buckets[hashkey]==null)
        {
            return -1;
        }
        else
        {
            Node temp = buckets[hashkey];
            while(temp!=null)
            {
                if(temp.key == key)
                {
                    return temp.value;
                }
                else temp = temp.nextnode;
            }
        }
        return -1;
    }
    public void remove(int key) {
        int hashkey = key%10000;
        Node temp = buckets[hashkey];
        if(temp==null)return;
        else {
            while (temp.nextnode!=null)
            {
                if(temp.nextnode.key == key)
                {
                    temp.nextnode = temp.nextnode.nextnode;
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));            // returns 1
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2));            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));

        //Khushal was here

    }
}
