package ArrayProblems;

/*

Given an integer array nums, move all 0's to the end of it while maintaining
the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:

Input: nums = [0]
Output: [0]

 */


import java.util.Arrays;

public class MoveZeros_13 {

    public static void main(String[] args){
        int[] arr = {0,7,2,4,0,0,1,3,0};
        moveZeros(arr);
    }

    public static void moveZeros(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==0&&nums[j]==0){
                    if(j==nums.length-1)
                        break;
                    else
                        j++;
                }
                if(nums[i]==0&&nums[j]!=0){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}

/*

Less time complexity Solution:

public void moveZeroes(int[] nums) {
    if (nums == null || nums.length == 0) return;

    int insertPos = 0;
    for (int num: nums) {
        if (num != 0) nums[insertPos++] = num;
    }

    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }
}

public void moveZeroes(int[] nums) {

    int j = 0;
    for(int i = 0; i < nums.length; i++) {
        if(nums[i] != 0) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j++;
        }
    }
}

 */