class MyHashMap:

    def __init__(self):
        """
        Initialize.
        """
        self.store=[Node(-1,-1)]*2000
        
        

    def put(self, key: int, value: int) -> None:
        
        keyMod=key%2000
        newNode=Node(key,value)
        cur=self.store[keyMod]
        Node.insert(cur,newNode)

    def get(self, key: int) -> int:
        """
        Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
        """
        keyMod=key%2000
        cur=self.store[keyMod]
        return Node.search(cur,key)
    
    def remove(self, key: int) -> None:
        """
        Removes the mapping of the specified value key if this map contains a mapping for the key
        """
        keyMod=key%2000
        cur=self.store[keyMod]
        Node.remove(cur,key)
        
class Node:
    def __init__(self,key=0,value=0,nextNode=None):
        self.next=nextNode
        self.val=value
        self.key=key
    def insert(head,node):
        cur=head
        
        while(cur.next!=None):
            if cur.key==node.key:
                cur.val=node.val
                return
            cur=cur.next
        if cur.key==node.key:
            cur.val=node.val
            return
        cur.next=node
    def search(head,key):
        cur=head
        while(cur!=None):
            if cur.key==key:
                return cur.val
            cur=cur.next
        return -1
    def remove(head,key):
        cur=head
        prev=None
        while(cur!=None):
            if cur.key==key:
                prev.next=cur.next
                return
            prev=cur
            cur=cur.next
    

