class MyHashSet:
    """
        Time Complexity: 
            add: O(1)
            remove: O(1)
            contains: O(1)
        Approach:
            -We will create an array of size (square root of max key value)
            To make sure we optimize on space. In doing so, we will have collision 
            since we can't add 1 Million keys in 1000 indexes
            - To Address this, each index will point to a seperate list of 1000 indexes
            - Each of these sublist will contain a value of particular modulo operation 
                - For eg: Oth index sublist will contain - 0, 1000, 2000, 3000 --- 100000
                    - 0 will be at 0th index 
                    - 1000 will be at 1st index and so on 
            That way we can add all the numbers from 0 to 1 Million without worrying for collision

            - Initalize an array of len 1000 with val = None
            add function
                - get index of the key to be stored
                - see if there is a list created at the index
                    - if not then create a list of
                        - Make sure to create a list of length + 1 for zeroth index
                        as the range is from 0 - 1000000. so we will have one more key at that index
                        - for every other index create an index of length 1000
                - Make the value at the particular index of the sublist to be 1 

            remove function
                - get index of the key
                - if no list at that particular index then don't do anything 
                - else go to the index of the sublist and make value 0
            
            contains:
                - get index of the key
                - if no list at the particular index return False
                - if there is a list and if the value is 1 at the particular index 
                then return True
    """
    def __init__(self):
        self.len = 1000
        self.hashSet = [None] * self.len        

    def add(self, key: int) -> None:
        ind = key % self.len
        if self.hashSet[ind] == None:
            if ind == 0:
                self.hashSet[ind] = [0] * (self.len + 1)
            else:
                self.hashSet[ind] = [0] * self.len
        self.hashSet[ind][int(key/self.len)] = 1

    def remove(self, key: int) -> None:
        ind = key % self.len
        if self.hashSet[ind] != None:
            self.hashSet[ind][int(key/self.len)] = 0        

    def contains(self, key: int) -> bool:
        ind = key % self.len
        if self.hashSet[ind] != None:
            if self.hashSet[ind][int(key/self.len)] == 1:
                return True
        return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)