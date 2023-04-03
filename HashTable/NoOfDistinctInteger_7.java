/*

You are given an array nums consisting of positive integers.
You have to take each integer in the array, reverse its digits, and add it to the end of the array.
You should apply this operation to the original integers in nums.
Return the number of distinct integers in the final array.

Example 1:

Input: nums = [1,13,10,12,31]
Output: 6
Explanation: After including the reverse of each number, the resulting array is [1,13,10,12,31,1,31,1,21,13].
The reversed integers that were added to the end of the array are underlined. Note that for the integer 10, after reversing it, it becomes 01 which is just 1.
The number of distinct integers in this array is 6 (The numbers 1, 10, 12, 13, 21, and 31).

Example 2:

Input: nums = [2,2,2]
Output: 1
Explanation: After including the reverse of each number, the resulting array is [2,2,2,2,2,2].
The number of distinct integers in this array is 1 (The number 2).

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 106

 */

package HashTable;

import java.util.Set;
import java.util.HashSet;

public class NoOfDistinctInteger_7 {

    public static void main(String[] args){
        int[] nums = {1,13,10,12,31};
        System.out.println(countDistinctIntegers(nums));
    }

    public static int countDistinctIntegers(int[] nums) {
        int[] finalArray = new int[2*nums.length];
        for(int i=0;i<finalArray.length;i++){
            if(i<nums.length){
                finalArray[i]=nums[i];
            }
            else{
                int x = reverseDigit(nums[i-nums.length]);
                finalArray[i]=x;
            }
        }
        Set<Integer> ans = new HashSet<>();
        for(int i=0;i<finalArray.length;i++){
            ans.add(finalArray[i]);
        }
        return ans.size();
    }

    public static int reverseDigit(int a){
        if(a<9){
            return a;
        }
        int temp=0;
        int rem=0;
        while(a!=0){
            rem = a%10;
            temp = (temp*10)+rem;
            a=a/10;
        }
        return temp;
    }
}

/*

class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int e : nums){
            hs.add(e);
            int n=0;
            while(e>0){
              n=n*10+e%10;
              e/=10;
            }
            hs.add(n);
        }
        return hs.size();
    }
}

class Solution {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int e : nums){
            hs.add(e);
            int n=0;
            while(e>0){
              n=n*10+e%10;
              e/=10;
            }
            hs.add(n);
        }
        return hs.size();
    }
}

class Solution {
    public int countDistinctIntegers(int[] nums) {
        boolean[] seen = new boolean[1000001];

        int uniques = 0;

        for (int n : nums) {
            if (!seen[n]) ++uniques;
            seen[n] = true;
            int m = 0;
            while (n > 0) {
                m = m * 10 + (n % 10);
                n /= 10;
            }
            if (!seen[m]) ++uniques;
            seen[m] = true;
        }

        return uniques;
    }
}

 */
