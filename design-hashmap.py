
# Time Complexity : O(1)
# Space Complexity : 
#Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : Determining the size of the array and figuring out the solution match

#Your code here along with comments explaining your approach


class MyHashSet:

    def __init__(self):

        self.hash = [None for i in range(1000000)]

        self.hashblock = [False for i in range(1000)]

        self.length = 10

        self.current = 0

    def add(self, key):

        temp = int(key % 1000)
        temp1 = int(key / 1000)

        if(self.hash[temp] == None):

            self.hash[temp] = self.hashblock
            self.hash[temp][temp1] = True
            print('Value Added: ',self.hash[temp][temp1])

    
    def contains(self, key):

        temp = int(key % 1000)
        temp1 = int(key / 1000)
        if(self.hash[temp] != None):
            if(self.hash[temp][temp1] == True):
                print('Contains: ',self.hash[temp][temp1])
                return True
        print('Not Contains: ',self.hash[temp][temp1])
        return False

    def remove(self, key):

        temp = int(key % 1000)
        temp1 = int(key / 1000)

        if(self.hash[temp]!= None):

            if(self.hash[temp][temp1] == True):
                print('key removed', key)
                self.hash[temp][temp1] = False
                print('Removed: ',self.hash[temp][temp1])
        print('Not exists: ',self.hash[temp][temp1])
        return False


hashSet = MyHashSet()
print(hashSet.contains(3))
print(hashSet.contains(55))
print(hashSet.contains(9))
print(hashSet.add(1))
print(hashSet.add(2))
print(hashSet.contains(1))
print(hashSet.contains(3))
print(hashSet.add(2))
print(hashSet.contains(2))
print(hashSet.remove(2))      
print(hashSet.add(2))
print(hashSet.contains(2))