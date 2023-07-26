
//Problem 1 Hash set
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
 // Difficulty in coding contains function, but got it. Need to be optimise in Time and Space complexity

// Your code here along with comments explaining your approach
/*  
Approach is Initialize with list. Function add started with none key if key is not present just append it.
Similarly, For remove if key is present remove it.
Contains function returns true if key is present in hashset.
*/
class MyHashSet:
    def __init__(self): 
        self.hashset=[] // empty list

    def add(self, key: int) -> None:
        if not self.contains(key):
            self.hashset.append(key) // Appending when key is not present

    def remove(self, key: int) -> None:
        if self.contains(key): 
            self.hashset.remove(key) // Removing key is present in list

    def contains(self, key: int) -> bool:
        return True if key in self.hashset else False // returns true when key is present
