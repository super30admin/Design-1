// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
	class MyHashMap(object):
    
    def __init__(self):
        """
        Initialize your data structure here.
        """
	# initialise two list one is a where key is added second is b where value is added 
        self.a = []
        self.b = []
    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
	# if key is present in list a if present find the index of the key and update the value in list b in that index
        if key in self.a:
            i = self.a.index(key)
            self.b[i] = value
        else:
	# otherwise append key in list a and value in list b
            self.a.append(key)
            self.b.append(value)
    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
	# if k is present in list a find the index of it and return the value for that index from list b other wise retuen -1 (key is not present)
        if key in self.a:
            j = self.a.index(key)
            return (self.b[j])
        else:
            return -1

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
	# if key is present in list a find index of key then delete ket from list a and delete value from list b
        if key in self.a:
            k = self.a.index(key)
            del (self.a[k])
            del (self.b[k])


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)