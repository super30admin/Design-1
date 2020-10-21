package S30.Design_1;

// Time Complexity : Put: O(n) - worse case, Get: O(n) - worse case, Remove: O(n) - worse case
// Space Complexity : O(n), n is maximum number of data range
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

//Hashing using Chaining technique
import java.util.LinkedList;

class KeyValue{
    int key;
    int value;

    public KeyValue(int key, int value){
        this.key = key;
        this.value = value;
    }
    public int getKey(){
        return this.key;
    }

    public int getValue(){
        return this.value;
    }
    public void setValue(int value){
        this.value = value;
    }
    public void setKey(int key){
        this.key = key;
    }
}

public class DesignHashMap {

    /** Initialize your data structure here. */
    static int MAXLEN = 100000;
    LinkedList<KeyValue>[] map;
    public DesignHashMap() {
        map = new LinkedList[MAXLEN];
    }

    public int getIndex(int key){
        return key % MAXLEN;
    }

    public int getPos(int index, int key){

        LinkedList<KeyValue> list = map[index];
        if(list != null){
            for(int i = 0; i < list.size(); i++){
                if (list.get(i).getKey() == key){
                    return i;
                }
            }
        }
        return -1;

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        int index = getIndex(key);
        int pos = getPos(index,key);
        if(pos == -1){ // key does not exist or list does not exist
            if(map[index] == null){
                map[index] = new LinkedList<KeyValue>();
            }
            KeyValue kv = new KeyValue(key,value);
            map[index].add(kv);

        }else{
            KeyValue kv = map[index].get(pos);
            kv.setValue(value);
        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        int index = getIndex(key);
        int pos = getPos(index,key);
        if(pos != -1){
            KeyValue kv = map[index].get(pos);
            return kv.getValue();
        }
        return -1;


    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        int index = getIndex(key);
        int pos = getPos(index,key);
        if(pos != -1){
            map[index].remove(pos);

        }
    }

}
