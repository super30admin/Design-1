// tc for put, get, remove is o(n)
// sc is o(n)

// Karan Sir approach

// class MyHashMap {
    
//     class Node
//     {
//         int key; // user's key
//         int value;
//         Node next;
        
//         public Node(int key, int value)
//         {
//             this.key = key;
//             this.value=value;
//         }
//     }
//     Node[] hashMap;
//     public MyHashMap() {
//         hashMap = new Node[10000];
//     }
    
//     // calculate index for a user given key
//     private int index(int key)
//     {
//         return (Integer.hashCode(key)) % 10000;
//     }
    
//     private Node find(int key)
//     {
//         int hashKey = index(key);
//         Node head = hashMap[hashKey];
//         Node prev = head;
//         Node curr = head;
        
//         while(curr.next != null && curr.key != key)
//         {
//             prev = curr;
//             curr=curr.next;
            
//         }
//         return prev;
//     }
    
//     public void put(int key, int value) {
        
//         int hashKey = index(key);
        
//         if(hashMap[hashKey] == null)
//         {
//           hashMap[hashKey] = new Node(-1,-1);  
//         }
        
//         Node ptr = find(key);
//         // key not existing
        
//         if(ptr.next == null)
//         {
//             Node newEntry = new Node(key, value);
//             ptr.next = newEntry;
//         }
//         // key exists
//         else
//         {
//             ptr.next.value = value;
//         }
        
//     }
    
//     public int get(int key) {
//         int hashKey = index(key);
//         Node ptr = find(key);
        
//         //null index/hashKey
        
//         if(hashMap[hashKey]==null){
//             return -1;
//         }
        
//         // found
//         if(ptr.next != null)
//         {
//             return ptr.next.value;
//         }
        
//         // not found
//         else
//         {
//             return -1;
//         }
//     }
    
//     public void remove(int key) {
//         int hashKey = index(key);
//         Node ptr = find(key);
        
//         //found
        
//         if(ptr.next!=null)
//         {
//           ptr.next=ptr.next.next;
//         }
        
//         // not found
//         // if(ptr.next==null)
//         // {
//         //     return
//         // }
//     }
// }

// /**
//  * Your MyHashMap object will be instantiated and called as such:
//  * MyHashMap obj = new MyHashMap();
//  * obj.put(key,value);
//  * int param_2 = obj.get(key);
//  * obj.remove(key);
//  */

// Naive approach
// class MyHashMap{
    
//     int[] hashMap = new int[1000001];
    
//     public MyHashMap() {
//        Arrays.fill(hashMap,-1);
//     }
    
//     public void put(int key, int value){
//         hashMap[key]=value;
//     }
    
//     public int get(int key){
//         return hashMap[key];
//     }
    
//     public void remove(int key){
//         hashMap[key]=-1;
//     }
    
// }

class MyHashMap{ 
    
    LinkedList<Entry>[] bucketList;
    int size = 10000;
    
    class Entry{
        int key, value;
        Entry(int key, int value)
        {
            this.key=key;
            this.value=value;
        }
    }
    
    public MyHashMap() {
       bucketList = new LinkedList[size];
    }
    
    public void put(int key, int value){
        int index = key % 10000;
        if(bucketList[index]==null)
        {
            bucketList[index]= new LinkedList<>();
            bucketList[index].add(new Entry(key,value));
        }
        else
        {
            for(Entry entry:bucketList[index])
            {
                if(entry.key == key)
                {
                    entry.value = value;
                    return;
                }
            }
            bucketList[index].add(new Entry(key,value));
        }
    }
    
    public int get(int key){
        int index = key % 10000;
        LinkedList<Entry> list = bucketList[index];
        if(list==null) return -1;
        for(Entry entry:list)
        {
            if(entry.key == key)
            {
                return entry.value;
            }
        }
        return -1;        
    }
    
    public void remove(int key){
        
        int index = key % 10000;
        Entry toRemove = null;
        if(bucketList[index] == null) return;
        else{
            for(Entry entry: bucketList[index]){
                if(entry.key==key){
                    toRemove = entry;
                }
            }
            if(toRemove == null) return;
            bucketList[index].remove(toRemove);
        }
        
    }
    
}
