//Time: O(1)
//Space: O(1)

var MyHashSet = function() {
  this.buckets = 1000;
  this.bucketItems = 1000;
  this.storage = new Array(this.buckets);
};

MyHashSet.prototype.getBucket = function(key) {
  // console.log(key, this.buckets)
  return key % this.buckets;
};

MyHashSet.prototype.getBucketItems = function(key) {
  return Math.floor(key / this.bucketItems);
};
/**
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function(key) {
  var bucket = this.getBucket(key);
  var bucketItem = this.getBucketItems(key);
  // console.log(bucket)
  if (this.storage[bucket] === null || this.storage[bucket] === undefined) {
    if (bucket === 0) {
      this.storage[bucket] = new Array(this.bucketItems + 1);
    } else {
      this.storage[bucket] = new Array(this.bucketItems);
    }
  }
  this.storage[bucket][bucketItem] = true;
};

/**
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function(key) {
  var bucket = this.getBucket(key);
  var bucketItem = this.getBucketItems(key);
  if (this.storage[bucket] === null || this.storage[bucket] === undefined) {
    return null;
  }
  this.storage[bucket][bucketItem] = false;
};

/**
 * @param {number} key
 * @return {boolean}
 */
MyHashSet.prototype.contains = function(key) {
  var bucket = this.getBucket(key);
  var bucketItem = this.getBucketItems(key);
  // console.log(bucket,bucketItem, this.storage[bucket])
  if (this.storage[bucket] === null || this.storage[bucket] === undefined) {
    return false;
  }
  return this.storage[bucket][bucketItem];
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */
