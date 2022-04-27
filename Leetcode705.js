// Time Complexity : O(1) for add(),remove() and contains();
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

I assumed simple array with name as arr in javascript.The size of array is intialized to be 1000 inside constructor(). Since we have to add(),remove() and check in contains() inside this array using key approach so i used indexOf() function which normally checks index of value to verify if it's present in array or not on basis of which we pushed element in array if it's not existed previously.Otherwise if it's exists and same element adds up again then we checked index and if index found is greater equal to 0 then in remove() using delete we remove that value from array.The similar methodology utilized to check and return value as true and false using indexOf approach inside contains().


var arr=[];
var MyHashSet = function() {
   
    this.arr= [10000];
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.add = function(key) {
    if(this.arr.indexOf(key)===-1)
    {
        this.arr.push(key);
    }
};

/** 
 * @param {number} key
 * @return {void}
 */
MyHashSet.prototype.remove = function(key) {
    const val = this.arr.indexOf(key);
    if(val>=0)
    {
         delete this.arr[val];
    }
   
};

/** 
 * @param {number} key
 * @return {boolean}
 */

MyHashSet.prototype.contains = function(key) {
   return this.arr.indexOf(key)>0;
};

/** 
 * Your MyHashSet object will be instantiated and called as such:
 * var obj = new MyHashSet()
 * obj.add(key)
 * obj.remove(key)
 * var param_3 = obj.contains(key)
 */