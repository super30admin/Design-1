# Time Complexity : o(n)
# Space Complexity :o(n) -> number of elements in self.list1
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : None

class MyHashSet:

    # initializing list, which refers to the elements that are added and the operations we do
    def __init__(self):
        self.list1 = []

    # add method checks whethe the key is present in list, if key is not present then only it weill be added
    # Time complexity is O(n) in worst case as it has to check till the end of the array(length of the array)
    def add(self, key: int) -> None:
        if key not in self.list1:
            self.list1.append(key)

    # remove will check whether the key is present, and if present it will pop the key
    # Time complexity is O(n) in worst case as it has to check till the end of the array(length of the array)
    def remove(self, key: int) -> None:
        if key in self.list1:
            self.list1.pop(self.list1.index(key))

    # It returns boolean value checks whether value is present or not
    def contains(self, key: int) -> bool:
        if key in self.list1:
            return True
        else:
            return False


# Initializing and calling MyHashSet
obj = MyHashSet()
obj.add(1)
obj.add(2)
x = obj.contains(1)
print(x)
y = obj.contains(3)
print(y)
obj.add(2)
z = obj.contains(2)
print(z)
obj.remove(2)
a = obj.contains(2)
print(a)
