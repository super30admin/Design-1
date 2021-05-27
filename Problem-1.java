
class MyHashMap
{
    int[] map;

    public MyHashMap()
	{
        map = new int[1000001];
        Arrays.fill(map,-1);
    }
	
    public int get(int key)
	{
        return map[key];
    }
    
	public void put(int key, int value)
	{
        map[key] = value;
    }
    
	public void remove(int key)
	{
        map[key] = -1;
    }
}
/**
Time complexity: O(1) - for all get(),put() and remove() methods.
Space complexity: O(n) - where n is the maximum possible value for the key.
**/