#Time Complexity=O(logn)
#Space Complexity =O(1)
#// Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        def binarySearch (nums, target):
            if not nums:
                return -1
            start, end = 0, len(nums) - 1

            while start + 1 < end:
                mid = (start + end) // 2
                if nums[mid] < target:
                    start = mid
                else: 
                    end = mid
            
            if nums[start] == target:
                return start
            
            if nums[end] == target:
                return end
            return -1
            
        pos = binarySearch (nums, target)

        if pos != -1:
            start = end = pos

            while end < len(nums) - 1 and nums[end] == target:
                if nums[end + 1] == target:
                    end += 1
                else:
                    break
                
            return [start, end]
        else:
            return [-1,-1]