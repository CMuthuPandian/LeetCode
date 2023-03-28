/*

Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j
such that |nums[i] - nums[j]| == k.

The value of |x| is defined as:

x if x >= 0.
-x if x < 0.

Example 1:

Input: nums = [1,2,2,1], k = 1
Output: 4
Explanation: The pairs with an absolute difference of 1 are:
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]
- [1,2,2,1]

Example 2:

Input: nums = [1,3], k = 3
Output: 0
Explanation: There are no pairs with an absolute difference of 3.

Example 3:

Input: nums = [3,2,1,5,4], k = 2
Output: 3
Explanation: The pairs with an absolute difference of 2 are:
- [3,2,1,5,4]
- [3,2,1,5,4]
- [3,2,1,5,4]

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
1 <= k <= 99

 */

package HashTable;

import java.util.HashMap;

public class AbsoluteDiffPair_1 {

    public static void main(String[] args){
        int[] nums = {1,2,2,1};
        int k = 1;
        System.out.println(countKDifference(nums,k));
    }

    public static int countKDifference(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int count=0;
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
            count+=map.getOrDefault(i-k,0)+map.getOrDefault(i+k,0);
        }
        return count;
    }
}

/*

class Solution {
    public int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0;i<nums.length;i++){
            for (int j = i+1;j<nums.length;j++)
                if (Math.abs(nums[j]-nums[i]) == k) count++;
        return count;
    }
}

class Solution {
  public int countKDifference(int[] nums, int k) {
    final int kMax = 100;
    int ans = 0;
    int[] count = new int[kMax + 1];

    for (final int num : nums)
      ++count[num];

    for (int i = k + 1; i <= kMax; ++i)
      ans += count[i] * count[i - k];

    return ans;
  }
}

class Solution {
public int countKDifference(int[] nums, int k) {
        int res = 0;
        int[] counts = new int[101];
        for(int i=0;i<nums.length;i++){
            counts[nums[i]]++;
        }
        for(int i=counts.length-1;i>=k;i--){
                res+=counts[i]*counts[i-k];
        }
        return res;
    }
}

class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;

        for(int i = 0;i< nums.length;i++){
            if(map.containsKey(nums[i]-k)){
                res+= map.get(nums[i]-k);
            }
            if(map.containsKey(nums[i]+k)){
                res+= map.get(nums[i]+k);
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }


        return res;
    }
}

 */