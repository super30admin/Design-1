
'''
// Time Complexity : Best : O(1) Worst : amortized O(N)
// Space Complexity : O(N) N - number of Key Value pairs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    Left a bug on update- used old value to update instead using new value 


// Your code here along with comments explaining your approach
'''

'''
There are two classes,

1. Bucket : Holds all key,value pairs of all keys which generate same hashed value or location
    - a list holds key-value pairs as tuple 
    - put : By update method, if a key exists new value will be updated
                                else : key, value is inserted
    - remove : removes the key,value tuple 
    - get : scans through list, if key exist returns value

2. HashMap:
    Going to create as many buckets as many key space
    GET, REMOVE - Reaches the right bucket by hashing incoming key utilizes get,remove method of Bucket
'''

class Bucket:
    def __init__(self):
        self.bucket=[]
        
    def update(self,key,value):
        found=False
        for i,(_key, _value) in enumerate(self.bucket):
            if key==_key: 
                self.bucket[i]=(key,value)
                found=True
                break
        
        if not found:
            self.bucket.append((key,value))        
            
    
    def get(self,key):
        for (_key, value) in self.bucket:
            if key==_key:
                return value
        return -1
    
    def remove(self,key):
        for i,(_key, value) in enumerate(self.bucket):
            if key==_key:
                del self.bucket[i]
                

class MyHashMap(object):

    def __init__(self):
        self.key_space=11
        self.hash_table=[Bucket() for i in range(self.key_space)]

    def put(self, key: int, value: int) -> None:
        hash_key=key%self.key_space
        self.hash_table[hash_key].update(key, value)


    def get(self, key: int) -> int:
        hash_key=key%self.key_space
        return self.hash_table[hash_key].get(key)

    def remove(self, key: int) -> None:
        hash_key=key%self.key_space
        self.hash_table[hash_key].remove(key)
        




obj = MyHashMap()

funcs=["MyHashMap","put","put","get","get","put","get","remove","get"]
params=[[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]

print(obj.put(1,1))
print(obj.put(2,2))
print(obj.get(1)) # 1
print(obj.get(3))  # -1
print(obj.put(2,1))
print(obj.get(2))  # 1
print(obj.remove(2))
print(obj.get(2))  # -1
