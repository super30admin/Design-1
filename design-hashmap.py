
# Time Complexity : O(1)
# Space Complexity : 
#Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : Determining the size of the array and figuring out the solution match

#Your code here along with comments explaining your approach


class MyHashSet:

    def __init__(self):

        self.hash = [None for i in range(1000)]

        self.hashblock = [False for i in range(10)]

        self.length = 10

        self.current = 0

    def add(self, key, value):

        temp = int(key % 1000)
        temp1 = int(key / 1000)

        if(self.hash[temp] == None):

            self.hash[temp] = self.hashblock
            self.hash[temp][temp1] = True

    
    def contains(self, key):

        temp = int(key % 1000)
        temp1 = int(key / 1000)
        if(self.hash[temp] != None):
            if(self.hash[temp][temp1] == True):
                return True
        return False

    def remove(self, key):

        temp = int(key % 1000)
        temp1 = int(key / 1000)

        if(self.hash[temp]!= None):

            if(self.hash[temp][temp1] == True):
                print('key removed', key)
                self.hash[temp][temp1] = False
        return False

hashSet = MyHashSet()
temp = hashSet.add(1, 2)
print(temp)
temp = hashSet.add(2, 3)
print(temp)
temp = hashSet.contains(1)
print(temp)
temp = hashSet.contains(3)
print('3',temp)
temp = hashSet.add(2, 4)
print(temp)
temp = hashSet.contains(2)
print(temp)
temp = hashSet.remove(2)
print(temp)
temp = hashSet.contains(2)
print(temp)