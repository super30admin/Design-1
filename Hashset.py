class MyHashSet:

    def __init__(self):
        self.mod = 769
        self.bucket = [Bucket() for i in range(self.mod)]

    def add(self, key: int) -> None:
        i = self.hash(key)
        self.bucket[i].insert(key)

    def remove(self, key: int) -> None:
        i = self.hash(key)
        self.bucket[i].delete(key)
        
        
        

    def contains(self, key: int) -> bool:
        i = self.hash(key)
        return self.bucket[i].search(key)
        
    def hash(self,val):
        return val% self.mod
    
class Bucket:
    def __init__(self):
        self.tree = BSTree()
    def insert(self, value):
        self.tree.root = self.tree.insert(self.tree.root, value)

    def delete(self, value):
        self.tree.root = self.tree.delete(self.tree.root, value)

    def search(self, value):
        return (self.tree.searchBST(self.tree.root, value) is not None)
        
        
class Node:
    def __init__(self,value):
        self.value = value
        self.left= None
        self.right = None
        
class BSTree:
    def __init__(self):
        self.root = None
        
    def searchBST(self,root,val):
        if not root or root.value ==val:
            return root
        return self.searchBST(root.left,val) if root.value>val else self.searchBST(root.right,val)
    
    
    def insert(self,root,val):
        if not root:
            return Node(val)
        
        if val>root.value:
            root.right = self.insert(root.right,val)
        elif val<root.value:
            root.left = self.insert(root.left,val)
        else:
            return root
        return root
    def successor(self,root):
        while root.left:
            root = root.left
        return root.value
    def predecessor(self,root):
        while root.right:
            root= root.right
        return root.value
    def delete(self,root,val):
        if not root:
            return None
        
        if val> root.value:
            root.right = self.delete(root.right,val)
        elif val <root.value:
            root.left = self.delete(root.left,val)
        else:
            if not (root.left or root.right):
                root = None
            elif root.right:
                root.value = self.successor(root.right)
                root.right = self.delete(root.right,root.value)
            else:
                root.value = self.predecessor(root.left)
                root.left = self.delete(root.left,root.value)
                
        return root


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
