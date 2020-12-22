// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class MyHashMap {
    int keyval = 3000;
    int key;
    int value;
    
    List<Index> hash; 
    MyHashMap() {
        this.hash = new ArrayList<Index>();
        for(int i=0; i<this.keyval; i++)
        {
            this.hash.add(new Index());
        }
    }
    public void put(Integer key, Integer value)
    {
        this.key = key % keyval;
        this.hash.get(this.key).add(key,value);
    }
    public int get(Integer key)
    {
        this.key = key % keyval;
        return (this.hash.get(this.key).peek(key));
    }
    public void remove(Integer key)
    {
        this.key = key % keyval;
        this.hash.get(this.key).delete(this.key);
    }
}

class Pair<Key,Value>{
    Key k;
    Value v;
    public Pair(Key k, Value v)
    {
        this.k = k;
        this.v = v;
    }
}

class Index
{
    List<Pair<Integer, Integer>> hashcode;

    public Index()
    {
        this.hashcode = new LinkedList<Pair<Integer, Integer>>();
    }

    public void add(int key, int val)
    {
        boolean update = false;
        for (Pair<Integer, Integer> pair: this.hashcode)
        {
            if(pair.k.equals(key))
            {
                pair.v = val;
                update = true;
                break;
            }
        }
        if(!update)
        {
            this.hashcode.add(new Pair<Integer, Integer>(key,val));
        }
    }

    public void delete(int key)
    {
        for(Pair<Integer,Integer> pair: this.hashcode)
        {
            if(pair.k.equals(key))
            {
                this.hashcode.remove(pair);
                break;
            }
        }
    }

    public int peek(int key)
    {
        for(Pair<Integer,Integer> pair: this.hashcode)
        {
            if(pair.k.equals(key))
            {
                return pair.v;
            }
        }
        return -1;
    }
}


