// Time Complexity :    O(1) for all operations
// Space Complexity :   O(n)
//  Yes, It's run successfully
// No I don't face any problem.





public class DesignHashMap706LeetCode {
    public static void main(String[] args){
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]

        System.out.println(myHashMap.get(1));// return 1, The map is now [[1,1], [2,2]]
        //myHashMap.get(3);
        System.out.println(myHashMap.get(3));// return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(2));
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
       // myHashMap.get(2);
        System.out.println(myHashMap.get(2));// return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        //myHashMap.get(2);
        System.out.println(myHashMap.get(2));// return -1 (i.e., not found), The map is now [[1,1]]
    }
}

class MyHashMap {

    Node[][] hashMap;
    int hash1 = 1000;
    int hash2 = 1000;

    class Node{
        int key;
        int value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    public MyHashMap() {
        hashMap = new Node[1000][];
    }

    public int getHash1(int key){
        return key%hash1;
    }

    public  int getHash2(int key){
        return key/hash2;
    }

    public void put(int key, int value) {
        if(hashMap[getHash1(key)]==null){
            if(getHash1(key)==0)
            {
                hashMap[getHash1(key)]=new Node[hash2+1];
            }
            else {
                hashMap[getHash1(key)] = new Node[hash2];
            }
            hashMap[getHash1(key)][getHash2(key)]=new Node(key, value);
        }
        else{
            hashMap[getHash1(key)][getHash2(key)]=new Node(key, value);
        }
    }

    public int get(int key) {
        if(hashMap[getHash1(key)]==null){
            return -1;
        }
        else{
             if(hashMap[getHash1(key)][getHash2(key)]==null){
                 return -1;
             }
             else{
                 return hashMap[getHash1(key)][getHash2(key)].value;
             }
        }
    }

    public void remove(int key) {
        if(get(key)!=-1){
            hashMap[getHash1(key)][getHash2(key)]=null;
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
