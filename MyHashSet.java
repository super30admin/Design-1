// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on LeetCode : Yes
// Any problem you faced while coding this :  Yes when I used if statement to check val with min
// code ran successfully  but submission failed.  When I used Math.min it worked fine

//Approach - Use 2 dimensional array and double hashing technique, leaner chaining strategy to achieve O(1) for both time complexity,
// space complexity and minimize  the collusion.  Initialize the primary Array with size of
// 1000 elements and only create the secondary array as needed basis to optimize storage and handled the edge case of hashing key
// of 1000000 by creating 10001 elements space for 0th element



class MyHashSet {

    boolean[][] storage;
    public MyHashSet(){
        this.storage = new boolean[1000][];
    }

    private int primaryArrayHash(int key){
       return key % 1000;
    }
    private int secondArrayHash(int key){
        return key / 1000;
    }
    public void add(int key){
        int h1 = primaryArrayHash(key);
        int h2 = secondArrayHash(key);
        if(storage[h1] == null) {
            //handle edge case of storing key as 1000000
            // 1000000%10000 = 0
            // 1000000/1000 = 1000
            if(h1 == 0){

                storage[h1] = new boolean[1001];
            }else{
                storage[h1] = new boolean[1000];
            }
        }
        storage[h1][h2] = true;
    }

    public void remove(int key){
        int h1 = primaryArrayHash(key);
        if(storage[h1] == null) return;
        int h2 = secondArrayHash(key);
        storage[h1][h2] = false;

    }
    public boolean contains(int key){
        int h1 = primaryArrayHash(key);
        if(storage[h1] == null) return false;
        int h2 = secondArrayHash(key);
        return storage[h1][h2];
    }

    public static void main(String args[]){
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(10001);
        System.out.println(myHashSet.contains(10001));
        myHashSet.remove(10001);
        System.out.println(myHashSet.contains(10001));
        myHashSet.add(1000000); //edge case testing of add
        System.out.println(myHashSet.contains(1000000)); //edge case testing of contains

    }
}
