/*

Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.

Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1

 */

package ArrayProblems;

import java.util.Arrays;

public class FirstMissingPositive_6 {

    public static void main(String[] args){
        int[] arr = {0,2,2,1,1};
        System.out.println(firstMissingPositive(arr));
    }

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                int j=i;
                while(j<nums.length-1){
                    if((nums[j]+1)>=nums[j+1])
                        j++;
                    else
                        return nums[j]+1;
                }
            }
            count++;
        }
        if(count==nums.length) {
            for (int s : nums) {
                if (s == 1)
                    return nums[nums.length - 1] + 1;
            }
        }
        return 1;
    }

}

/*

Less time complexity solutions:

class Solution {
    public int firstMissingPositive(int[] nums) {
       int i=0;

        while(i<nums.length){

            int correct=nums[i]-1;

            if(nums[i]>0&&( nums[i]<=nums.length)&&(nums[i]!=nums[correct])){
                swap(nums,i,correct);
            }
            else{
                i++;
            }

        }

        for(int k=0;k<nums.length;k++){
            if(nums[k]!=k+1){
                return k+1;
            }
        }
        return nums.length+1;
    }
   static void swap(int [] nums,int f,int s){
        int temp=nums[f];
        nums[f]=nums[s];
        nums[s]=temp;
    }
}

 */
