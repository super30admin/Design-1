class MyHashMap {

    ArrayList <Item> list;
        
        class Item {
            int[] itemArray;
            public Item () {
                itemArray = new int[2];
            }
         }
        
        
    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new ArrayList<>();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        for (int i=0; i<list.size(); i++) {
            int listKey = list.get(i).itemArray[0];
            
            if (listKey == key) {
                list.get(i).itemArray[1] = value;
                break;
            }
        }
        
        Item newItem = new Item();
        newItem.itemArray[0] = key;
        newItem.itemArray[1] = value;
        list.add(newItem);
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        for (int i=0; i<list.size(); i++) {
            int listKey = list.get(i).itemArray[0];
            
            if (listKey == key) {
                return list.get(i).itemArray[1];
            }
        }
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        for (int i=0; i<list.size(); i++) {
            int listKey = list.get(i).itemArray[0];
            
            if (listKey == key) {
                list.remove(list.get(i));
                break;
            }
        }
    }
}