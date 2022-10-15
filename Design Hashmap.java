// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashMap {

    private class Node{
        int key;
        int value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private static final int BUCKET_SIZE = 10000;
    private Node[] arr;

    public MyHashMap() {
        arr = new Node[BUCKET_SIZE];    
    }
    
    public int getHash(int key){
        return key%BUCKET_SIZE; 
    }

    private Node getPrev(int key){
        int hash = getHash(key);

        if(arr[hash] == null){
            return null;
        }

        Node prev = arr[hash];
        Node curr = prev.next;

        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        
        Node prev = getPrev(key);

        //if key is not present
        if(prev == null){ 
            int hash = getHash(key);
            arr[hash] = new Node(-1, -1);
            prev = arr[hash];
        }

        //tail node
        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else{
            prev.next.value = value;
        }

    }
    
    public int get(int key) {
        Node prev = getPrev(key);
        if(prev == null || prev.next == null){
            return -1;
        }
        return prev.next.value;
    }
    
    public void remove(int key) {
        Node prev = getPrev(key);
        if(prev !=null  && prev.next != null){
             prev.next = prev.next.next;

        }
    }
}