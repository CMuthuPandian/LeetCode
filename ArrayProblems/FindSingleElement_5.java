/*

Given a non-empty array of integers nums, every element appears twice except for one.
Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

 */

package ArrayProblems;

public class FindSingleElement_5 {

    public static void main(String[] args){
        int[] arr = {1,2,1,2,7};
        System.out.println(singleNumber(arr));
    }

    public static int singleNumber(int[] nums){
       for(int i=0;i<nums.length;i++){
           int i1=i;
           int i2=i;
           int temp=0;
           while(i1<nums.length){
               if(nums[i]==nums[i1]){
                   temp+=1;
               }
               i1++;
           }
           while(i2>=0){
               if(nums[i]==nums[i2]){
                   temp+=1;
               }
               i2--;
           }
           if(temp==2){
               return nums[i];
           }
       }
       return -1;
    }

}

/*

Other poossible answers wth less time complexicity:

public int singleNumber(int[] nums) {
    int ans =0;

    int len = nums.length;
    for(int i=0;i!=len;i++)
        ans ^= nums[i];

    return ans;

}

 */
