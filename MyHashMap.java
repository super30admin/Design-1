// Time Complexity : put avg O(1), remove O(1), containsKey O(1), get O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : a little deciding the structure
//             and execution but ran successfully 23/36 test cases on Leetcode,
//              I only made minimal changes to myHashSet solution that
//              I implemented for design 2 and instead of storing the key
//              at the location stored the value.

class MyHashMap {

    internalArray[] hashMap;

    public MyHashMap() {
        this.hashMap = new internalArray[1001];
    }

    public void put(int key, int value) {

        int first = this.firstHash(key);
        int second = this.secondHash(key);

        if(this.hashMap[first] == null){
        	this.hashMap[first] = new internalArray();
        }

        if(this.hashMap[first].size < key){
                //internalArray ia = new internalArray();
                this.hashMap[first].resize(key + 1);
            }

        this.hashMap[first].array[second] = value;
    }

    public int get(int key) {

        int first = this.firstHash(key);
        int second = this.secondHash(key);

        if(this.containsKey(key)){
            return this.hashMap[first].array[second];
        }

        return -1;
    }

    public void remove(int key) {
        if(!this.containsKey(key)) return;

        int first = this.firstHash(key);
        int second = this.secondHash(key);

        this.hashMap[first].array[second] = -1;
    }

    public boolean containsKey(int key){
        int first = this.firstHash(key);
        int second = this.secondHash(key);

        return this.hashMap[first] != null &&
         (this.hashMap[first].array[second] != 0
          || this.hashMap[first].array[second] != -1);

    }

     private int firstHash(int key){
        return key % 1001;
    }

    private int secondHash(int key){
        return key / 1001;
    }
}

class internalArray{
     int size;
    int[] array;

    public internalArray(){
        size = 101;
        array = new int[101];
    }

    public void resize(int len){
        int[] newArray = new int[len];

        for(int i = 0; i< this.size; i++){
            newArray[i] = this.array[i];
        }

        this.array = newArray;
        this.size = len;
    }
}
