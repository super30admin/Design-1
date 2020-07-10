// TC=O(1)
// SC=
// as the input is 1000000 divided the array into blocks of 1000 and each
// block can be assigned an array of 1000 buckets if necessary
// for performing any operation know the index of bucket, while inserting in the bucket
// find the index of where boolean value needs to be stored, if there is a collision create
// new array and insert the key to the index obtained by second hashing

import java.util.*;

class HashSet{
int bucket=1000;
int bucketjoin=1000;
boolean[][] store = new boolean[bucket][];  //change the size whenever needed

  public void add(int key){
    int b1=key%bucket;
    int b2=key/value;
    if(store[bucket]==null){
      store[bucket]=new boolean[bucketjoin];
      //did not know way to proceed had to look at video, got to ask how it works
    }
    boolean[b1][b2]=true;

  }
}

public void remove(){
  int b1=key%bucket;
  int b2=key/value;
  if(store[bucket]!=null){
      boolean[b1][b2]=false;
  }
}

public int contains(int key){
  int b1=key%bucket;
  int b2=key/value;
  if(boolean[b1][b2]==true){
    return true;
  }
}
