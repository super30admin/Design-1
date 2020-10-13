// Time Complexity :O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :Any better solution?


// Your code here along with comments explaining your approach

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