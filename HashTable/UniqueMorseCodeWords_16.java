/*

International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows:
'a' maps to ".-",
'b' maps to "-...",
'c' maps to "-.-.", and so on.
For convenience, the full table for the 26 letters of the English alphabet is given below:
[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Given an array of strings words where each word can be written as a concatenation of the Morse code of each letter.

For example, "cab" can be written as "-.-..--...", which is the concatenation of "-.-.", ".-", and "-...". We will call such a concatenation the transformation of a word.
Return the number of different transformations among all words we have.



Example 1:
Input: words = ["gin","zen","gig","msg"]

Output: 2

Explanation: The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."
There are 2 different transformations: "--...-." and "--...--.".


Example 2:

Input: words = ["a"]
Output: 1

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 12
words[i] consists of lowercase English letters.

 */

package HashTable;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords_16 {

    public static void main(String[] args){
        String[] words = {"gin","zen","gig","msg"};
        System.out.println(uniqueMorseRepresentations(words));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> ans = new HashSet();
        for(String i : words){
            StringBuilder temp = new StringBuilder();
            for(char c:i.toCharArray()){
                temp.append(morse[c - 'a']);
            }
            ans.add(temp.toString());
        }
        return ans.size();
    }

}

/*

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        int i;
        String arr[]=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet();
        for (String word : words) set.add(transform(word, arr));
        return set.size();
    }

    public String transform(String word, String[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) sb.append(arr[(int)c - 97]);
        return sb.toString();


    }
}

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        if (words.length == 0)
            return 0;

        Set<String> res = new HashSet<String> ();
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (String w: words) {
            StringBuilder str = new StringBuilder();
            for (char c: w.toCharArray()){
                int index = alphabet.indexOf(c);
                str.append(codes[index]);
            }
            res.add(str.toString());
        }


        return res.size();
    }
}

 */
