
class MyHashSet:

    def __init__(self):
        self.L=[[]]*1000
        

    def add(self, key: int) -> None:
        ind=key%1000
        curr=self.L[ind]
        if(key not in curr):
            curr.append(key)
        

    def remove(self, key: int) -> None:
        ind=key%1000
        curr=self.L[ind]
        for i in range(len(curr)):
            if(curr[i]==key):
                del(curr[i])
                break
        
    def contains(self, key: int) -> bool:
        ind=key%1000
        curr=self.L[ind]
        if(key in curr ):
            return True
        else:
            return False
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
hashset=MyHashSet()
while(True):
    s=input("enter option 1-add, 2-reomve, 3-contains, 4-quit")
    ip=input("enter the number")
    if(s=="1"):
        hashset.add(int(ip))
    if(s=="2"):
        hashset.remove(int(ip))
    if(s=="3"):
        print(hashset.contains(int(ip)))
    if(s=="4"):
        break
