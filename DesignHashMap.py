// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I use Python so the solution needed array inside hashtable rather than LinkedList(JAVA).


// Your code here along with comments explaining your approach
class ListNode:
        def __init__(self):
            self.bucket=[] #bucketArray
            
        def get(self,key):
            for (k,v) in self.bucket: #checking for getting element
                if k==key:
                    return v
            return -1
        
        def update(self, key, value):
            found = False
            for i, kv in enumerate(self.bucket): #update element if its present
                if key == kv[0]:
                    self.bucket[i] = (key, value)
                    found = True
                    break

            if not found:# if not add the element
                self.bucket.append((key, value))

        def remove(self,key):
            for i,k in enumerate(self.bucket): #remove the already present element
                if k[0]==key:
                        del self.bucket[i]

                                   
                                   
class MyHashMap:
    


    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.size=100
        self.hash_table=[ListNode() for i in range(self.size)] # creating 100 along with buckets for each one of them

                                   
    def hashfunc(self,key): #hashfunc based on size 100
        return key%self.size
        

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index=self.hashfunc(key)
        self.hash_table[index].update(key,value) #using the predefined update func. from ListNode
        
        

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
                                   
        index=self.hashfunc(key)
        return self.hash_table[index].get(key)#using the predefined get func. from ListNode
        

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index=self.hashfunc(key)
        return self.hash_table[index].remove(key)#using the predefined remove func. from ListNode
        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)