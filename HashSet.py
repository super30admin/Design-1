# Time Complexity : O(1)
# Space Complexity : O(k) where k =10^6
# Did this code successfully run on Leetcode : Yes

class MyHashSet(object):

    def __init__(self):
        #Initiating 2D List with size 1001*1000 with boolean values
        self.HashSet = [[False for i in range(1001)] for j in range(1000)]

    def get_bucket(self, key):
        return key % 1000

    def get_bucket_item(self, key):
        return key // 1000

    def add(self, key):
        #Updating the vale to True indicationg addition of the key value 
        self.HashSet[self.get_bucket(key)][self.get_bucket_item(key)] = True

    def remove(self, key):
        #update the value back to False indicating the removal of the key from the Hashset
        self.HashSet[self.get_bucket(key)][self.get_bucket_item(key)] = False

    def contains(self, key):
        #Returns the True/False from the 2D list if the value is present
        return self.HashSet[self.get_bucket(key)][self.get_bucket_item(key)]

obj = MyHashSet()
obj.add(1)
obj.add(1000000)
param_1 = obj.contains(1000000)
print("Contains 1000000: ",param_1)
obj.add(3)
param_2 = obj.contains(3)
print("Contains 3: ",param_2)
obj.remove(3)
param_3 = obj.contains(3)
print("Contains 3: ",param_3)