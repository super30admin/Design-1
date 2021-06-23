// Time complexity : O(1) for get(), put(), remove()
// Space Complexity : O(n)


import java.util.Scanner;

public class MyHashMap {
    
    class Node {
        int key;
        int val;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    Node[] nodes;
    int capacity = size();
   
    public MyHashMap() {
        nodes = new Node[capacity];
    }
  
   public static int size(){
    Scanner giveInput = new Scanner(System.in);
    System.out.println("Enter capacity of Hashmap:");
    int capacity = giveInput.nextInt();
    return capacity;
   }
   
   public void put(int key, int value) {
        Node prevNode = find(key);
        if (prevNode.next == null)
            prevNode.next = new Node(key, value);
        else
            prevNode.next.val = value;
    }

    public int get(int key) {
        Node currentNode = find(key).next;
        int data = (currentNode == null ? -1 : currentNode.val);
        System.out.println(data);
        return data;
    }

    public void remove(int key) {
        Node prevNode = find(key);
        if (prevNode.next != null)
            prevNode.next = prevNode.next.next;
    }
    
    public Node find(int key) {
        int id = key % capacity;
        if (nodes[id] == null)
            nodes[id] = new Node(-1, -1);
        Node prevNode = nodes[id];
        while (prevNode.next != null && prevNode.next.key != key)
        prevNode = prevNode.next;
        return prevNode;
    }
   
    
    public static void main(String[] args){
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 2);          
        hashMap.put(2, 3);         
        hashMap.get(1);            // returns 2
        hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 4);          // update the existing value
        hashMap.get(2);            // returns 4 
        hashMap.remove(2);          // remove the mapping for 2
        hashMap.get(2);            // returns -1 (not found)

    }
}
