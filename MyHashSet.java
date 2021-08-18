// Time Complexity : big O(1)
// Space Complexity :big O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
public class MyHashSet {
    boolean [][] storage;
    int buckets;
    int bucketitems;
    //data structure initialization
    //Take size such as sqrt of data range 
    public MyHashSet(){
        buckets=1000;
        bucketitems=1000;
        storage =new boolean[buckets][];

    }
    //for first initial static array
    private int bucket(int key){
        return key % buckets;
    }
    //for second nested static array
    private int bucketItem(int key){
        return key / bucketitems;
    }
// adding elements into Hashset with help of arrays
    public void add(int key){
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        //initially when primary array(2D array of pointers) will be null 
        if(storage[bucket]==null){
            //if the nested array is at first index then for the case 1000 we have to take 10001 otherwise last index won't be present
            if(bucket==0)
            {
                storage[bucket]=new boolean[bucketitems+1];

            }
            //other cases for indexes in array we will add nested array at specific index
            else
            {
                storage[bucket]=new boolean[bucketitems];
            }

        }
        //if array already contains elements set status to true 
        storage[bucket][bucketItem]=true;

    }
    //for removing elements from Hashset
    public void remove(int key){
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);

        //if its null that means there's no nested array itself then  just return 
        if(storage[bucket]==null){
            return;
        }
        storage[bucket][bucketItem]=false;
    }
    //returns true if set contains specific elements
    public boolean contains(int key)
    {
        int bucket=bucket(key);
        int bucketItem=bucketItem(key);
        if(storage[bucket]==null) return false;
        return storage[bucket][bucketItem];
    }




}
