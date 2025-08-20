// Time Complexity for all operation: O(1)
// Space Complexity: O(1)
//      While designing any data structure, we focus on the complexity of user scenarios.
//      The system space would be O(n), where n is the number of keys stored in the set.
class MyHashSet {
	private storage: boolean[][];
	private bucket: number;
	private bucketItems: number;

	constructor() {
		this.bucket = 1000;
		this.bucketItems = 1000;
		this.storage = new Array(this.bucket);
	}

	hash1(key: number): number {
		return key / this.bucket;
	}
	hash2(key: number): number {
		return Math.floor(key / this.bucketItems);
	}

	add(key: number) {
		const bucket = this.hash1(key);
		const bucketItems = this.hash2(key);
		if (!this.storage[bucket]) {
			if (bucket === 0) {
				this.storage[bucket] = new Array(this.bucketItems + 1);
			} else {
				this.storage[bucket] = new Array(this.bucketItems);
			}
		}

		this.storage[bucket][bucketItems] = true;
	}

	remove(key: number) {
		const bucket = this.hash1(key);
		const bucketItems = this.hash2(key);
		if (!this.storage[bucket]) return;

		this.storage[bucket][bucketItems] = false;
	}

	contains(key: number): boolean {
		const bucket = this.hash1(key);
		const bucketItems = this.hash2(key);
		if (!this.storage[bucket]) return false;

		return this.storage[bucket][bucketItems];
	}
}
