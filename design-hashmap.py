

# Time Complexity : O(1)
# Space Complexity : 
#Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : Determining the size of the array and figuring out the solution match

#Your code here along with comments explaining your approach


class MyHashMap:

    def __init__(self):

        self.hash = [None for i in range(10)]

        self.length = 10

        self.current = 0

    def put(self, key, value):

        if(key > self.length):

            for i in range(key-self.length):

                self.hash.append(None)

            self.hash[key] = value

        else:

            self.hash[key] = value

        return 'Value inserted'

    
    def get(self, key):

        if(self.hash[key] != None):

            return self.hash[key]

        return -1

    def remove(self, key):

        if(self.hash[key] != None ):

            self.hash[key] = None

        return -1



hashMap = MyHashMap()
temp = hashMap.put(1, 2)
print(temp)
temp = hashMap.put(2, 3)
print(temp)
temp = hashMap.get(1)
print(temp)
temp = hashMap.get(3)
print(temp)
temp = hashMap.put(2, 4)
print(temp)
temp = hashMap.get(2)
print(temp)
temp = hashMap.remove(2)
print(temp)
temp = hashMap.get(2)
print(temp)