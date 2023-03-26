/*

Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution,
and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

 */


import java.util.Arrays;

public class TwoSum_23 {

    public static void main(String[] args){
        int[] arr = {2,7,11,15};
        int k = 9;
        System.out.println(Arrays.toString(twoSum(arr,k)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=1+i;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }
        }
        return ans;
    }

}

/*

0ms solutions:

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int step = 1;
        int[] result = {-1, -1};
        for(int i = 0; i < len; i++) {
            if (step >= len) {
                break;
            }
            if (i + step >= len) {
                i = -1;
                step++;
            } else if (nums[i] + nums[i + step] == target) {
                result[0] = i;
                result[1] = i + step;
                break;
            }
        }
        return result;
    }
}

 */
