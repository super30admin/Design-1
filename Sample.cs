// Time Complexity : O(1)
// Space Complexity :O(n) - 1bit is allocated per key
// Did this code successfully run on Leetcode : Yes

// Any problem you faced while coding this :

//Yes I had to spend some time on understanding how the hashing works, I havent yet implemented solution with Linkedlist and hashing technique.

// Your code here along with comments explaining your approach
// I have used BitArray since it slightly saves your memory than bool[] , 
// if the size of the data is unknown then array is not the feasible option
// we should be using linkedlist and hashing techniques 
//but to do that I need some time to understand that concept so I will take some time to implement that approach.


public class MyHashSet
{
    //bool[] arr;
    BitArray arr;
    public MyHashSet()
    {
        // arr = new bool[1_000_001];
        arr = new BitArray(1000001);
    }

    public void Add(int key)
    {
        arr[key] = true;
    }

    public void Remove(int key)
    {
        arr[key] = false;
    }

    public bool Contains(int key)
    {
        return arr[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */
