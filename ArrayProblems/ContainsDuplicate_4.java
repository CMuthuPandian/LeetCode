package ArrayProblems;

/*

Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

 */

public class ContainsDuplicate_4 {

    public static void main(String[] args){
        int[] arr = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(isDuplicate(arr));
    }

    public static boolean isDuplicate(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            int count=1;
            for(int j=0;j<nums.length-1-i;j++){
                if(nums[i]==nums[i+count]){
                    return true;
                }
                count++;
            }
            count=1;
        }
        return false;
    }
}


/*

Possible solutions with less time complexcity:

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;


        Arrays.sort(nums);
        for(int ind = 1; ind < nums.length; ind++) {
            if(nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;

 */
