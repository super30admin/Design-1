// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : none

/*
Approach:
Used the concept of double hashing (using 2 arrays) to prevent collisions (in case keys present same hash output). First hash function returns a modulus of key with the size of the primary array, and second hash function returns a quotient of the key with the size of the secondary array. All operations run in constant time.
*/

package main

const BUCKETS = 1000
const BUCKET_ITEMS = 1000

type MyHashSet struct {
	storage [BUCKETS][]bool
}

func Constructor() MyHashSet {
	return MyHashSet{
		storage: [BUCKETS][]bool{}, // initialize primary array, don't initialize secondary array
	}
}

// primary hash func
func (this *MyHashSet) getBucket(key int) int {
	return key % BUCKETS
}

// secondary hash func
func (this *MyHashSet) getBucketItem(key int) int {
	return key / BUCKET_ITEMS
}

func (this *MyHashSet) Add(key int) {
	b := this.getBucket(key)
	bucket := this.storage[b]
	if bucket == nil {
		if b == 0 {
			this.storage[b] = make([]bool, BUCKET_ITEMS+1)
		} else {
			this.storage[b] = make([]bool, BUCKET_ITEMS)
		}
	}
	bi := this.getBucketItem(key)
	this.storage[b][bi] = true
}

func (this *MyHashSet) Remove(key int) {
	b := this.getBucket(key)
	bucket := this.storage[b]
	if bucket == nil {
		return
	}
	bi := this.getBucketItem(key)
	this.storage[b][bi] = false
}

func (this *MyHashSet) Contains(key int) bool {
	b := this.getBucket(key)
	bucket := this.storage[b]
	if bucket == nil {
		return false
	}
	bi := this.getBucketItem(key)
	return this.storage[b][bi]
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Add(key);
 * obj.Remove(key);
 * param_3 := obj.Contains(key);
 */
