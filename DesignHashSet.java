// Time Complexity :  O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : changed the variable names because I was getting confused between the actual index and the max value

// Your code here along with comments explaining your approach


class MyHashSet {

    private boolean[][] storage; //where the true/false values are stored if the number is present in the hashset
    private int Maxbucket; //size of primary array
    private int MaxbucketItems; //size of secondary array

    public MyHashSet() {
        this.Maxbucket = 1000; //initializing size of primary array
        this.MaxbucketItems = 1000; //initializing size of secondary array
        this.storage = new boolean[Maxbucket][]; //creating the primary array
    }

    private int primary_hash(int key){
        return key%this.Maxbucket;
    }
    
    private int secondary_hash(int key){
        return key/this.MaxbucketItems;
    }

    public void add(int key) {
        int bucket = primary_hash(key);
        int bucketItem = secondary_hash(key);
        //primary array has references stored to the secondary array, default reference value is null
        //checking if the reference exists
        if(storage[bucket] == null){
            //to accomodate for the max range 
            if(bucket == 0){
                storage[bucket] = new boolean[MaxbucketItems + 1];
            }
            //for all other other mods
            else{
            storage[bucket] = new boolean[MaxbucketItems];
            }
        }
        //
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = primary_hash(key);
        int bucketItems = secondary_hash(key);
        //if the reference to the secondary array does not exist
        if(storage[bucket] == null)
            return;
        //set the bool value to false to make sure it is removed    
        storage[bucket][bucketItems] = false;
    }
    
    public boolean contains(int key) {
        int bucket = primary_hash(key);
        int bucketItems = secondary_hash(key);
        //checking the primary array first, if the reference does not exist return false
        if(storage[bucket] == null) return false;
        //else return the actual bool value present in the secondary array
            return storage[bucket][bucketItems];
    }

    public static void main(String[] args){
        MyHashSet obj = new MyHashSet();
        obj.add(8999);
        obj.add(79);
        obj.add(1000000);
        obj.remove(9000);
        boolean param_3 = obj.contains(8999);
        System.out.println(param_3);
        boolean param_4 = obj.contains(1000000);
        boolean param_5 = obj.contains(779);
        System.out.println(param_4);
        System.out.println(param_5);
    }
}