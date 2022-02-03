/**

collision is resolved using Linear Chaining approach.

// Time Complexity :
    put - O(n) in the worst case if collision occurs
	get - O(n) in the worstcase if the collision occurs and node is not the head node in the list.
	remove - O(n) in the worstcase if the collision occurs and node is not the head node in the list.
// Space Complexity : Array of list O(m) * O(n) where m is the array size and n is the size of list at each index in the array. Overall O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No    
**/

class MyHashMap {
    
    private class Node {
        int key, value;
        Node next;
        
        Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    
    private Node[] arr;
    private static int MAX_LENGTH = 10000;

    public MyHashMap() {
        arr = new Node[MAX_LENGTH];
    }
    
    
    private int getHashKey(int key)
    {
        return key % MAX_LENGTH;
    }
    
    public void put(int key, int value) {
        
        int hashedKey = getHashKey(key);
        
        if (arr[hashedKey] == null)
        {
            arr[hashedKey] = new Node(key, value);
            return;
        }
        
        Node current = arr[hashedKey];
        
        while(current != null)
        {
            
            if (current.key == key)
            {
                current.value = value;
                return;
            }
            
            current = current.next;
        }
       
        current = new Node(key,value);      
    }
    
    public int get(int key) {
        
        int hashedKey = getHashKey(key);
        
        if (arr[hashedKey] == null)
        {
            return -1;
        }
        
        Node current = arr[hashedKey];
        
        while(current != null)
        {
            if (current.key == key)
            {
                return current.value;
            }
            
            current = current.next;
        }
        
        
        return -1;
    }
    
    public void remove(int key) {
        
        int hashedKey = getHashKey(key);
        
        Node current = arr[hashedKey];
        
        if (current != null && current.key == key)
        {
            arr[hashedKey] = current.next;
            return;
        }
        
        while(current != null && current.next != null)
        {
            if (current.next.key == key)
            {
                current.next = current.next.next;
            }
            
            current = current.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */