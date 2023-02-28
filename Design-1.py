# Time Complexity : O(log n)
# Space Complexity : O(K + N) (number of buckets + number of nodes in each bucket)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : understanding node deletion in BST

class MyHashSet(object):

    def __init__(self):
        self.keyrange = 523
        self.buckets = [Bucket() for i in range(self.keyrange)]

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        idx = key % self.keyrange
        self.buckets[idx].insert(key)
        

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        idx = key % self.keyrange
        self.buckets[idx].delete(key)
        

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        idx = key % self.keyrange
        return self.buckets[idx].search(key)
        
class Bucket:

    def __init__(self):
        self.treeObj = BST()

    def insert(self,key):
        self.treeObj.root = self.treeObj.insertIntoTree(self.treeObj.root,key)

    def search(self,key):
        return self.treeObj.searchBST(self.treeObj.root,key)

    def delete(self,key):
        self.treeObj.root = self.treeObj.deleteFromBST(self.treeObj.root,key)




class TreeNode:
    def __init__(self,val):
        self.val = val
        self.left = None
        self.right = None

class BST():
    def __init__(self):
        self.root = None

    def insertIntoTree(self, root, val):
        if root is None:
            return TreeNode(val)
        
        if val > root.val:
            root.right = self.insertIntoTree(root.right,val)
        elif val < root.val:
            root.left = self.insertIntoTree(root.left, val)
        else:
            return root
        return root

    def searchBST(self,root,val):
        if root is None:
            return False
        if val > root.val:
            return self.searchBST(root.right,val)
        elif val < root.val:
            return self.searchBST(root.left, val)
        else:
            return True

    def getSuccessor(self,root):
        root = root.right
        # if root:
        while root.left:
            root = root.left
        return root.val

    def getPredecessor(self,root):
        root = root.left
        # if root:
        while root.right:
            root = root.right
        return root.val

    def deleteFromBST(self,root,val):
        if root is None:
            return None

        if val > root.val:
            root.right = self.deleteFromBST(root.right,val)
        elif val < root.val:
            root.left = self.deleteFromBST(root.left, val)
        else:
            if root.left is None and root.right is None:
                return None
            elif root.right:
                root.val = self.getSuccessor(root)
                root.right = self.deleteFromBST(root.right,root.val)
            else:
                root.val = self.getPredecessor(root)
                root.left = self.deleteFromBST(root.left,root.val)
        return root

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)