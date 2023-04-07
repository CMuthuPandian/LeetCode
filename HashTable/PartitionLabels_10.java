/*

You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
Return a list of integers representing the size of these parts.

Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Example 2:

Input: s = "eccbbbbdec"
Output: [10]

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.

 */

package HashTable;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class PartitionLabels_10 {

    public static void main(String[] args){
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }

    public static List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,i);
        }
        int max=0;
        int prev =-1;
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            max = Math.max(max,map.get(ch));
            if(max==i){
                ans.add(max-prev);
                prev = max;
            }
        }
        return ans;
    }

}


/*

class Solution {

    public static List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] freq = new int[126];
        char[] chs = s.toCharArray();
        for(int i=0;i<n;i++){
            freq[chs[i]] = i;
        }
        List<Integer> l = new ArrayList<>();
        int start = 0;
        int end = 0;
        while(start<n){
            end = freq[chs[start]];
            for(int i=start+1;i<end;i++){
                end = Math.max(end, freq[chs[i]]);
            }
            l.add(end-start+1);
            start = end+1;
        }
        return l;
    }
}

*/
