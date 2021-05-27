import java.util.Arrays;

// Time Complexity : O(1)
// Space Complexity : numMapping[1000][1000] takes constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {
    //Using a double hashing approach where the first hashing gives the bucketNumber
    //and the second hashing gives the index in the bucket
    //basically a 2 day array
    int bucketSize;
    int[][] numMapping;
    int bucketItems;
    public int hashGenerator(int key)
    {
        return key%bucketSize;
        
    }
    public int doubleHashGenerator(int key)
    {
        return key/bucketItems;
    }
    /** Initialize your data structure here. */
    public MyHashMap() {
       //1000*1000= 1M enteries possible as per the given constraints
       //0 <= key, value <= 10^6 
       //Since it's a 0 based index so 99999 enteries
        bucketSize=1000;
        bucketItems=1000;
        //we only initilize the column array when a number is to be inserted into that bucket
        numMapping=new int[bucketSize][];
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
       int bucketNo=hashGenerator(key);
       int itemIndex=doubleHashGenerator(key);
        //check if the bucket is not yet initialized or not
        //if not, we initilaize it.
        if(numMapping[bucketNo]==null)
        {
             if(bucketNo==0 )
             numMapping[0]=new int[bucketItems+1];
             else 
             numMapping[bucketNo]=new int[bucketItems];
            //fill all values with -1 by default.
            Arrays.fill(numMapping[bucketNo],-1);
        }
        
       numMapping[bucketNo][itemIndex]=value; 
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
       int bucketNo=hashGenerator(key);
       int itemIndex=doubleHashGenerator(key); 
        if(numMapping[bucketNo]==null)
            return -1;
       return numMapping[bucketNo][itemIndex];
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
          int bucketNo=hashGenerator(key);
          int itemIndex=doubleHashGenerator(key); 
         if(numMapping[bucketNo]==null)
            return;
          numMapping[bucketNo][itemIndex]=-1;
    }

    public static void main(String[] args)
    {
        MyHashMap hashMap=new MyHashMap();
        hashMap.put(1,1);
        hashMap.put(2,2);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2,1);
        System.out.println(hashMap.get(2));
        hashMap.remove(2);
        System.out.println(hashMap.get(2));
    }
}