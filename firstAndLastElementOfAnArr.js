/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 * 
 * Intution: 
 * The approach here is using binary search twice to get start and end index of the target
 * We are even returning the firstFound location, so that we can optimize the end index calculation
 * Time complexity is O(log n) + O(log n) => O(log n)
 * 
 */


var searchRange = function (nums, target) {
    let left = 0, right = nums.length - 1;
    // Method to get the first occurence of the target
    const firstLocBinarySearch = (low, high) => {
        let firstFound = -1;
        while (low <= high) {
            const mid = Math.floor(low + (high - low) / 2);
            if (nums[mid] === target) {
                if (firstFound === -1) firstFound = mid;
                if (mid === 0 || nums[mid] !== nums[mid - 1]) return [firstFound, mid];
                else high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return [-1, -1];
    }

    // Method to get the last occurence of the target
    const lastLocBinarySearch = (low, high) => {
        while (low <= high) {
            const mid = Math.floor(low + (high - low) / 2);
            if (nums[mid] === target) {
                if (mid === nums.length - 1 || nums[mid] !== nums[mid + 1]) return mid;
                else low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return -1;
    }
    //  get the firstfound location and the startIndex
    let [firstFound, startIndex] = firstLocBinarySearch(left, right);
    // if firstFound is -1 then the element is not found, can ignore the remaining code and return [-1,-1]
    if (firstFound === -1) return [-1, -1];
    let endIndex = lastLocBinarySearch(startIndex, right);
    return [startIndex, endIndex];
};