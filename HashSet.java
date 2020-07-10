// TC=O(1)
// SC=
// as the input is 1000000 divided the array into blocks of 1000 and each
// block can be assigned an array of 1000 buckets if necessary
// for performing any operation know the index of bucket, while inserting in the bucket
// find the index of where boolean value needs to be stored, if there is a collision create
// new array and insert the key to the index obtained by second hashing

// Issue:
// class, interface, or enum expected
//
//  not a statement: if(boolean[b1][b2]==true){
//
// cannot find symbol:  int b2=bucketverticals(key);
//
//
// 58: error: incompatible types: boolean cannot be converted to int: return true;
//
// java:72: error: missing return statement




import java.util.*;


class HashSet{

int bucket=1000;
int bucketjoin=1000;

boolean[][] store = new boolean[bucket][];  //change the size whenever needed
public int buckets(int key){
  return key%bucket;
}

public int bucketverticals(int key){
  return key/bucketjoin;
}



  public void add(int key){
    int b1=buckets(key);
    int b2=bucketverticals(key);
    if(store[b1]==null){
      store[b1]=new boolean[bucketjoin];
      //did not know way to proceed had to look at video, got to ask how it works
    }
    store[b1][b2]=true;
  }


public void remove(int key){
  int b1=buckets(key);
  int b2=bucketverticals(key);
  if(store[b1]!=null){
      store[b1][b2]=false;
  }
}

public boolean contains(int key){
  int b1=buckets(key);
  int b2=bucketverticals(key);
  if(store[b1]!=null){
    if(store[b1][b2]==true){
      return true;

    }
  }
  return false;

}

}
