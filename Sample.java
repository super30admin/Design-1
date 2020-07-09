// Time Complexity :O(N/K)
// Space Complexity :O(N+K)
where N is no of pre defined buckets and K is number of unique elements pushed to hashmap
// Did this code successfully run on Leetcode :yes  
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


class listNode:

    def __init__(self, key, data, next=None):
        self.key=key
        self.data=data
        self.next=next

class hashMap:

    def __init__(self):
          self.array= [None] * 1000
        
    
    def get(self, key):
        newKey=self.getKey(key)

        prev= self.findElement(newKey, key)

        if prev.next==None:
            return -1
        else:
            return prev.next.data
    
    def remove(self, key):

        newKey=getKey(key)

        prev= findElement(newKey, key)

        if prev.next==None:
            return -1
        else:
            prev.next = prev.next.next




    def put(self, key, value):
        newKey=self.getKey(key)

        if self.array[newKey]==None:
            self.array[newKey]=listNode(key, value)
        else:
            prev= findElement(newKey, key)

            if prev.next== None:
                prev.next= listNode(key, value)
            else:
                prev.next.data=value

    def getKey(self, key):
        return key%1000


    def findElement(self, key, newKey):
        if self.array[newKey]==None:
            return listNode(-1,-1)
        else:
            temp=self.array[newKey]
        while(temp.next!=None and temp.next.key!=key):
            temp=temp.next
        return temp




map1= hashMap()


map1.put(999,3)
print(map1.get(999))



// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


'''
  1. I implemented the stack using a list
  2. used only one stack for storing the new data and minimum element till the time
  3. will push the min element only if the new element is less than or equal to the minimum element
  4. while popping, we will check if the top element is same as the minimum element, in that case we will pop the minimum element too and update the 
  minimum element only if the popped element is equal to the minimum value
'''
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.storage=[]
        self.index=0
        self.minima=None
        

    def push(self, x: int) -> None:
        if self.minima==None:
            self.minima=x
        
        if x<=self.minima:
            
            self.storage.append(self.minima)
            self.minima=x
            
        self.storage.append(x)

        

    def pop(self) -> None:
        popped=self.storage.pop()
        if popped==self.minima:
            self.minima=self.storage.pop()
            


    def top(self) -> int:
        if len(self.storage)>0:
            return self.storage[len(self.storage)-1]
        else:
            return 0
        

    def getMin(self) -> int:
        return self.minima
        
