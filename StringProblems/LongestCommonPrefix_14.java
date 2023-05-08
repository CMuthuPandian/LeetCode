/*

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.

 */

package StringProblems;

import java.util.Arrays;

public class LongestCommonPrefix_14 {

    public static void main(String[] args){
        String[] arr = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(arr));
    }

    public static String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        if(size==0)
            return "";
        else if(size==1)
            return strs[0];
        else {
            Arrays.sort(strs);
            int end =  Math.min(strs[0].length(),strs[size-1].length());
            int i=0;
            while(i<end&&strs[0].charAt(i)==strs[size-1].charAt(i)){
                i++;
            }
            return strs[0].substring(0,i);
        }
    }
}

/*

Less time complexity solutions:

class Solution {
	public static String longestCommonPrefix(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while(strs[i].indexOf(prefix) != 0)
	            prefix = prefix.substring(0,prefix.length()-1);
	    return prefix;
	}
}

 */