// Time Complexity : O(1), as we are accessing an array element by index for each method
// Space Complexity : O(n) where n is the total number of keys
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


class MyHashSet {

    int MAX_LENGTH = 1000001;
    boolean[] setArray = new boolean[MAX_LENGTH];

    public MyHashSet()
    {

    }

    public void add(int key)
    {
        if(! setArray[key])
        {
            setArray[key] = true;
        }
    }

    public void remove(int key)
    {
        setArray[key] = false;
    }

    public boolean contains(int key)
    {
        return setArray[key];
    }

    public static void main(String[] args)
    {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.contains(1);
        obj.add(2);
        obj.remove(1);
        obj.contains(1);
    }
}


