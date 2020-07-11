class Listnode:
    def __init__(self,data_pair):
        self.key_value = data_pair
        self.next = None

class MyHashMap:
    def __init__(self):
        """
        Initialize your data structure here.
        1. get the index from get_index
        """
        self.hashmap=[None]*1000

    def get_index(self,key):
        return key%1000

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hash_id=self.get_index(key)
        if self.hashmap[hash_id] == None:
            self.hashmap[hash_id]=Listnode((key,value))
        else:
            current=self.hashmap[hash_id]
            while current:
                k,v =current.key_value
                if k == key:
                    current.key_value = (key,value)
                    return
                if current.next == None:
                    current.next = Listnode((key, value))
                    return
                else:
                    current=current.next
        return

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hash_id=self.get_index(key)
        if self.hashmap[hash_id] == None:
            return -1
        else:
            current=self.hashmap[hash_id]
            while current:
                k,v =current.key_value
                if k == key:
                    return v
                current=current.next
            return -1

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hash_id=self.get_index(key)
        if self.hashmap[hash_id] == None:
            return
        else:
            current=self.hashmap[hash_id]
            prev=None
            while current:
                k,v =current.key_value
                if k == key:
                    if prev == None:
                        self.hashmap[hash_id]=None
                        return
                    else:
                        prev.next=current.next
                        return
                else:
                    prev=current
                    current=current.next
        return


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key, value)
# param_2 = obj.get(key)
# obj.remove(key)