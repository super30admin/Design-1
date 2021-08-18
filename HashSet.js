// Time Complexity : O(1) for all
// Space Complexity : O(n) n is number of entries
// Did this code successfully run on Leetcode : Yes


var MyHashSet = function () {
    this.bucket = 1000;
    this.bucketItem = 1000
    this.storage = new Array(this.bucket);

}


MyHashSet.prototype.bucketSize = function (key) {
    return key % this.bucket;
};

MyHashSet.prototype.bucketItemSize = function (key) {
    return Math.floor(key / this.bucketItem);
};


MyHashSet.prototype.add = function (key) {
    let bucketIndex = this.bucketSize(key);
    let bucketItemIndex = this.bucketItemSize(key);
    if (!this.storage[bucketIndex]) {
        if (bucketIndex === 0) {
            this.storage[bucketIndex] = new Array(this.bucketItem + 1);
        } else {
            this.storage[bucketIndex] = new Array(this.bucketItem);
        }
    }
    this.storage[bucketIndex][bucketItemIndex] = true;
};


MyHashSet.prototype.remove = function (key) {
    let bucketIndex = this.bucketSize(key);
    let bucketItemIndex = this.bucketItemSize(key);
    if (!this.storage[bucketIndex]) return;
    this.storage[bucketIndex][bucketItemIndex] = false;
};


MyHashSet.prototype.contains = function (key) {
    let bucketIndex = this.bucketSize(key);
    let bucketItemIndex = this.bucketItemSize(key);
    if (!this.storage[bucketIndex]) return false;
    return !!this.storage[bucketIndex][bucketItemIndex];
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */