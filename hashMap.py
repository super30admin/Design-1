"""
// Time Complexity :
    put -> O(1) because it will directly search for the key_hash in hash_map
    get -> O(1) because it will directly search for the key_hash in hash_map
    remove -> O(n) because it will search for (say n = 3) n keys in that key_hash in hash_map

// Space Complexity :

// Did this code successfully run on Leetcode :
    No it is giving me error
    TypeError: int object not subscriptable
    'if pair[0] == key:' in put function

// Any problem you faced while coding this :
    I had to refer to some videos to understand it but got the gist of how Hash_Map works!
    My main problem when finding a solution is to picture how this (say Solution of when breaking down the process) might work.

// Your code here along with comments explaining your approach

"""

class MyHashMap:
    def __init__(self):
        """
        Initialize your data structure here.
        gave a size 1000 to not cause any collisions
        """
        self.hash_map = [None]*1000
        pass

    def get_hash(self, key):
        '''
        Generates a unique hash value for the key passed as parameter
        :param key:
        :return: int (key_hash)
        '''
        hash = 0
        for c in str(key):
            hash += ord(c)
        return hash % 1000


    def put(self, key: int, value: int) -> None:
        '''
        To add a key value pair to the HashMap
        value should be non-negative
        :param key: int could be passed as string sometimes
        :param value: int
        :return: boolean
        '''
        key_hash = self.get_hash(key)
        key_value = [key, value]
        if self.hash_map[key_hash] is None:
            self.hash_map[key_hash] = list([key_value])
            return True
        else:
            for pair in self.hash_map[key_hash]:
                if pair[0] == key:
                    pair[1] = value
                    return True
                self.hash_map[key_hash].append(key_value)


    def get(self, key: int) -> int:
        '''
        Function to find value for the key passes
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        :param key: int
        :return: int (value)
        '''
        key_hash = self.get_hash(key)
        if self.hash_map[key_hash] is not None:
            for pair in self.hash_map[key_hash]:
                if pair[0]==key:
                    return pair[1]
        return None


    def remove(self, key: int) -> None:
        '''
        Function to remove the key from Hashmap
        Removes the mapping of the specified value key if this map contains a mapping for the key
        :param key: int
        :return: boolean
        '''
        key_hash = self.get_hash(key)
        if self.hash_map[key_hash] is not None:
            for i in range(0, len(self.hash_map[key_hash])):
                if self.hash_map[key_hash][i][0]==key:
                    self.hash_map[key_hash].pop(i)
                    return True
        return False


    def check_A(self,key):
        '''
        Function to check whether a key is present in the Hashmap. For my own reference.
        :param key:
        :return: boolean
        '''
        key_hash = self.get_hash(key)
        if self.hash_map[key_hash] is not None:
            for pair in self.hash_map[key_hash]:
                if pair[0]==key:
                    return True
        return False

    def print_hash(self):
        '''
        Printing the Hashmap to get a visual of whether the keyand values are being added
        :return: None
        '''
        print("---------HASHMAP-----------")
        for i in self.hash_map:
            if i is not None:
                print(str(i))

# Your MyHashMap object will be instantiated and called as such:
# Driver Code
key = 7
value = 200
obj = MyHashMap()
obj.put(key,value)
obj.put("Key", 10)
obj.put(1,100)
obj.put("Lilac",100)
print(obj.check_A(7))
param_2 = obj.get(key)
print("Key Searched: ",param_2)
obj.remove(key)
obj.put(8,4)
obj.remove("Key")
obj.print_hash()
print(obj.get_hash("open"))
