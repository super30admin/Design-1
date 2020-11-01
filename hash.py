"""
Used open addressing.
"""


class ListNode:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.next = None

class MyHashMap:

    def __init__(self):
        self.volumn = 2000
        self.cache = [None] * self.volumn


    def put(self, key: int, value: int) -> None:
        pseudo = key % self.volumn
        cur = self.cache[pseudo]
        if cur:
            while True:
                if cur.key == key:
                    cur.val= value
                    return
                elif cur.next == None:
                    cur.next = ListNode(key,value)
                    break
                else:
                    cur = cur.next

        else:
            self.cache[pseudo] = ListNode(key,value)

    def get(self, key: int) -> int:
        pseudo = key % self.volumn
        cur = self.cache[pseudo]
        if cur:
            while cur:
                if cur.key == key:
                    return cur.val
                else:
                    cur = cur.next
        return -1



    def remove(self, key: int) -> None:
        pseudo = key % self.volumn
        cur = self.cache[pseudo]
        if cur:
            dummy = ListNode(None,None)
            dummy.next = cur
            ans = dummy
            while cur:
                if cur.key == key:
                    dummy.next = cur.next
                    self.cache[pseudo] = ans.next
                    break
                else:
                    dummy, cur = cur, cur.next
