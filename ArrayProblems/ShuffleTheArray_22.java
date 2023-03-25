/*

Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn].

Example 1:

Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

Example 2:

Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]
Example 3:

Input: nums = [1,1,2,2], n = 2
Output: [1,2,1,2]

Constraints:

1 <= n <= 500
nums.length == 2n
1 <= nums[i] <= 10^3

*/

package ArrayProblems;

import java.util.Arrays;

public class ShuffleTheArray_22 {

    public static void main(String[] args){
        int[] arr = {1,2,3,4,4,3,2,1};
        int n = 4;
        System.out.println(Arrays.toString(shuffle(arr,n)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int j = n;
        int k = 0;
        int[] ans = new int[2*n];
        for(int i=0;i<2*n;i++){
            if(i%2==0){
                ans[i] = nums[k];
                k++;
            }
            else{
                ans[i] = nums[j];
                j++;
            }
        }
        return ans;
    }
    
}

/*

class Solution {
    public int[] shuffle(int[] nums, int n) {
      ArrayList<Integer> ans = new ArrayList<>();
      for(int i=0;i<n;i++)
      {
          ans.add(nums[i]);
          ans.add(nums[i+n]);
      }
      for(int i=0;i<nums.length;i++){
          nums[i]=ans.get(i);
      }
      return nums;
    }
}

class Solution {
    public int[] shuffle(int[] nums, int n) {
       int a[]=new int[n];
       int b[]=new int[n];
       int ret[]=new int[2*n];
       int i=0;
       while(i<n)
       {
           a[i]=nums[i];
           i++;
       }
       while(i<2*n)
       {
           b[i-n]=nums[i];
           i++;
       }
       for(int j=0;j<(2*n);j++)
       {
           if(j%2==0)
           {
               ret[j]=a[j/2];
           }
           else
           ret[j]=b[j/2];
       }
       return ret;
    }
}

 */
