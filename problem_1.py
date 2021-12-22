class MyHashSet:

    def __init__(self):
        self.hset = [None]*1000

    def get_index(self, val):
        index_1 = val//1000
        index_2 = val - index_1*1000

        return  index_1, index_2

    def add(self, val: int) -> None:
        index_1, index_2 =  self.get_index(val)
        
        if self.hset[index_1] == None:
            self.hset[index_1] = [False]*1000
        
        self.hset[index_1][index_2] = True


    def remove(self, val:int) ->bool:

        index_1, index_2 =  self.get_index(val)

        if self.hset[index_1] != None:
             self.hset[index_1][index_2] = False


    def contains(self, val:int) ->bool:

        index_1, index_2 =  self.get_index(val)

        if self.hset[index_1] == None:
            return False

        else :
            ele = self.hset[index_1][index_2] 
            if ele: return True
            return False