# Time complexity is O(1) and space complexity is O(n)
# was able to run on leetcode
# Initializing the Linkedlist
class ListNode:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.next = None


class MyHashMap:
    # Initializing the hashmap
    def __init__(self):
        self.size = 10000
        self.hashmap = [None]*self.size

    def put(self, key: int, value: int) -> None:
        # finding the index
        index = key % self.size
# Creating the new node if there is nothing in the hashmap
        if self.hashmap[index] == None:
            self.hashmap[index] = ListNode(key, value)
        else:
            # If there is something in the hashmap traversing to see whether we have same key, if same key is present updating its value to new one otherwise creating new node
            cur_node = self.hashmap[index]

            while cur_node:
                if cur_node.key == key:
                    cur_node.value = value
                    return
                if cur_node.next == None:
                    break
                cur_node = cur_node.next
            cur_node.next = ListNode(key, value)

    def get(self, key: int) -> int:
        # finding the index
        index = key % self.size
# Assigning it to current node
        cur_node = self.hashmap[index]
# Traversing to see if we have key present and returning its value
        while cur_node:
            if cur_node.key == key:
                return cur_node.value
            else:
                cur_node = cur_node.next

# if we dont find the key returning -1
        return -1

    def remove(self, key: int) -> None:
        # finding the index
        index = key % self.size
# Assigning it to current and previous node
        cur_node = prev_node = self.hashmap[index]
# if no node is present return node
        if not cur_node:
            return None
# if node is found at first place removing it
        if cur_node.key == key:
            self.hashmap[index] = cur_node.next
        else:
            # Traversing to see if next node has the same key, if found deleting it and updating the previous and current nodes to next
            cur_node = cur_node.next
            while cur_node:
                if cur_node.key == key:
                    prev_node.next = cur_node.next
                    break
                else:
                    prev_node, cur_node = prev_node.next, cur_node.next
