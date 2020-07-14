# Time Complexity : Hash map: O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : it runs in IDE, but fails in leetcode
# Any problem you faced while coding this : No


class ListNode:

    def __init__(self, key, value, next=None):
        """
        Initialize your data structure here.
        """
        self.key = key
        self.value = value
        self.next = next


class MyHashMap:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.Hashmap = [None] * 1000

    def put(self, key: int, value: int) -> None:
        """
        value will always be non-negative.
        """
        index1 = key % len(self.Hashmap)
        index2 = key // len(self.Hashmap)

        if self.Hashmap[index1] == None:  # if nothing exists
            self.Hashmap[index1] = ListNode(key, value)

        else:
            get_key = 0
            current = self.Hashmap[index1]

            while current:
                if get_key != index2:
                    get_key +=1
                    current = current.next


            current = ListNode(key, value)
            self.Hashmap[index1].next = current

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        index1 = key % len(self.Hashmap)
        index2 = key // len(self.Hashmap)
        if self.Hashmap[index1] == None:
            return -1
        else:
            current = self.Hashmap[index1]

            get_key = 0
            while current:
                if get_key != index2:
                    get_key += 1
                    current = current.next
                else:
                    return current.value




    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        index1 = key % len(self.Hashmap)
        index2 = key // len(self.Hashmap)
        if self.Hashmap[index1] == None:
            return -1
        else:
            current = self.Hashmap[index1]
            prev = current
            get_key = 0

            while current:
                if get_key != index2:
                    get_key += 1
                    prev = current
                    current = current.next
                else:
                    prev.next = current.next
                    current = current.next
                    return

# Your MyHashMap object will be instantiated and called as such:
obj = MyHashMap()
obj.put(0,0)
obj.put(1,1)
obj.put(1000,1)
param = obj.get(1)
param = obj.get(3)
obj.put(2,1)
param = obj.get(2)
obj.remove(2)
param = obj.get(2)

print("Done")