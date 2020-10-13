// Time Complexity :O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Any better solution?


// Your code here along with comments explaining your approach
class Sample
{
        public static void main(String[] args)
        {
            MyHashMap hashMap = new MyHashMap();
            hashMap.put(1, 2);
            hashMap.put(2, 3);
            System.out.println(hashMap.get(1));            // returns 2
            System.out.println(hashMap.get(3));            // returns -1 (not found)
            hashMap.put(2, 4);          // update the existing value
            System.out.println(hashMap.get(2));            // returns 4
            hashMap.remove(2);          // remove the mapping for 2
            System.out.println(hashMap.get(2));            // returns -1 (not found)

        }
}

class MyHashMap
{
    int valueArray[];

    MyHashMap()
    {
        valueArray=new int[100000];
        for(int i=0;i<valueArray.length;i++)
        {
            valueArray[i]=-1;
        }
    }

    public void put(int key,int value)
    {
        valueArray[key]=value;
    }

    public int get(int key)
    {
      return valueArray[key];
    }

    public void remove(int key)
    {
        valueArray[key]=-1;
    }
}