// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
* Approach - Double Hashing
*   Since the constraint was 0 - 10^6 we use the sqrt to split buckets to avoid huge memory wastage
*   We use double hashing to avoid collision
*   Add:
*     - We get the first hash value by using key % buckets
*     - We get the second hash value by key / bucketItems
*     - if the array of the fist hash is empty or null we initialize it to a 2D
*         array with the bucketItems length and defaulting it to false.
*     - if it's not then we do storage[bucket][bucketItem] and set the value to true
*
*   Remove:
*     - We get the first hash value by using key % buckets
*     - We get the second hash value by key / bucketItems
*     - if the array of the fist hash is empty or null we return
*     - if it's not then we do storage[bucket][bucketItem] = false since we are removing the value
*
*   Contains:
*     - We get the first hash value by using key % buckets
*     - We get the second hash value by key / bucketItems
*     - if the array of the fist hash is empty or null we return false
*     - if it's not then we return storage[bucket][bucketItem]
*         which would be true / false depending on if the value exists
*
* */
const MyHashSet = function() {
  this.buckets = 1000;
  this.bucketItems = 1000;
  this.storage = new Array(this.buckets).fill(null);
};

/**
 * @param {number} key
 * @return {number}
 */
MyHashSet.prototype.getBuckets = function (key) {
  return key % this.buckets;
}

/**
 * @param {number} key
 * @return {number}
 */
MyHashSet.prototype.getBucketItems = function (key) {
  return Math.floor(key / this.bucketItems);
}

/**
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function(key) {
  const bucket = this.getBuckets(key);
  const bucketItem = this.getBucketItems(key);

  if (this.storage[bucket] === null) {
    this.storage[bucket] = new Array(this.bucketItems).fill(false)
  }

  this.storage[bucket][bucketItem] = true;
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function(key) {
  const bucket = this.getBuckets(key);
  const bucketItem = this.getBucketItems(key);
  if (this.storage[bucket] === null) {
    return;
  }
  this.storage[bucket][bucketItem] = false;
};

/**
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function(key) {
  const bucket = this.getBuckets(key);
  const bucketItem = this.getBucketItems(key);
  if (this.storage[bucket] === null) {
    return false;
  }
  return this.storage[bucket][bucketItem]
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */

