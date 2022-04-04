# // Time Complexity : O(1)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes, in the push function I missed checking for an empty stack initially.
# Later fixed it by adding a condition
class Node(object):
    def __init__(self, key, value, next=None):
        self.key = key
        self.value = value
        self.next = next


class MyHashMap(object):

    def __init__(self):
        self.bucket_size = 10000
        self.nodes = [None] * self.bucket_size

    def find(self, head, key):
        prev = head
        current = head
        while current:
            if key == current.key:
                return prev
            prev = current
            current = current.next
        return prev

    def gethash(self, key):
        return key % self.bucket_size

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: None
        """

        index = self.gethash(key)
        if self.nodes[index] is None:
            # create a new dummy
            dummy_node = Node(-1, -1)
            self.nodes[index] = dummy_node
        prev = self.find(self.nodes[index], key)
        if prev.next is None:
            prev.next = Node(key, value)
        else:
            prev.next.value = value

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        # print("get", key)
        index = self.gethash(key)
        if self.nodes[index] is None:
            return -1
        prev = self.find(self.nodes[index], key)
        if prev.next is None:
            return -1
        else:
            return prev.next.value

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        # print("remove", key)
        index = self.gethash(key)
        if self.nodes[index] is None:
            return
        prev = self.find(self.nodes[index], key)
        if prev.next is None:
            return
        else:
            prev.next = prev.next.next


# Your MyHashMap object will be instantiated and called as such:
# obj = MyHashMap()
# obj.put(key,value)
# param_2 = obj.get(key)
# obj.remove(key)
