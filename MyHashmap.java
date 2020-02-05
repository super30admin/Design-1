import java.util.*;

class MyHashMap {
    List<Integer> listKey;
    List<Integer> listVal;

    public MyHashMap() {
        listKey = new ArrayList<>();
        listVal = new ArrayList<>();
    }
    
    public void put(int key, int value) {
        if(listKey.contains(key)){
            int index = listKey.indexOf(key);
            listVal.remove(index);
            listVal.add(index,value);
        } else {
            listKey.add(key);
            listVal.add(value);
        }
    }
    
    public int get(int key) {
       if(listKey.contains(key)){
            int index = listKey.indexOf(key);
            return listVal.get(index);
        } else {
            return -1;
        }
    }
    
    public void remove(int key) {
        if(listKey.contains(key)){
            int index = listKey.indexOf(key);
            listKey.remove(index);
            listVal.remove(index);
        }
    }    
}

public static void main(String[] args) {
    MyHashMap hashMap = new MyHashMap();
    hashMap.put(1,2);
    hashMap.put(2,3);
    hashMap.get(1);
    hashMap.get(3);
    hashMap.put(2,4);
    hashMap.remove(2);
    hashMap.get(2);
}
