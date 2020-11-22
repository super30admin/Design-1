//time complexity
//insert - O(1) 
//update, get, delete - O(N)

import java.util.LinkedList;

class MyHashMap {
    
    class keyValuePair {
        int key;
        int val;

        public keyValuePair(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int initialSize = 16;
    private LinkedList<keyValuePair>[] hashMap;
    private int size;
    private double loadFactor = 0.75;

    private int hashFun(int index) {
        return index % initialSize;
    }

    public MyHashMap() {
        hashMap = new LinkedList[initialSize];
        size = 0;
    }

    public void put(int key, int value) {
        int index = hashFun(key);
        keyValuePair insert = new keyValuePair(key, value);
        if (hashMap[index] == null) 
        {
            hashMap[index] = new LinkedList<keyValuePair>();
            hashMap[index].addFirst(insert);
            size++;
            if(overLoad()) 
            {
                reHashing();
            }
        } 
        else 
        {
            boolean found = false;
            for (keyValuePair data : hashMap[index]) 
            {
                if (data.key == key) 
                {
                    data.val = value;
                    found = true;
                    break;
                }
            }
            if (!found) 
            {
                hashMap[index].addFirst(insert);
                size++;
                if(overLoad()) 
                {
                    reHashing();
                }
            }
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = hashFun(key);
        LinkedList<keyValuePair> keys = hashMap[index];
        if (keys == null) 
        {
            return -1;
        }
        for (keyValuePair data : keys) 
        {
            if (data.key == key) 
            {
                return data.val;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = hashFun(key);
        LinkedList<keyValuePair> keys = hashMap[index];
        if (keys == null) 
        {
            return;
        }
        Iterator<keyValuePair> iter = keys.iterator();
        while(iter.hasNext())
        {
            if(iter.next().key==key)
            {
                iter.remove();
            }
        }

    }

    private boolean overLoad() {
        double currentLoad = (double) size / (double) initialSize;
        return (currentLoad > loadFactor);
    }

    private void reHashing() {
        LinkedList<keyValuePair>[] temp = hashMap;
        initialSize *= 2;
        hashMap = new LinkedList[initialSize]; 
        for(LinkedList<keyValuePair> bucket : temp)
        {
            if(bucket == null) 
            {
                continue;
            }
            for(keyValuePair data : bucket)
            {
                put(data.key, data.val);
            }
        }
    }
}
