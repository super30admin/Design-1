
class MyHashMap {

    /** Initialize your data structure here. */
    public class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public int capacity;
    public Node[] hashTable;
    public MyHashMap() {
        capacity = 10;
        hashTable = new Node[capacity];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = calculateIndex(key);

        if(hashTable[index] == null){
            Node entry = new Node(key, value);
            hashTable[index] = entry;
        }
        else{           
            Node curr = hashTable[index];
            Node prev = null;
            while(curr != null){
                if(curr.key == key){
                    curr.value = value;  
                    return;
                }
                prev = curr;
                curr = curr.next;
            }
            Node entry = new Node(key, value);
            prev.next = entry;            
        }

    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = calculateIndex(key);
        if(hashTable[index] != null){
            
            Node curr = hashTable[index];
            while(curr != null){
                if(curr.key == key){
                    return curr.value;
                }
                curr = curr.next;
            }
            return -1;            
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = calculateIndex(key);

        if(hashTable[index] != null){

            Node curr = hashTable[index];
            Node prev = null;
            
            while(curr != null){                
                if(curr.key == key){
                    
                    if(prev == null)
                        hashTable[index] = curr.next;                                            
                    else
                        prev.next = curr.next;   
                                                                 
                    return;               
                }
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public int hashCode(int key){
        return Integer.hashCode(key);
    }

    public int calculateIndex(int key){
        return hashCode(key)%capacity;
    }

    public static void main(String[] args){
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 10);
        myHashMap.put(2, 20);
        myHashMap.put(3, 30);
        System.out.println(myHashMap.get(3));
        myHashMap.put(13, 40);

        System.out.println(myHashMap.get(13));
        System.out.println(myHashMap.get(23));
        myHashMap.remove(13);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap.get(13));
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */