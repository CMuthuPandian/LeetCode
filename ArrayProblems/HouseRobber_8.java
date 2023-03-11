/*

You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping you from
robbing each of them is that adjacent houses have security systems connected and it will
automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the
maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400

 */

package ArrayProblems;

public class HouseRobber_8 {

    public static void main(String[] args){
        int[] arr = {2,4,8,9,9,3};
        System.out.println(rob(arr));
    }

    public static int rob(int[] nums) {
        int count=2;
        int sum1=nums[0];
        if(nums.length==1)
            return nums[0];
        int sum2=nums[1];
        while(count<nums.length){
            while((count)<nums.length-1 && nums[count]<nums[count+1] && nums[count+1]<nums[count+2]){
                count++;
            }
            sum1+=nums[count];
            count=count+2;
        }
        count=3;
        while(count<nums.length){
            while((count)<nums.length-1 && nums[count]<nums[count+1] && nums[count+1]<nums[count+2]){
                count++;
            }
            sum2+=nums[count];
            count=count+2;
        }
        if(sum1>sum2)
            return sum1;
        return sum2;
    }

}

/*

Solutions:

    public int rob (int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + num);
        }

        return dp[n];
    }
}

class Solution {
    public int rob(int[] num) {
    if(num==null || num.length == 0)
		return 0;

	int even = 0;
	int odd = 0;

	for (int i = 0; i < num.length; i++) {
		if (i % 2 == 0) {
			even += num[i];
			even = even > odd ? even : odd;
		} else {
			odd += num[i];
			odd = even > odd ? even : odd;
		}
	}

	return even > odd ? even : odd;
    }

class Solution {
    public int rob(int[] nums) {

        // Space Optimizaion;
        // TC : O(N); SC : O(1)
        int prev = nums[0];
        int present = 0;

        for (int i = 1; i < nums.length; i++) {
            int Pick = nums[i];
            if (i > 1) {
                Pick = Pick + present;
            }
            int notPick = 0 + prev;

            int cur = Math.max(Pick, notPick);
            present = prev;
            prev = cur;
        }
        return prev;
    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;

        int rob1 = 0, rob2 = 0;

        for(int num : nums) {
            int newRob = Math.max(num + rob1, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }

        return rob2;
    }
}
 */