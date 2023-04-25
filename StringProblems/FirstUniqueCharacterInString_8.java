/*

Given a string s, find the first non-repeating character in it and return its index.
If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.

 */

package StringProblems;

public class FirstUniqueCharacterInString_8 {

    public static void main(String[] args){
        String str ="loveleetcode";
        System.out.println(firstUniqChar(str));
    }

    public static int firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            int count =0;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            for(int k=i-1;k>=0;k--){
                if(arr[i]==arr[k]){
                    count++;
                }
            }
            if(count==0)
                return i;
        }
        return -1;
    }

}

/*

Less time complexity solutions:(Above is okay for short word)

        boolean flag = false;
        for(int i = 0;i<s.length(); i++){
            for(int j = 0; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && i!=j){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                return i;
            }else flag = false;
        }
        return -1;

class Solution {
    public int firstUniqChar(String s) {
        int ans=Integer.MAX_VALUE;;
       for (char i='a';i<='z';i++){
           int  index=s.indexOf(i);
           if(index!=-1 && index== s.lastIndexOf(i)){
               ans=Math.min(ans,index);

           }
       }
       return (ans==Integer.MAX_VALUE)?-1:ans;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        int ans = Integer.MAX_VALUE;
       for(char ch = 'a';ch<='z';ch++){
           int index = s.indexOf(ch);
           int last = s.lastIndexOf(ch);
           if(index!=-1 && index == last){
               ans = Math.min(ans,index);
           }
       }
       if(ans==Integer.MAX_VALUE)return -1;
       else return ans;
    }
}

class Solution {
  public int firstUniqChar(String s) {
    int[] count = new int[128];

    for (final char c : s.toCharArray())
      ++count[c];

    for (int i = 0; i < s.length(); ++i)
      if (count[s.charAt(i)] == 1)
        return i;

    return -1;
  }
}

 */