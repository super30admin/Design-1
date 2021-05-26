#Time complexity for put and get: O(1) amortized
#Space complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.bucket = 1000
        self.memory = [False]*self.bucket
        
    def hashing(self,key):
        return key%self.bucket
    
    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        found = False
        bk = self.hashing(key)
        if self.memory[bk] is False:
            self.memory[bk] = [(key,value)]
        else:
            bkList = self.memory[bk]
            for i,kv in enumerate(bkList):
                if key == kv[0]:
                    self.memory[bk][i] = (key,value)
                    found = True
                    break
            if not found:
                self.memory[bk].append((key,value))
        

    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        bk = self.hashing(key)
        if self.memory[bk] is False:
            return -1
        else:
            bkList = self.memory[bk]
            for k,v in bkList:
                if k == key:
                    return v
        return -1
        

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        bk = self.hashing(key)
        if self.memory[bk] is False:
            return
        else:
            bkList = self.memory[bk]
            for i,kv in enumerate(bkList):
                if kv[0] == key:
                    del self.memory[bk][i]

        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)