// Time Complexity : O(1) worst case O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

const hash = function (key) {
  return key % 1000;
};

class Node {
  constructor(key, value) {
    this.key = key;
    this.value = value;
    this.next = null;
  }
}

find = function (head, key) {
  prev = null;
  curr = head;
  while (curr !== null && curr.key !== key) {
    prev = curr;
    curr = curr.next;
  }
  return prev;
};

class MyHashMap {
  constructor() {
    this.map = [];
  }
  /**
   * @param {number} key
   * @param {number} value
   * @return {void}
   */
  put(key, value) {
    const hashValue = hash(key);
    if (!this.map[hashValue]) {
      this.map[hashValue] = new Node(key, value);
    } else {
      const previousNode = find(this.map[hashValue], key);
      if (previousNode === null) {
        this.map[hashValue].value = value;
      } else {
        if (previousNode.next === null) {
          previousNode.next = new Node(key, value);
        } else {
          previousNode.next.value = value;
        }
      }
    }
  }
  /**
   * @param {number} key
   * @return {number}
   */
  get(key) {
    const hashValue = hash(key);
    if (!this.map[hashValue]) return -1;
    const head = this.map[hashValue];
    const previousNode = find(head, key);
    if (previousNode === null) return head.value;
    return previousNode.next != null ? previousNode.next.value : -1;
  }
  /**
   * @param {number} key
   * @return {void}
   */
  remove(key) {
    const hashValue = hash(key);
    if (!this.map[hashValue]) return;
    const previousNode = find(this.map[hashValue], key);
    if (previousNode === null) {
      if (this.map[hashValue].next === null) {
        this.map[hashValue] = undefined;
      } else {
        this.map[hashValue] = this.map[hashValue].next;
      }
    } else {
      if (previousNode.next !== null) {
        previousNode.next = previousNode.next.next;
      }
    }
  }
}
