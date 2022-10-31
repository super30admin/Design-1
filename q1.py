# Time Complexity : O(1)
# Space Complexity : O(10^6)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Not anything particular
class MyHashSet:

    def __init__(self):
        #According to our we have to create a primary array of 1000 elements
        self.p=[None for i in range(1000)]
        self.rows=1000
        self.columns=1000
        #print(self.p)
    
    #Primary hash function
    def h1(self,key: int)->int:
        return key%1000
    #Secondary hash function
    def h2(self,key: int)->int:
        return key//1000
    
    def add(self, key: int) -> None:
        row=self.h1(key)
        col=self.h2(key)
        #print(row)
        #print(col)    
        if(self.p[row]==None):
            #Here the columns are not present in the row, Therefore we have to create columns and then add the element
            if(row==0):
                #This is an edge case to accomadate the Key "10^6"
                self.p[row]=[False for i in range(self.columns + 1)]
            else:    
                self.p[row]=[False for i in range(self.columns)]
            self.p[row][col]=True
            return
        self.p[row][col]=True
        

    def remove(self, key: int) -> None:
        row=self.h1(key)
        col=self.h2(key)
        if(self.p[row]==None):
            #Here the coulmns are not present in the row, Therefore we can directly return
            return
        self.p[row][col]=False
    
    def contains(self, key: int) -> bool:
        row=self.h1(key)
        col=self.h2(key)
        if(self.p[row]==None):
            #Here the coulmns are not present in the row, Therefore we can directly return False
            return False
        return self.p[row][col]
        

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(1)
# obj.remove(key)
# param_3 = obj.contains(key)