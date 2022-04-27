/**

Time Complexity : O(1)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/
class MyHashMap 
{
    
    int index[][];
    
    int hashOne(int data)
    {
        return data/1000;
    }
    
    int hashTwo(int data)
    {
       return data % 1000;
    }
    

    public MyHashMap() {
        this.index = new int[1001][];
    }
    
    public void put(int key, int value) 
    {
        int startIndex = hashOne(key);
        
        if(index[startIndex] == null)
        {
            index[startIndex] = new int[1000];
            Arrays.fill(index[startIndex], -1);
        }
        
        int secondIndex = hashTwo(key);
        
        index[startIndex][secondIndex] = value;
    }
    
    public int get(int key) 
    {
        int startIndex = hashOne(key);
        
        if(index[startIndex] == null)
        {
            return -1;
        }
        
        int secondIndex = hashTwo(key);
        
        return index[startIndex][secondIndex];
        
    }
    
    public void remove(int key) 
    {
        
        int startIndex = hashOne(key);
        
        if(index[startIndex] == null)
        {
            return;
        }
        
        int secondIndex = hashTwo(key);
        index[startIndex][secondIndex] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */