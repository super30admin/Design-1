# Time Complexity = O(1)
# Space Complexity = O(n)
# Successfully compiled and run on Leetcode


class MyHashMap(object):

    def __init__(self):
        self.maxsize = 1000   #took maxsize of hahsmap as 1000 = sq root of 10^6 (given)
        self.hashmap = [[] for _ in range(self.maxsize)] #declaring hashmap

    def hashfunc(self, key):
        return key % self.maxsize #my hash function

    def put(self, key, value):
        idx = self.hashfunc(key) #obtain index from hash function

        elements = self.hashmap[idx] #get hold of all the data elements in that index

        for element in elements: #run a loop to check the exisitng key values
            if element[0] == key:
                element[1] = value #updating value if key exists
                return
        elements.append([key, value]) # if key doesnot already exists simply append

    def get(self, key):
        idx = self.hashfunc(key)

        elements = self.hashmap[idx]

        for element in elements:
            if element[0] == key:
                return element[1] # if key found
        return -1 # if key doesnot exist

    def remove(self, key):
        idx = self.hashfunc(key)

        elements = self.hashmap[idx]

        for i in range(0, len(elements)):
            if elements[i][0] == key:
                del elements[i] # deleting the entire element(key,val) when key exists
                return

# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)