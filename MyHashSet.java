public class MyHashSet {
    
/**Time Complexity : O(1)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
1.	Using Array to implement HashSet.
2.	Initialized a Boolean array in MyHashSet function. The size selected was as per the size limit mentioned, which is 0<=k<=10^6.
3.	When a new key is added, the add function will be true. This will add the element to the Array.
4.	When a new key is removed, the add function will be false. This will remove the element from Array.
5.	To implement contains function of HashSet, the contains method will return true if the entered key value is present in the Array and false if the element is not there.
**/
 
    public boolean[] set;

    public MyHashSet() {
        set = new boolean[1000001];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key]=false;
    }

    public boolean contains(int key) {
        return set[key];
    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
    }
}




