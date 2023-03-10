/*

Given an integer array nums of length n, you want to create an array ans of length 2n where
ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.

Example 1:

Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
- ans = [1,2,1,1,2,1]

Example 2:

Input: nums = [1,3,2,1]
Output: [1,3,2,1,1,3,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
- ans = [1,3,2,1,1,3,2,1]

Constraints:

n == nums.length
1 <= n <= 1000
1 <= nums[i] <= 1000

 */

package ArrayProblems;

import java.util.Arrays;

public class ConcatenationOfArray_3 {
    
    public static void main(String[] args){
        int[] arr = {1,3,2,1};
        System.out.println(Arrays.toString(getConcatenation(arr)));
    }
    
    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i] = nums[i];
            ans[i+nums.length]=nums[i];
        }
        return ans;
    }
    
}

/*

class Solution {
    public int[] getConcatenation(int[] nums) {
        int size = nums.length;
        int[] newArray = new int[2 * size];
        System.arraycopy(nums, 0, newArray, 0, size);
        System.arraycopy(nums, 0, newArray, size, size);
        return newArray;
    }
}

 */
