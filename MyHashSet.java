class MyHashSet {
    // We'll implement HashSet using double hashing. One primary and secondary array.
    int buckets; //Primary array
    int bucketItems; //Secondary array
    boolean[][] storage; //boolean 2D array


    public MyHashSet() //Constructor to initialize values
    {
        this.buckets=1000; //specifying the size of the primary array
        this.bucketItems=1000; //specifying the size of the secondary array
        storage= new boolean[buckets][];

    }

    private int getBucket(int key) //int is the retrun type of the function
    {
        //This is Hash Func to return the index of the key in the primary array.
        return key % buckets;
    }

    private int getBucketItems(int key){
        //This is secondary hash function to deal with the collision problem.
        return key / bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key); //get bucket value
        int bucketItem = getBucketItems(key); //get bucketItem value
        if (storage[bucket] == null) { //condn to check if it is empty or not
            if (bucket==0){
                storage[bucket] = new boolean[bucketItems+1]; // Fixed index out of bounds issue
            }
            else{
                storage[bucket] = new boolean[bucketItems];
            }
        }

        storage[bucket][bucketItem] = true;
    }


    public void remove(int key) {

        int bucket= getBucket(key); //get bucket value
        int bucketItem = getBucketItems(key); //get bucketItem value
        if (storage[bucket]== null){ //condn to check if the key value exists in the bucket
            return; // if does not then return
        }
        storage[bucket][bucketItem]=false;  //This will change the bucketItem to false

    }

    public boolean contains(int key) {
        int bucket = getBucket(key);  //to get primary bucket
        int bucketItem = getBucketItems(key);  //to get secondary bucket
        if (storage[bucket]==null){ //to check if it is in primary bucket
            return false; //if not return false
        }
        return storage[bucket][bucketItem]; //if it is then return the value from boolean secondary bucket
    }

    public static void main(String[] ags) {
        MyHashSet obj = new MyHashSet();
        obj.add(5);
        obj.add(10);
        System.out.println(obj.contains(5));
        System.out.println(obj.contains(3));
        obj.remove(5);
        System.out.println(obj.contains(5));

    }
}

///**
// * Your MyHashSet object will be instantiated and called as such:
// * MyHashSet obj = new MyHashSet();
// * obj.add(key);
// * obj.remove(key);
// * boolean param_3 = obj.contains(key);
// */


