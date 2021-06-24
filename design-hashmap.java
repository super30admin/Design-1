/*
Uses a method called seperate chaining
Time complexity - O(L) where L is the size of the linked list
Space complexity - O(N+K) where N is the size of array and K is the number of keys
*/
class MyHashMap 
{
    class Node {
        int key;
        int value;
        Node next;
        
        public Node(int key,int value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }
    
    private Node[] items;
    
    public MyHashMap() {
        items = new Node[10000];
    }
    
    public void put(int key, int value) {
        int hashValue = getHashCode(key);
        
        if(items[hashValue] == null){
            items[hashValue] = new Node(key,value);
        } else {
            Node tmpNode = items[hashValue];
            
            if(tmpNode.key == key){
                tmpNode.value = value;
            } else {
                while(tmpNode.next != null){
                    tmpNode = tmpNode.next;
                    
                    if(tmpNode.key == key){
                        tmpNode.value = value;
                        return;
                    }
                }
                
                tmpNode.next = new Node(key,value);
            }
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashValue = getHashCode(key);
        
        if(items[hashValue] != null){
            Node tmpNode = items[hashValue];
            
            if(tmpNode.key == key)
                return tmpNode.value;
            
            while(tmpNode.next != null){
                tmpNode = tmpNode.next;
                
                if(tmpNode.key == key)
                    return tmpNode.value;
            }
        } 
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashValue = getHashCode(key);
        
        if(items[hashValue] != null){
            Node tmpNode = items[hashValue];
            
            if(tmpNode.key == key){
                items[hashValue] = tmpNode.next;
                return;
            }
            
            while(tmpNode != null && tmpNode.next != null){
                if(tmpNode.next.key == key){
                    tmpNode.next = tmpNode.next.next;
                    return;
                }
                
                tmpNode = tmpNode.next;
            }
        } 
    }
    
    private int getHashCode(int key){
        return Math.abs(key%9999);
    }
}