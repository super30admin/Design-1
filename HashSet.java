class HashSet{
  int bucket;
  int bucketItem;
  boolean storage[][];

  public HashSet(){
    this.bucket=1000;
    this.bucketItem=1000;
    storage=new boolean[bucket];
  }

  int getbuc(int key){
    return key%bucket;
  }

  int getbucItem(int key){
    return key/bucket;
  }

  public void add(int key){
    int bu=getbuc(key);
    int buitem=getbucItem(key);
    if(storage[bu]==null){
      if(bu==0){
        storage[bu]=new boolean[bucketitem+1];
      }
      else{
        storage[bu]=new boolean[bucketitem];
      }
    }storage[bu][buitem]=true;
  }

  public void remove(int key){
     int bu=getbuc(key);
    int buitem=getbucItem(key);
    if(storage[bu]==null){
      return;
    }
    storage[bu][buitem]=false;
  }


  public boolean contain(int key){
     int bu=getbuc(key);
    int buitem=getbucItem(key);
    if(storage[bu]==null){
      return false;
    }return storage[bu][buitem];
  }
}
/*
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
