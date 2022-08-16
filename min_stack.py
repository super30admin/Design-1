'''
# MIN - STACK
TIME COMPLEXITY = O(1) - for all the operations
SPACE COMPLEXITY = O(N)
Yes, it passed all the tests in leetcode
Any problems faced - Nothing significant.
'''

class MinStack:

    def __init__(self):
        self.data = []

    def push(self, val: int) -> None:
        cur_min = self.getMin()
        if val < cur_min:
            cur_min = val

        self.data = [(val, cur_min)] + self.data

    def pop(self) -> None:
        self.data = self.data[1:]

    def top(self) -> int:
        return self.data[0][0]

    def getMin(self) -> int:
        if self.data == []:
            return (2 ** 31) - 1
        else:
            return self.data[0][1]

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
null = None

com = ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
in_d = [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
ex_op = [null,null,null,null,2147483647,null,2147483646,null,2147483646,null,null,2147483647,2147483647,null,-2147483648,-2147483648,null,2147483647]

com = ["MinStack","push","push","getMin","getMin","push","getMin","getMin","top","getMin","pop","push","push","getMin","push","pop","top","getMin","pop"]
in_d = [[],[-10],[14],[],[],[-20],[],[],[],[],[],[10],[-7],[],[-7],[],[],[],[]]
ex_op = [null,null,null,-10,-10,null,-20,-20,-20,-20,null,null,null,-20,null,null,-7,-20,null]


for e_c, e_i, e_o in zip(com, in_d, ex_op):
    if e_c == 'MinStack':
        obj = MinStack()
    elif e_c == 'push':
        obj.push(e_i[0])
    elif e_c == 'pop':
        obj.pop()
    elif e_c == 'top':
        val = obj.top()
    elif e_c == 'getMin':
        val = obj.getMin()
        print(val)

