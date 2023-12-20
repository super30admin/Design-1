// Not working on leetcode

class MyHashSet {
    constructor() {
        this.primaryItem = 1000
        this.secondaryItem = 1000
        this.hs = new Array(this.primaryItem)
    }

    primaryIndexValue(key) {
        return Math.floor(key % this.primaryItem)
    }

    secondaryIndexValue(key) {
        return Math.floor(key / this.secondaryItem)
    }

    add(key) {
        const primaryBucketIndex = this.primaryIndexValue(key);
        const secondaryBucketIndex = this.secondaryIndexValue(key);

        if (this.hs[primaryBucketIndex] == null) {
            if (primaryBucketIndex == 0) {
                this.hs[primaryBucketIndex] = new Array(this.secondaryItem + 1);
            } else {
                this.hs[primaryBucketIndex] = new Array(this.secondaryItem);
            }
        }
        this.hs[primaryBucketIndex][secondaryBucketIndex] = true;
    }

    remove(key) {
        const primaryBucketIndex = this.primaryIndexValue(key);
        const secondaryBucketIndex = this.secondaryIndexValue(key);
        if (this.hs[primaryBucketIndex] == null) return;
        this.hs[primaryBucketIndex][secondaryBucketIndex] = false;
    }

    contains(key) {
        const primaryBucketIndex = this.primaryIndexValue(key);
        const secondaryBucketIndex = this.secondaryIndexValue(key);

        if (this.hs[primaryBucketIndex] == null) return false;
        return this.hs[primaryBucketIndex][secondaryBucketIndex];
    }
}