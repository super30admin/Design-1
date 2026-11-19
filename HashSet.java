/*
Time Complexity :
Adding an element = O(1)
Removing an elemnt =  O(1)
Contains =  O(1)

Space Complexity :
we are using an array = O(n) 

Does this code run successfully on leetcode: Yes
Any problem faced : No
//Approach:
I can solve this problem using Double Hashing(2 hash functions) - boolean array
put = calculate 2 hash functions, check whether the index in static array is null, if null create
the array and then make the position as true , if not direclty calculate index in the hash function 2 to keep
the make it as true.True indicates that we have an element there.same applies to pop and contains.
*/

class HashSet {

    boolean[][] arr;
    int buckets;
    int bucketItems;

    public HashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.arr = new boolean[buckets][];
    }

    int hash1(int key){
       return  key % this.buckets;
    }
    int hash2(int key){
        return key / this.bucketItems;
    }


    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if(arr[bucket] == null){

            if(bucket == 0){
                arr[bucket] = new boolean[bucketItems+1];
            }
            else{
            arr[bucket] = new boolean[bucketItems];
            }
        }
        arr[bucket][bucketItem] = true;     
    }
    
    public void remove(int key) {
       
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(arr[bucket] == null) {
            return;
        }
        arr[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);

        if(arr[bucket] == null) {
            return false;
        }
        return arr[bucket][bucketItem] ;
    }

    public static void main(String[] args) {
        HashSet obj = new HashSet();
        obj.add(3);
        obj.add(5);
        obj.add(9);
        obj.remove(5);
        obj.add(7);
        System.out.println("the hashset" +obj.contains(3));
        obj.add(17);
        obj.remove(9);
        System.out.println("the hashset" +obj.contains(5));
    }
}

