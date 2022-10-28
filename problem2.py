#Time complexity - O(1) for all operations
#Space omplexity - O(n)
#Run on leetcode? yes
#The approach here is to maintain a tuple of (element, min_element) in the stack. When pushing an element, chcek whether the current
# element that is being pushed is minimum(this can be found by comparing with the minimum element so far in the stack which would be 
#  in index 1 of topmost tuple) and push accordingly. After each push, the minimum element so far will be in index 1 of the top
# most tuple.

class MinStack:

    def __init__(self):
        self.stk=[]
        

    def push(self, val: int) -> None:
        if(self.stk==[]):
            self.stk.append((val,val))
        else:
            m=min(val,self.stk[-1][1])
            self.stk.append((val,m))
        

    def pop(self) -> None:
        if(self.stk!=[]):
            del(self.stk[-1])
        


    def top(self) -> int:
        if(self.stk!=[]):
            return(self.stk[-1][0])
        return None
        

    def getMin(self) -> int:
        if(self.stk!=[]):
            return(self.stk[-1][1])
        return None

st=MinStack()
while(True):
    s=input("enter option 1-push, 2-pop, 3-top, 4-getmin, 5-quit")
    if(s=="5"):
        break
    if(s=="1"):
        ip=input("enter the number")
        st.push(int(ip))
    if(s=="2"):
        st.pop()
    if(s=="3"):
        print(st.top())
    if(s=="4"):
        print(st.getMin())

    
