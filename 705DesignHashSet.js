// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var MyHashSet = function () {
  this.size = 1009;
  this.buckets = new Array(this.size);
  for (let i = 0; i < this.size; i++) {
    this.buckets[i] = [];
  }
};

/**
 * @param {number} key
 * @return {void}
 */

MyHashSet.prototype.hash1 = function (key) {
  return key % this.size;
};
MyHashSet.prototype.hash2 = function (key) {
  return Math.floor(key / this.size);
};
MyHashSet.prototype.add = function (key) {
  const h1 = this.hash1(key);
  const h2 = this.hash2(key);
  // if(!this.buckets[h1])
  //this.buckets[h1] = new Array(993).fill(false)
  this.buckets[h1][h2] = true;
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function (key) {
  const h1 = this.hash1(key);
  const h2 = this.hash2(key);
  if (this.buckets[h1]) this.buckets[h1][h2] = false;
};

/**
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function (key) {
  const h1 = this.hash1(key);
  const h2 = this.hash2(key);
  if (this.buckets[h1])
    if (this.buckets[h1][h2]) return true;
    else return false;
  else return false;
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
