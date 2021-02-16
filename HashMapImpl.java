import java.util.*;
class MyHashMap {
    
    List<List<int[]>> hm;
    int size = 13000;
    /** Initialize your data structure here. */
    public MyHashMap() {
        hm = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            hm.add(i, new ArrayList<>());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key%size;
        for(int i = 0; i < hm.get(index).size();i++){
            if(hm.get(index).get(i)[0] == key){
                hm.get(index).get(i)[1] = value;
                return;
            }
        }
        hm.get(index).add(new int[]{key,value});
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key%size;
        for(int i = 0; i < hm.get(index).size();i++){
            if(hm.get(index).get(i)[0] == key){
                return hm.get(index).get(i)[1];
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key%size;
        for(int i = 0; i < hm.get(index).size();i++){
            if(hm.get(index).get(i)[0] == key){
                hm.get(index).remove(i);
            }
        }
        return;
    }
}


public class HashMapImpl {
	public static void main(String[] args) {
		MyHashMap obj = new MyHashMap();
		obj.put(1,12);
		int param_2 = obj.get(1);
		System.out.println(param_2);
		obj.remove(1);
	}
}
 