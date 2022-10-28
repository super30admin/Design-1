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

    
