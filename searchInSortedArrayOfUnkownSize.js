/**
 * Intution:
 * I am using binary search to solve this problem.
 * Setting the high to the highest size allowed in our problem i.e., 10**4 - 1.
 * Reading the midVal using reader.get(mid) method, which  gives us the value or the 2**31 val.
 * Based upon the value i am shifting the left and right pointers.
 */

/**
 * @param {ArrayReader} reader
 * @param {number} target
 * @return {number}
 */
var search = function (reader, target) {
    let left = 0, right = 9999; // 10**4 - 1;
    const outOfBoundVal = 2 ** 31 - 1;
    while (left <= right) {
        const mid = Math.floor(left + (right - left) / 2);
        const midVal = reader.get(mid);
        if (midVal === outOfBoundVal || midVal > target) {
            right = mid - 1;
        } else if (midVal === target) {
            return mid;
        }
        else {
            left = mid + 1;
        }
    }
    return -1;
};