/*

There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k
(1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0],
nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target
if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:

Input: nums = [1], target = 0
Output: -1

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104

 */

package ArrayProblems;

import java.util.Arrays;

public class SearchInRotatedSortedArray_21 {

    public static void main (String[] args){
        int[] arr = {4,5,6,7,0,1,2};
        int k=7;
        System.out.println(search(arr,k));
    }

    public static int search(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        int ans = binarySearch(nums,target,start,end);
        return ans;
    }

    public static int binarySearch(int[] nums,int target,int start,int end){
        if(start>end)
            return -1;
        int m = start+(end-start)/2;
        if (target == nums[m])
            return m;
        if(target<nums[m])
            return binarySearch(nums,target,start,m-1);
        return binarySearch(nums,target,m+1,end);

    }

}


/*

Less Time Complesity Solutions:

class Solution {
    public int search(int[] nums, int target) {
        nt start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){
                 if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                 else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                 else
                    end = mid - 1;
            }
        }
        return -1;
    }
}

 */