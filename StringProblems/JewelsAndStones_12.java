/*

You're given strings jewels representing the types of stones that are jewels,
and stones representing the stones you have. Each character in stones is a type of stone you have.
You want to know how many of the stones you have are also jewels.
Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0

Constraints:

1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.

 */

package StringProblems;

public class JewelsAndStones_12 {

    public static void main(String[] args){
        String str1 = "aA";
        String str2 = "aAbbcA";
        System.out.println(numJewelsInStones(str1,str2));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for(int i=0;i<jewels.length();i++){
            for(int j=0;j<stones.length();j++){
                if(jewels.charAt(i)==stones.charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }

}

/*

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int num_jewels = 0;

        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) > -1) {
                num_jewels += 1;
            }
        }

        return num_jewels;
    }
}

 */
