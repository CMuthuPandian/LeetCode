/*

Given two string arrays word1 and word2, return true if the two arrays represent the same
string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.

Example 1:

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.

Example 2:

Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false

Example 3:

Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true

Constraints:

1 <= word1.length, word2.length <= 103
1 <= word1[i].length, word2[i].length <= 103
1 <= sum(word1[i].length), sum(word2[i].length) <= 103
word1[i] and word2[i] consist of lowercase letters.

 */

package StringProblems;

public class EquivalentStringArray_6 {

    public static void main(String[] args){
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1,word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String ans1 = "";
        String ans2 = "";
        for(String i:word1)
            ans1+=i;
        for(String i:word2)
            ans2+=i;
        if(ans1.equals(ans2))
            return true;
        return false;
    }
}

/*

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();

        for(String s:word1){
            sb1.append(s);
        }
        for(String s:word2){
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }
}

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        int chPointer1=0;
        int chPointer2=0;
        int wPointer1=0;
        int wPointer2=0;
        // Optimized technique see ans for explanation
        while(true)
        {
            char ch1=word1[wPointer1].charAt(chPointer1);
            char ch2=word2[wPointer2].charAt(chPointer2);
            if(ch1!=ch2)
            {
                return false;
            }
            chPointer1++;
            chPointer2++;
            if(chPointer1==word1[wPointer1].length())
            {
                wPointer1++;
                chPointer1=0;
            }
            if(chPointer2==word2[wPointer2].length())
            {
                wPointer2++;
                chPointer2=0;
            }

            if(wPointer1==word1.length && wPointer2==word2.length)
            {
                break;
            }
            if(wPointer1==word1.length || wPointer2==word2.length)
            {
                return false;
            }


        }

        return true;

    }
}

*/