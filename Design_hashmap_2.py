class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dict=[]

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        if key>len(self.dict)-1:
            self.dict+=[-1]*(key-len(self.dict)+1)
        self.dict[key] = value
    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        if key>len(self.dict)-1:
            return -1
        else:
            return self.dict[key]

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        if key>len(self.dict)-1:
            return
        else:
            self.dict[key] = -1
                

