
class MyHashMap(object):

def __init__(self):
    self.s = [-1 for _ in range (1000000+1)]
    

def put(self, key, value):
    """
    :type key: int
    :type value: int
    :rtype: None
    """
    self.s[key] = value
    

def get(self, key):
    """
    :type key: int
    :rtype: int
    """
    return self.s[key]
    
    

def remove(self, key):
    """
    :type key: int
    :rtype: None
    """
    self.s[key] = -1
    


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)