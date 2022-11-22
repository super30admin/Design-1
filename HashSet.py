#Time Complexity : O(1)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Your code here along with comments explaining your approach
#used aray and linked list concept to add and remove
#can alo use dictionary

class MyHashSet:
    def __init__(self):
        self.newhash = []

    def add(self, key: int) -> None:
        if key not in self.newhash:
            self.newhash.append(key)

    def remove(self, key: int) -> None:
        if key in self.newhash:
            self.newhash.remove(key)

    def contains(self, key: int) -> bool:
        if key in self.newhash:
            return True
        else:
            return False
    

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)