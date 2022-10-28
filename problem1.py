
#Time complexity - O(1) for all operations
#Space complexity - O(n) where n=1000
#Did it run on leetcode: Yes
# approach: have a list L of 1000 elements. The constraints state that the values can range from 0 to 10^6. So the list size will be 10^3
# and each element in list will be a list which can will contain the elements. The hash function is designed such that the size of list 
# in each element in L can not be greater than 2. Since the values range from 0 to 10^6 and the size of L is 10^3, while hasing with mod 
# 1000, each eleemnt in L can contain 2 elements at max.

class MyHashSet:

    def __init__(self):
        self.L=[None]*1000
        

    def add(self, key: int) -> None:
        ind=key%1000
        #curr=self.L[ind]
        if(self.L[ind]==None):
            if(ind==0):
                self.L[ind]=[False]*1001
            else:
                self.L[ind]=[False]*1000
        ind1=key//1000
        self.L[ind][ind1]=True
        
        

    def remove(self, key: int) -> None:
        ind=key%1000
        ind1=key//1000
        if(self.L[ind]!=None):
            self.L[ind][ind1]=False
        
        
    def contains(self, key: int) -> bool:
        ind=key%1000
        if(self.L[ind]==None):
            return False
        else:
            ind1=key//1000
            return self.L[ind][ind1]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
hashset=MyHashSet()
while(True):
    s=input("enter option 1-add, 2-reomve, 3-contains, 4-quit")
    if(s=="4"):
        break
    ip=input("enter the number")
    if(s=="1"):
        hashset.add(int(ip))
    if(s=="2"):
        hashset.remove(int(ip))
    if(s=="3"):
        print(hashset.contains(int(ip)))
    
