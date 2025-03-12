//My Approach : Using LinkedList
// Created an array of 1000 nodes, where each node is the head of a linked list.
// Added elements based on their hash code and ensured no duplicates in the linked list.
// Removed elements by updating pointers and checked for existence by traversing the linked list.


// Time Complexity: O(1) average ,O(N) worst.
// Space Complexity: O(N)  
// Did this code successfully run on Leetcode? Yes  
// Any problems faced while coding this : 
// I was confused about updating `node[i] = dup.next` when removing the first element in the linked list.


public class MyHashSet 
{
    class Node 
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
            this.next = null; 
        }
    }
    int capacity;
    Node[] node;
    public MyHashSet() {
        this.capacity = 1000;
        node = new Node[1000];
    }
    
    public void add(int key) 
    {
        int i = key%capacity;
        if(node[i] == null)
        {
            node[i] = new Node(key);
        }
        else
        {
            Node dup = node[i];
            boolean b = false;
            if(dup.data == key)
            {
                b=true;
            }
            while(dup.next!=null)
            {
                if(dup.data == key)
                {
                    b = true;
                    break;
                }
                dup = dup.next;
                if(dup.data == key)
                {
                    b=true;
                    break;
                }
            }
            if(!b)
            {
                dup.next = new Node(key);
            }
        }
    }
    
    public void remove(int key) 
    {
        int i = key%capacity;
        if(node[i] != null)
        {
            Node dup = node[i];
            Node prev = null;
            while(dup!=null)
            {
                
                if(dup.data == key)
                {
                    if(prev == null)
                    {
                        node[i] = dup.next;
                        break;
                    }
                    else
                    {
                        prev.next = dup.next;
                        break;
                    }
                }
                else
                {

                prev = dup;
                dup= dup.next;
                }
            }
            
        }
    }
    
    public boolean contains(int key) {
        int i  = key%capacity;
        if(node[i] == null)
        {
            return false;
        }
        else
        {
            Node dup = node[i];
            while(dup!=null)
            {
                if(dup.data == key)
                {
                    return true;
                }
                dup = dup.next;
            }
        }
        return false;
    }
}


//My Approach : Using ArrayList
// The MyHashSet uses an array of ArrayLists to store multiple values in the same index.
// It adds, removes, and checks elements by hashing the key with key % capacity. 
// If the key exists, it is managed within the appropriate ArrayList.

/*

 class MyHashSet {
    int capacity;
    ArrayList<Integer>[] al;
    public MyHashSet() {
        this.capacity = 1000;
        al = new ArrayList[1000];
    }
    
    public void add(int key) {
        int i = key%capacity;
        if(al[i] == null)
        {
            al[i] = new ArrayList<>();
            al[i].add(key);
        }
        else if(!al[i].contains(key))
        {
            al[i].add(key);
        }
    }
    
    public void remove(int key) 
    {
        int i  = key%capacity;
        if(al[i] != null)
        {
            if(al[i].contains(key))
            {
                int j = al[i].indexOf(key);
                al[i].remove(j);
            }
        }
    }
    
    public boolean contains(int key) {
        int i  = key%capacity;
        if(al[i] == null)
        {
            return false;
        }
        else if(al[i].contains(key))
        {
            return true;
        }
        return false;
    }
}



//Approach: Using 2-D Array(Double Hashing)
// Use a 2D boolean matrix (mat[1001][1001]) to store keys, where i = key % 1000 and j = key / 1000.
// Add/Remove: Set mat[i][j] = 1 to add and mat[i][j] = 0 to remove.
// Contains: Check if mat[i][j] == 1 to verify existence.

/*
  class MyHashSet {
    int[][] mat;
    public MyHashSet() {
        mat = new int[1001][1001];
    }
    
    public void add(int key) {
        int i = key%1000;
        int j = key/1000;
        mat[i][j] = 1;
    }
    
    public void remove(int key) 
    {
        int i = key%1000;
        int j = key/1000;
        mat[i][j] = 0;
    }
    
    public boolean contains(int key) {
        int i = key%1000;
        int j = key/1000;
        if(mat[i][j]==1)
        {
            return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */