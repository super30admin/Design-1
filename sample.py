class MyHashMap(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.keys = []
        self.hashMap = []
        

    def put(self, key, value):
        """
        value will always be non-negative.
        :type key: int
        :type value: int
        :rtype: None
        """
        if len(self.keys) == 0:
            self.keys.append(key)
            self.hashMap.append(value)
        else:
            for id, k in enumerate(self.keys):
                if(k == key):
                    self.hashMap[id] = value
                    return None
            self.keys.append(key)
            self.hashMap.append(value)
        


    def get(self, key):
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :type key: int
        :rtype: int
        """
        for id, k in enumerate(self.keys):
            if k == key:
                return self.hashMap[id]
        return -1

    def remove(self, key):
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :type key: int
        :rtype: None
        """
        for id, k in enumerate(self.keys):
                if(k == key):
                    self.hashMap.remove(self.hashMap[id])
                    self.keys.remove(self.keys[id])
                    return None