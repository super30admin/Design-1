// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : In contains method i ran into a mistake
//was trying to return this.storage[hash1()][hash2()] -> this gave error as when the secoundry bucket is not create it will hold undefined, later corrected it

//# Design-1

//## Problem 1:(https://leetcode.com/problems/design-hashset/)

var MyHashSet = function() {
    //Can clarify these below requirments from the interviewer according to thier needs 
    //if fixed size then Double hasing
    //if sparse data then chaining with LL -> adv non contigious
    this.bucket = 1000
    this.bucketElements = 1000
    this.storage = new Array(this.bucket)
};

/** 
 * @param {number} key
 * @return {void}
 */

MyHashSet.prototype.hash1 = function(key) {
    //Time Complexity : O(1)
    //Space Complexity : O(1)
    //A hash that will return the mod and get us to the primary index
    return key % this.bucket
};

MyHashSet.prototype.hash2 = function(key) {
        //Time Complexity : O(1)
    //Space Complexity : O(1)
    // A hash that will return us the secoundary index 
    return Math.floor(key / this.bucket);
};

MyHashSet.prototype.add = function(key) {
        //Time Complexity : O(1)
    //Space Complexity : O(1) 
    //! SUre we are adding here a array to store it but its value is already defined and we know its range is gonna be from x to y so its not increasing with the input, we are always UNDER the best cases bases and hence, it is a O(1) space 
    //first calulcate the hash and check if its free to place in
    let i = this.hash1(key) // i is representing the index of primary array
    let newSize = i == 0 ? this.bucketElements+1:this.bucketElements
    //check if we have if yes -> thats a collision -> create a new array ->
    //and place in its index -> make it true
    if(!this.storage[i]){
        //its empty
        this.storage[i] = new Array(newSize).fill(false)
    }
    //Add the element 
    this.storage[i][this.hash2(key)] = true

};

MyHashSet.prototype.remove = function(key) {
        //Time Complexity : O(1)
    //Space Complexity : O(1)
    // check if present 
    // if yes then make it true or false
    if(!this.storage[this.hash1(key)]){
        //the pirmary array itself is empty so no point in checking it
        return false
    }
    else{
        //found in primary array 
        //so set the existing true to false
        this.storage[this.hash1(key)][this.hash2(key)] = false
    }
    
};

MyHashSet.prototype.contains = function(key) {
        //Time Complexity : O(1)
    //Space Complexity : O(1)
    //Return the value at the secoundry index
    let bucket = this.storage[this.hash1(key)];
    if (!bucket) return false;
    return bucket[this.hash2(key)];
};

// // HashSet using Linked List
// function ListNode(val) {
//     this.val = val;
//     this.next = null;
// }
// var MyHashSetLL = function() {
//     this.buckets = 1000;
//     this.storage = Array(this.buckets).fill(null);
// };
// MyHashSetLL.prototype.hash = function(key) {
//     return key % this.buckets;
// };
// MyHashSetLL.prototype.add = function(key) {
//     let i = this.hash(key)
//     let head = this.storage[i];
//     let curr = head;
//     while (curr) {
//         if (curr.val === key) return;  // already present
//         curr = curr.next;
//     }
//     let newNode = new ListNode(key);
//     newNode.next = head;
//     this.storage[i] = newNode;
// };

// MyHashSetLL.prototype.remove = function(key) {
//     let i = this.hash(key) 
//     let dummy = new ListNode(0);
//     dummy.next = this.storage[i];
//     let prev = dummy 
//     let curr = dummy.next;
//     while (curr) {
//         if (curr.val === key) {
//             prev.next = curr.next;
//             break;
//         }
//         prev = curr;
//         curr = curr.next;
//     }
//     this.storage[i] = dummy.next;
// };

// MyHashSetLL.prototype.contains = function(key) {
//     let i = this.hash(key);
//     let curr = this.storage[i];
//     while (curr) {
//         if (curr.val === key) return true;
//         curr = curr.next;
//     }
//     return false;
// };
