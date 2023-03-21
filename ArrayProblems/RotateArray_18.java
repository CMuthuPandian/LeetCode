
/*

Rotate the given array number of times mentioned by the user

 */

import java.util.Arrays;

public class RotateArray_18 {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7};
        int n = 3;
        rotateArray(nums,n);
        System.out.println(Arrays.toString(nums));
    }

    static int[] rotateArray(int[] nums, int k){
        int temp;
        if(nums.length==0)
            return nums;
        while(k!=0){
            for(int i=0;i<nums.length-1;i++){
                temp = nums[i];
                nums[i]=nums[nums.length-1];
                nums[nums.length-1]=temp;
            }
            k--;
        }
        return nums;
    }
}



/*

Less time Solution:

class Solution {
    public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
    System.out.println(Arrays.toString(nums));
}

 public void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
 }
}

 */
