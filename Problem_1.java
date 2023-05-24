// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes


//The myHashSet class represents a basic implementation of a hash set using a boolean array. 
//Each element in the set is represented by a boolean value (true or false) in the array. 
//The add method sets the corresponding index to true, remove sets it to false, and contains checks if the index is true or false. 
//The class utilizes a fixed-size boolean array initialized with false values to represent the set.

class MyHashSet {
    private boolean[] set;
    
        public MyHashSet() {
            set = new boolean[1000001];
            Arrays.fill(set, false);
        }
    
        public void add(int key) {
            set[key] = true;
        }
    
        public void remove(int key) {
            set[key] = false;
        }
    
        public boolean contains(int key) {
            return set[key];
        }

        public static void main(String[] args) {
            MyHashSet myHashSet = new MyHashSet();
    
            // Adding elements
            myHashSet.add(5);
            myHashSet.add(2);
            myHashSet.add(7);
    
            // Checking for containment
            System.out.println("Contains 5: " + myHashSet.contains(5));  // Output: Contains 5: true
            System.out.println("Contains 3: " + myHashSet.contains(3));  // Output: Contains 3: false
    
            // Removing an element
            myHashSet.remove(2);
    
            // Checking for containment again
            System.out.println("Contains 2: " + myHashSet.contains(2));  // Output: Contains 2: false
            System.out.println("Contains 7: " + myHashSet.contains(7));  // Output: Contains 7: true
        }
    }
   