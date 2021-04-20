class Bucket:
    def __init__(self):
        self.bucketlist=[]

    def updatebucket(self,key,value):
        for _idx,kv in enumerate(self.bucketlist):
            if key ==kv[0]:
                self.bucketlist[_idx]=(key,value)
                return
        self.bucketlist.append((key,value))
    def getbucketvalue(self,key):
        for _id,kv in enumerate(self.bucketlist):
            if kv[0]==key:
                return kv[1]
        return -1
    def remove(self,key):
        for id, key in enumerate(self.bucketlist):
            if key[0]==key:
                del self.bucketlist[id]
        return


class dictusingL:
 def __init__(self):
     self.size=1000
     self.bucket = [Bucket() for _idx1 in range(self.size)]

 def gethash(self,key):
     newkey=hash(key)
     return newkey % self.size
 def put(self, key, value):
     current_bucket_index=self.gethash(key)
     self.bucket[current_bucket_index].updatebucket(key,value)
 def get(self,key):
     current_bucket_index=self.gethash(key)
     return self.bucket[current_bucket_index].getbucketvalue()
 def remove(self,key):
     current_bucket_index=self.gethash(key)
     self.bucket[current_bucket_index].remove(key)






 def getitems(self):
     result=[]
     for bucketblock in self.bucket:
         if len(bucketblock.bucketlist) >0:
             result.append(bucketblock.bucketlist)
     return result



class node:
    def __init__(self,key,value,Next=None):
        self.key=key
        self.value=value
        self.Next=None


class dictusingList:
    def __init__(self):
        self.size = 1000
        self.bucket = [None] * self.size
    def getitems(self):
        result=[]
        for bucket1 in self.bucket:
            similar_hash_list=[]
            while bucket1 is not None:
                similar_hash_list.append((bucket1.key,bucket1.value))
                bucket1=bucket1.Next
                result.append(similar_hash_list)

        return result


    def put(self, key, value):
        hashkey=self.gethashkey(key)
        current_bucket=self.bucket[hashkey]
        if current_bucket == None:
            self.bucket[hashkey]=node(key,value)
        else:
            current_iterable=current_bucket
            while current_iterable:
                if current_iterable.key==key:
                    current_iterable.value=value
                    return
                else:
                    current_iterable=current_iterable.next
            current_iterable=node(key,value)


    def gethashkey(self,key):
        newkey=hash(key)
        return newkey % self.size

    def get(self, key):
        hashkey=self.gethashkey(key)
        current_bucket=self.bucket[hashkey]
        if current_bucket is None:
            return
        while current_bucket:
            if current_bucket.key==key:
                return current_bucket.value
            current_bucket=current_bucket.next
        return

    def remove(self, key):
        hashkey=self.gethashkey(key)
        current_bucket=self.bucket[hashkey]
        if current_bucket is None:
            return
        if current_bucket.key==key:
            self.bucket[hashkey]=None
        while current_bucket.Next:
            if current_bucket.Next.key==key:
                current_bucket.Next=current_bucket.Next.Next
                return
            else:
                current_bucket=current_bucket.Next
        return




class executor:
    if __name__ == '__main__':
        hashobject=dictusingList()
        # list =[(123,78),(178,78),(90,78),(90,708),('sunil',8989)]
        # for key, value in list:
        #     hashobject.put(key,value)
        # print(hashobject.getitems())
        # hashobject.remove(123)
        # print(hashobject.getitems())

        hashobject = dictusingL()
        list = [(123, 78), (178, 78), (90, 78), (90, 708), ('sunil', 8989)]
        for key, value in list:
            hashobject.put(key,value)

        print(hashobject.getitems())
        # hashobject.remove(123)
        # print(hashobject.getitems())










