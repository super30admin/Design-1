# Time Complexity :
#   put: 
#       O(1) [Best case -> There is no or minimal collision]
#       O(n) [Worst case -> All keys inserted generate the same hash code] 
#   get:
#       O(1) [Best case -> The first element in the hash code linked list is the required element]
#       O(n) [Worst case -> All keys inserted generate the same hash code. The first element in the hash code linked list is the required element]
#   remove: O(1)
#       O(1) [Best case -> The first element in the hash code linked list is the required element]
#       O(n) [Worst case -> All keys inserted generate the same hash code. The first element in the hash code linked list is the required element]
# 
# Space Complexity : O(n) [n is the number of elements inserted into Map]
# 
# Did this code successfully run on Leetcode : Yes
# 
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
# 1. Initialize a <hashmap> list with 10 NULL values. Use MOD 10 value of the input key to generate hash code[0-9]. The hash code generation function used is quite simple. In a real time scenario it should be such that the chances of collision are negligible.
# 2. Each index of the <hashmap> hold a Linked list which containes nodes of type <HashNode>
# 3. Approach for each faeture
#   3.1 put() -> If the list at the hashcode index is N
#   3.2 get() ->
#   3.3 remove() -> 
class HashNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None

class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.hashmap = [None for i in range(10)] 
        

    def getHashCode(self, key):
        return key % 10
    
    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        hashcode = self.getHashCode(key)
        if None == self.hashmap[hashcode]:
            self.hashmap[hashcode] = HashNode(key, value)
        else:
            p = self.hashmap[hashcode]
            if p.next is None:
                if p.key == key:
                    p.value = value
                else:
                    p.next = HashNode(key, value)
                return
            while p.next is not None:
                if p.key == key:
                    p.value = value
                    return
                p = p.next
            if p.key == key:
                p.value = value
            else:
                p.next = HashNode(key, value)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        hashcode = self.getHashCode(key)
        if self.hashmap[hashcode] is None:
            return -1
        p = self.hashmap[hashcode]
        while p is not None:
            if p.key == key:
                return p.value
            p = p.next
        return -1
         

    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        hashcode = self.getHashCode(key)
        if self.hashmap[hashcode] is not None:
            p = self.hashmap[hashcode]
            if p.key == key:
                if p.next is None:
                    self.hashmap[hashcode] = None
                else:
                    self.hashmap[hashcode] = p.next
                return
            else:
                while p.next is not None:
                    if p.next.key == key:
                        p.next = p.next.next
                        return
                    p = p.next
                        


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)


"""
Test case 1

["MyHashMap","put","put","get","get","put","get", "remove", "get","put","put","put","get","get","get","remove","get","get","get"]
[[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2],[23,230],[3,30],[13,130],[23],[3],[13],[23],[3],[13],[23]]

Test case 2

["MyHashMap","put","put","get","get","put","get", "remove", "get","put","put","put","get","get","get","remove","get","get","get"]
[[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2],[23,230],[3,30],[13,130],[23],[3],[13],[3],[3],[13],[23]]

Test case 3

["MyHashMap","put","put","get","get","put","get", "remove", "get","put","put","put","get","get","get","remove","get","get","get"]
[[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2],[23,230],[3,30],[13,130],[23],[3],[13],[13],[3],[13],[23]]

"""