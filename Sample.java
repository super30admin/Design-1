// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MyHashSet {
    
    boolean [][] storage;
    int OutterArrayLen;
    int InnerArrayLen;
    
public MyHashSet() {
        OutterArrayLen=1000;
        InnerArrayLen=1000;
        storage= new boolean[OutterArrayLen][];
    }
    private int hash1(int key)
        
    {
        return key % OutterArrayLen;
    }
    
    private int hash2(int key)
    {
        return key/InnerArrayLen;
    }
    public void add(int key) 
    {
        int OutterArrayIndex =hash1(key);
        int InnerArrayIndex=hash2(key);
        if(storage[OutterArrayIndex]==null)
        {
            if(OutterArrayIndex==0)
            {
               storage[OutterArrayIndex]=new boolean[InnerArrayLen+1]; 
            }
            else
            {
               storage[OutterArrayIndex]=new boolean[InnerArrayLen];  
            }
        }
        storage[OutterArrayIndex][InnerArrayIndex]=true;
    }
    
      public void remove(int key)
    {
        int OutterArrayIndex =hash1(key);
        int InnerArrayIndex=hash2(key);
          if(storage[OutterArrayIndex]!=null)
          {
               if(storage[OutterArrayIndex][InnerArrayIndex]==true)
                    {
                        storage[OutterArrayIndex][InnerArrayIndex]=false;
                    }
          }
       
        
    }
    
     public boolean contains(int key)  {
        
        
        int OutterArrayIndex =hash1(key);
        int InnerArrayIndex=hash2(key);
         if(storage[OutterArrayIndex]==null)
             
         {
             return false;
             
         }
         else
         {
              return storage[OutterArrayIndex][InnerArrayIndex];
         }
       
        
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
