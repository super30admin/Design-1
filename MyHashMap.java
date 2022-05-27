import java.util.*;

class MyHashMap {
    int [] map;
    //int [] values;
    public MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map, -1);
        //values = new int[1]
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key]=-1;
    }

    public static void main(String[] args){
        MyHashMap hashMap = new MyHashMap();

        hashMap.put(1, 2);



        hashMap.put(2, 3);



        System.out.println(hashMap.get(1));            // returns 2



        System.out.println(hashMap.get(3));            // returns -1 (not found)



        hashMap.put(2, 4);          // update the existing value



        System.out.println(hashMap.get(2));            // returns 4



        hashMap.remove(2);          // remove the mapping for 2



        System.out.println(hashMap.get(2));            // returns -1 (not found)
    }
}