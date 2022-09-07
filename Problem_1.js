// Time Complexity : 
// Add: O(1)
// Remove: O(1)
// Contains: O(1)

// Space Complexity :
// Worst case: O(N) where N is the highest range of numbers that can be added
// Best case: O(sqrt(N))

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var MyHashSet = function () {
    // Defining size of primary array
    this.buckets = 1000; // This is sqrt of the range of possible numbers given in problem i.e. sqrt(1000000) = 1000
    // Defining size of secondary array
    this.bucketItems = 1000; 
    // This will become a 2d array. Primary array stores the address of each secondary array.
    this.storage = new Array(this.bucket);
};

MyHashSet.prototype.getBucket = function (key) {
    // Get the index of primary array
    return Math.floor(key % this.buckets);
}

MyHashSet.prototype.getBucketItem = function (key) {
    // Get the index of secondary array
    return Math.floor(key / this.bucketItems);
}

/** 
* @param {number} key
* @return {void}
*/
MyHashSet.prototype.add = function (key) {
    let bucket = this.getBucket(key);
    let bucketItem = this.getBucketItem(key);
    // Check if the peimary array is not yet initialized
    if (!this.storage[bucket]) {
        // If the promary array index is 0, we create the secondary array size to bucketItems+1 to cover the edge case of adding number 10^6
        if (bucket == 0) {
            this.storage[bucket] = new Array(this.bucketItems + 1);
        } else {
            this.storage[bucket] = new Array(this.bucketItems);
        }
        // Filling the secondary array with false
        this.storage[bucket].fill(false);
    }
    // Set the double hashed index of element to be added as true
    this.storage[bucket][bucketItem] = true;
};

/** 
* @param {number} key
* @return {void}
*/
MyHashSet.prototype.remove = function (key) {
    let bucket = this.getBucket(key);
    let bucketItem = this.getBucketItem(key);
    // Remove from secondary array only if an address exists in the primary array.
    if (this.storage[bucket]) {
        this.storage[bucket][bucketItem] = false;
    }
};

/** 
* @param {number} key
* @return {boolean}
*/
MyHashSet.prototype.contains = function (key) {
    let bucket = this.getBucket(key);
    let bucketItem = this.getBucketItem(key);
    // Check secondary array only if an address exists in the primary array.
    if (this.storage[bucket]) {
        return this.storage[bucket][bucketItem];
    }
    return false;
};


var obj = new MyHashSet();
obj.add(key);
obj.remove(key);
var param_3 = obj.contains(key);
console.log(param_3);
console.log(obj);

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
