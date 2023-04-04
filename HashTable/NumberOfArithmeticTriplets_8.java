/*

You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff.
A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:

i < j < k,
nums[j] - nums[i] == diff, and
nums[k] - nums[j] == diff.
Return the number of unique arithmetic triplets.

Example 1:

Input: nums = [0,1,4,6,7,10], diff = 3
Output: 2
Explanation:
(1, 2, 4) is an arithmetic triplet because both 7 - 4 == 3 and 4 - 1 == 3.
(2, 4, 5) is an arithmetic triplet because both 10 - 7 == 3 and 7 - 4 == 3.

Example 2:

Input: nums = [4,5,6,7,8,9], diff = 2
Output: 2
Explanation:
(0, 2, 4) is an arithmetic triplet because both 8 - 6 == 2 and 6 - 4 == 2.
(1, 3, 5) is an arithmetic triplet because both 9 - 7 == 2 and 7 - 5 == 2.

Constraints:

3 <= nums.length <= 200
0 <= nums[i] <= 200
1 <= diff <= 50
nums is strictly increasing.

 */

package HashTable;

import java.util.HashSet;

public class NumberOfArithmeticTriplets_8 {

    public static void main(String[] args){
        int[] nums = {0,1,4,6,7,10};
        int diff = 3;
        System.out.println(arithmeticTriplets(nums,diff));
    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]-diff) && set.contains(nums[i]-2*diff)){
                ans++;
            }
            set.add(nums[i]);
        }
        return ans;
    }
    
}

/*

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {

        int count =0;

        for(int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++){

                for(int k=j+1;k<nums.length;k++){

                    if(i<j && j<k){

                    if(Math.abs(nums[j]-nums[i])==diff && Math.abs(nums[k]-nums[j])==diff ){count++;}

                    }

                }
            }

        }
    return count;
    }
}

 */
