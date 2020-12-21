//Time Complexity: O(1) for get(), put() and remove()
//Space Complexity: O(n) where n is the maximum key 

//Successful on leetcode
//Problem: Tried to think of a better solution that does not depend on size of the array, but could not think of any

//Approach: This solution makes the use of a large sized array which can be a limitation


import java.util.Arrays;
class MyHashMap {
    
    int map[];

    public MyHashMap()
    {
        map = new int[1000001];
        Arrays.fill(map,-1);
    }

    public void put(int key, int value)
    {
        map[key] = value;
    }

    public int get(int key) {
        if(map[key] != -1)
            return map[key];
        else
            return -1;
    }

    public void remove(int key) {
        map[key] = -1;
    }
}

class Main { 
    public static void main(String args[]) 
    { 
       MyHashMap myHashMap = new MyHashMap();
       myHashMap.put(1,2);
       myHashMap.put(2,3);
       int first = myHashMap.get(1);
       System.out.println(first);
       int second = myHashMap.get(3);
       System.out.println(second);
       myHashMap.put(2,4);
       int third = myHashMap.get(2);
       System.out.println(third);
       myHashMap.remove(2);
       int forth = myHashMap.get(2);
       System.out.println(forth);
    } 
}
