/*

You are given an integer array rolls of length n and an integer k. You roll a k sided dice numbered from 1 to k, n times, where the result of the ith roll is rolls[i].
Return the length of the shortest sequence of rolls that cannot be taken from rolls.
A sequence of rolls of length len is the result of rolling a k sided dice len times.
Note that the sequence taken does not have to be consecutive as long as it is in order.

Example 1:

Input: rolls = [4,2,1,2,3,3,2,4,1], k = 4
Output: 3
Explanation: Every sequence of rolls of length 1, [1], [2], [3], [4], can be taken from rolls.
Every sequence of rolls of length 2, [1, 1], [1, 2], ..., [4, 4], can be taken from rolls.
The sequence [1, 4, 2] cannot be taken from rolls, so we return 3.
Note that there are other sequences that cannot be taken from rolls.

Example 2:

Input: rolls = [1,1,2,2], k = 2
Output: 2
Explanation: Every sequence of rolls of length 1, [1], [2], can be taken from rolls.
The sequence [2, 1] cannot be taken from rolls, so we return 2.
Note that there are other sequences that cannot be taken from rolls but [2, 1] is the shortest.

Example 3:

Input: rolls = [1,1,3,2,2,2,3,3], k = 4
Output: 1
Explanation: The sequence [4] cannot be taken from rolls, so we return 1.
Note that there are other sequences that cannot be taken from rolls but [4] is the shortest.

Constraints:

n == rolls.length
1 <= n <= 105
1 <= rolls[i] <= k <= 105

 */

package HashTable;

import java.util.Set;
import java.util.HashSet;

public class ShortestImpossibleSequence_13 {

    public static void main(String[] args){
        int[] rolls = {1,1,3,2,2,2,3,3};
        int k=4;
        System.out.println(shortestSequence(rolls,k));
    }

    public static int shortestSequence(int[] rolls, int k) {
        Set<Integer> ans = new HashSet<>();
        int count=1;
        for(int i:rolls){
            ans.add(i);
            if(ans.size()==k){
                count++;
                ans.clear();
            }
        }
        return count;
    }

}

/*

class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int cnt = 1;

        boolean[] seen = new boolean[k];
        int unseen = k;

        for (int r: rolls) {
            if (!seen[r - 1]) {
                if (--unseen == 0) {
                    ++cnt;
                    Arrays.fill(seen, false);
                    unseen = k;
                } else {
                    seen[r - 1] = true;
                }
            }
        }

        return cnt;
    }
}

class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int round = 1;
        int[] cnt = new int[k+1];
        int cur_cnt = 0;

        for(int i=0; i<rolls.length;i++){
            cnt[rolls[i]]++;
            if(cnt[rolls[i]] == 1) {
                cur_cnt++;
            }
            if(cur_cnt == k) {
                round++;
                cur_cnt=0;
                cnt = new int[k+1];
            }
        }
        return round;
    }
}

 */
