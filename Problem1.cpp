// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach
class MyHashSet {
public:
    vector<int> v; // Use a vector to represent a HashSet with fixed size.
    MyHashSet() {
        v.resize(1000000 + 10, 0); // Initialize the vector with zeros, representing an empty HashSet.
    }

    void add(int key) {
        v[key] = 1; // Set the value at the key index to 1 to add the element to the HashSet.
    }

    void remove(int key) {
        v[key] = 0; // Set the value at the key index to 0 to remove the element from the HashSet.
    }

    bool contains(int key) {
        return v[key] == 1; // Check if the value at the key index is 1 to determine if the element is in the HashSet.
    }
};
