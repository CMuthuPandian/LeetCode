/*

You are given a string allowed consisting of distinct characters and an array of strings words.
A string is consistent if all characters in the string appear in the string allowed.
Return the number of consistent strings in the array words.

Example 1:

Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.

Example 2:

Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.

Example 3:

Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
Output: 4
Explanation: Strings "cc", "acd", "ac", and "d" are consistent.

Constraints:

1 <= words.length <= 104
1 <= allowed.length <= 26
1 <= words[i].length <= 10
The characters in allowed are distinct.
words[i] and allowed contain only lowercase English letters.

 */

package HashTable;

import java.util.HashSet;
import java.util.Set;

public class CountConsistentString_2 {

    public static void main(String[] args){
        String allowed = "cad";
        String[] words = {"cc","acd","b","ba","bac","bad","ac","d"};
        System.out.println(countConsistentStrings(allowed,words));
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        Set<Character> ans = new HashSet<>();
        int count=0;
        int finalAns=0;
        for(char c : allowed.toCharArray()){
            ans.add(c);
        }
        for(int i=0;i<words.length;i++){
            for(char j : words[i].toCharArray()){
                if(ans.contains(j)){
                    count++;
                }
            }
            if(count==words[i].length()){
                finalAns+=1;
            }
            count=0;
        }
        return finalAns;
    }
}

/*

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = words.length;
	int[] store = new int[26];

	for (char c : allowed.toCharArray()){
		store[c-'a']++;
	}

	for (String word : words) {

		for (char c : word.toCharArray()) {
			if (store[c-'a'] <= 0){
				count--;
				break;
			}
		}
	}
	return count;
    }
}

 */
