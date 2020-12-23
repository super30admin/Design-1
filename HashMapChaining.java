// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


class MyHashMap {


    ArrayList<HashNode> bucketArray;
    int bucketCount;
    int size;
    double threshold = 0.8;
    /** Initialize your data structure here. */
    public MyHashMap() {
      bucketArray = new ArrayList<HashNode>();
      bucketCount = 500;
      size = 0;

      for(int i = 0; i < bucketCount; i++)
      {
        bucketArray.add(null);
      }

    }

    public int getBucketIndex(int key)
    {
      int index = key % bucketCount;
      return index;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
      int bucketIndex = getBucketIndex(key);
      HashNode head = bucketArray.get(bucketIndex);

      while(head != null)
      {
        if(head.key == key)
        {
          head.value = value; //Already exists. Replace and return
          return;
        }
        head = head.next;
      }

      head = bucketArray.get(bucketIndex);
      HashNode newNode = new HashNode(key, value);
      newNode.next = head;

      bucketArray.set(bucketIndex, newNode);
      size++;
      //Check for overflow;

      if(((1.0 *size) / bucketCount) > 0.8)
      {

        ArrayList<HashNode> temp = bucketArray;
        bucketArray = new ArrayList<HashNode>();
        bucketCount *= 2;

        for(int i = 0; i < bucketCount; i++)
        {
          bucketArray.add(null);
        }

        for(HashNode headNode : temp)
        {
          while(headNode != null)
          {
            put(headNode.key, headNode.value);
            headNode = headNode.next;
          }
        }
      }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
      int bucketIndex = getBucketIndex(key);
      HashNode head = bucketArray.get(bucketIndex);

      while(head != null)
      {
        if(head.key == key)
        {
          return head.value;
        }
        head = head.next;
      }

      return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
      int bucketIndex = getBucketIndex(key);
      HashNode head = bucketArray.get(bucketIndex);

      HashNode prev = null;
      while(head != null)
      {
        if(head.key == key)
        {
          size--;
          if(prev != null)
          {
            prev.next = head.next;
          }
          else
          {
            bucketArray.set(bucketIndex, head.next);
          }

        }
        prev = head;
        head = head.next;
      }
    }

}


class HashNode {

    int key;
    int value;

    HashNode next;

    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;

        this.next = null;

    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
