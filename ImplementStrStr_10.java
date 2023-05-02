/*

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.

 */

package StringProblems;

public class ImplementStrStr_10 {

    public static void main(String[] args){
        String s1 = "aaaaa";
        String s2 = "bba";
        System.out.println(strStr(s1,s2));
    }

    public static int strStr(String haystack, String needle) {
        int start =0;
        int end = needle.length();
        while(end<=haystack.length()){
            if(check(haystack,needle,start,end)){
                return start;
            }
            else{
                start++;
                if(end<haystack.length())
                    end++;
                else
                    return -1;
                if(check(haystack,needle,start,end)){
                    return start;
                }
                start++;
                end++;
            }
        }
        return -1;
    }

    public static boolean check(String ans1,String ans2,int s,int e){
        String ans = ans1.substring(s,e);
        char[] finalAns1 = ans2.toCharArray();
        char[] finalAns2 = ans.toCharArray();
        for(int i=0;i<ans2.length();i++){
            if(finalAns1[i]==finalAns2[i]){
                if(i==ans2.length()-1){
                    return true;
                }
            }
            else
                return false;
        }
        return false;
    }

}

/*

Less time complexity solutions:

class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}


class Solution {
    public int strStr(String haystack, String needle) {
        int letter = needle.charAt(0);

        int ans = -1;
        for (int i = 0; i <= (haystack.length() - needle.length()); i++) {
            if (haystack.charAt(i) != letter) {
                continue;
            }

            boolean allCorrect = true;


            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    allCorrect = false;
                    break;
                }
            }

            if (allCorrect) {
                ans = i;
                return ans;
            }
        }
        return ans;

    }
}


class Solution {
    public int strStr(String haystack, String needle) {
        String strs[] = haystack.split(needle);
        if(strs.length == 0)
            return 0;
        return (strs[0].length() == haystack.length()) ? -1 : strs[0].length();
    }
}

 */
