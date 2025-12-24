"""
// Time Complexity :
    add - o(n)
    remove - o(n)
    contains - 0(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, made an error in contains but managed to correct the error
"""


class Node:
    def __init__(self, val, nxt=None, prev=None):
        self.val = val
        self.next = nxt
        self.prev = prev


class MyHashSet:

    def __init__(self):
        self.prime_mod = 997
        self.set_list = [None] * self.prime_mod

    def add(self, key: int) -> None:
        index = key % self.prime_mod
        val_node = Node(key)
        if ptr := self.set_list[index]:
            while ptr:
                if ptr.val == key:
                    return
                if not ptr.next:
                    ptr.next = val_node
                    val_node.prev = ptr
                    return
                ptr = ptr.next
        else:
            dummy = Node(None)
            dummy.next = val_node
            val_node.prev = dummy
            self.set_list[index] = dummy

    def remove(self, key: int) -> None:
        index = key % self.prime_mod
        if head := self.set_list[index]:
            ptr = head.next
            while ptr:
                if ptr.val == key:
                    prev = ptr.prev
                    nxt = ptr.next
                    prev.next = nxt
                    if nxt:
                        nxt.prev = prev
                    if prev == head and not head.next:
                        self.set_list[index] = None
                    return
                ptr = ptr.next

    def contains(self, key: int) -> bool:
        index = key % self.prime_mod
        if head := self.set_list[index]:
            ptr = head.next
            while ptr:
                if ptr.val == key:
                    return True
                ptr = ptr.next
        return False
