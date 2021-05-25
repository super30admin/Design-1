// Time Complexity: O(n) in worst case when all the n elements have same hashKey.  we have to traverse all the pairs using .next for put,get and remove.
// Space Complexity: Constant space complexity max 1000001 or O(n) --> get the doubt clarified
class MyHashMap {

    KVpair[] map;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map=new KVpair[1000001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey=hash(key);
        KVpair pair=new KVpair(key,value);

        if(map[hashKey]==null)
        {
            map[hashKey]=pair;
        }
        else
        {
            KVpair newpair=map[hashKey];
            while(newpair!=null)
            {
                if(newpair.key==key)
                {
                    newpair.value=value;
                    return;
                }
                newpair=newpair.next;
            }
            newpair=pair;
        }


    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashKey=hash(key);

        if(map[hashKey]!=null)
        {
            KVpair newpair=map[hashKey];
            while(newpair.key!=key)
                newpair=newpair.next;
            return newpair.value;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashKey=hash(key);
        if(map[hashKey]!=null)
        {
            KVpair newpair=map[hashKey];
            while(newpair.key!=key)
                newpair=newpair.next;
            newpair.value=-1;;
        }

    }


    public int hash(int code)
    {
        return code % 1000001;
    }
}

class KVpair
{
    int key;
    int value;
    KVpair next;

    public KVpair(int key, int v)
    {
        this.key=key;
        this.value=v;
        next= null;
    }
}
