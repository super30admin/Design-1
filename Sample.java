import java.util.LinkedList;

// Time Complexity : O(N/K) , N= number of all possible values , K= predefined buckets 
// Space Complexity : O(K+M) , M= number of unique values 
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : NO


class MyHashSet {
  //1d array is the primary bucket and 2d array is the secondary 
  boolean[][] storage;
  int buckets, bucketItems;

  public MyHashSet(){
    buckets=1000;
    bucketItems=1000;
    //initialize the buckets ie the primary array
    storage=new boolean[buckets][];

  }

  int getBucket(int key){
    //determine bucket number ie the primary bucket 
    return key%buckets;
  }

  int getBucketItem(int key){
    //determine bucket item number ie the secondary bucket 
    return key / bucketItems;
  }

  public void add(int key){
    //get the bucket and bucketitem number for given key
      int bucket= getBucket(key);
      int bucketItem = getBucketItem(key);

      if(storage[bucket]==null){
        //if bucket item is 0 add increase its size by 1 because it will give error while adding 1 and 1000
        if(bucket==0){
          storage[bucket] =new boolean[bucketItems+1];
        }else{
          storage[bucket] =new boolean[bucketItems];
        }

        storage[bucket][bucketItem] = true;
      } 
  }

  //determine pri and secondary bucket and remove the elemnt
  public void remove(int key){
    int bucket =getBucket(key);
    int bucketItem=getBucketItem(key);
    if(storage==null){
      return;
    }
    storage[bucket][bucketItem] = false;

  }

  //determine pri and secondary bucket and return the elemnt
  public boolean contains(int key){
    int bucket =getBucket(key);
    int bucketItem=getBucketItem(key);
    if(storage==null){
      return false;
    }
    return storage[bucket][bucketItem];

  }

}

public class Sample{
    public static void main(String[] args){
        MyHashSet obj = new MyHashSet();
        obj.add(9);
        
    }
  }
  
