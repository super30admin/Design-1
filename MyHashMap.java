// Time Complexity : O(n) and can be reduced to O(1) with double hashing technique
// Space Complexity : O(n) and will become O(n^2) when double hashing technique is used
// so based on tradeoff between space and time, a decision can be used whether to use chaining or double hashing
// Did this code successfully run on Leetcode : yes

class MyHashMap {
    
    Node[] buckets;
    
    static class Node {
        int key;
        int value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
        
    }
    
    private int getHash(int key) {
        return key%100;
    }
    

    /** Initialize your data structure here. */
    public MyHashMap() {
        buckets = new Node[100];        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        Node newNode = new Node(key,value);
        Node prev = null;
        
        int hashValue = getHash(key);
        
        if(buckets[hashValue] == null) {
            buckets[hashValue] = newNode;
        }
        else{
            Node tmp = buckets[hashValue];
            while(tmp != null) {
                prev = tmp;
                if(tmp.key == key) {
                    tmp.value = value;
                    return;
                }
                tmp = tmp.next;
            }
            prev.next = newNode;

        }
        
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        int hashValue = getHash(key);
        
        if(buckets[hashValue] == null) {
            return -1;
        }
        else {
            Node tmp = buckets[hashValue];
            while(tmp != null) {
                if(tmp.key == key) {

                    return tmp.value;
                }
                tmp = tmp.next;
            }
            return -1;
            
        }
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashValue = getHash(key);
        
        if(buckets[hashValue] == null) {
            return;
        }
        else {
            Node tmp = buckets[hashValue];
            Node prev = tmp;
            
            if(tmp.key == key) {
               buckets[hashValue] = tmp.next;
               return;
            }
            else {
                tmp = tmp.next;
                while(tmp != null) {
                    
                    if(tmp.key == key) {
                        break;
                    }
                    else{
                        prev = tmp;
                        tmp = tmp.next;
                    }
                }
                
                if(tmp != null) {
                    prev.next = tmp.next;
                }
            }
            
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