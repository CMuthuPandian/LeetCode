/*

You are given the strings key and message, which represent a cipher key and a secret message,
respectively. The steps to decode message are as follows:
Use the first appearance of all 26 lowercase English letters in key as the order of the
substitution table.
Align the substitution table with the regular English alphabet.
Each letter in message is then substituted using the table.
Spaces ' ' are transformed to themselves.
For example, given key = "happy boy" (actual key would have at least one instance of each
letter in the alphabet), we have the partial substitution table of
('h' -> 'a', 'a' -> 'b', 'p' -> 'c', 'y' -> 'd', 'b' -> 'e', 'o' -> 'f').
Return the decoded message.

Example 1:

Input: key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
Output: "this is a secret"
Explanation: The diagram above shows the substitution table.
It is obtained by taking the first appearance of each letter in "the quick brown fox jumps
over the lazy dog".

Example 2:

Input: key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
Output: "the five boxing wizards jump quickly"
Explanation: The diagram above shows the substitution table.
It is obtained by taking the first appearance of each letter in "eljuxhpwnyrdgtqkviszcfmabo".

Constraints:

26 <= key.length <= 2000
key consists of lowercase English letters and ' '.
key contains every letter in the English alphabet ('a' to 'z') at least once.
1 <= message.length <= 2000
message consists of lowercase English letters and ' '.

 */

package HashTable;

import java.util.HashMap;

public class DecodeTheMessage_3 {

    public static void main(String[] args){
        String key = "the quick brown fox jumps over the lazy dog";
        String message = "vkbs bs t suepuv";
        System.out.println(decodeMessage(key,message));
    }

    public static String decodeMessage(String key, String message) {
        HashMap<Character,Character> map = new HashMap<>();
        int count=0;
        for(char c : key.toCharArray()){
            if(c ==' '|| map.containsKey(c))
                continue;
            map.put(c, (char) ('a'+count++));
        }
        StringBuilder ans = new StringBuilder();
        for(char d : message.toCharArray()){
            ans.append((d==' ')?' ':map.get(d));
        }
        return ans.toString();
    }
}

/*

class Solution {
	public static String decodeMessage(String key, String message) {
		char[] table = new char[26];
		char t = 'a';
		for (char c : key.toCharArray()) {
			int k = c - 'a';
			if (k >= 0 && table[k] == 0)
				table[k] = t++;
		}
		char[] msgChars = message.toCharArray();
		for (int i = 0, n = msgChars.length; i < n; i++) {
			int k = msgChars[i] - 'a';
			if (k >= 0)
				msgChars[i] = table[k];
		}
		return new String(msgChars);
	}
}

class Solution {
    public String decodeMessage(String key, String message) {
        int[] table = new int[26];
        int k = 0;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c >= 'a' && c <= 'z') {
                int index = c - 'a';
                if (table[index] == 0) {
                    table[index] = 'a' + k;
                    k++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                sb.append(' ');
            } else if (c >= 'a' && c <= 'z') {
                sb.append((char)table[c - 'a']);
            } else {
                // Handle invalid characters here
            }
        }
        return sb.toString();
    }
}

 */
