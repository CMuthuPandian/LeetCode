/*

A pangram is a sentence where every letter of the English alphabet appears at least once.
Given a string sentence containing only lowercase English letters, return true if sentence is
a pangram, or false otherwise.

Example 1:

Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.

Example 2:

Input: sentence = "leetcode"
Output: false

Constraints:

1 <= sentence.length <= 1000
sentence consists of lowercase English letters.

 */

package HashTable;

import java.util.HashSet;

public class SentenceIsPangram_12 {

    public static void main(String[] args){
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        System.out.println(checkIfPangram(sentence));
    }

    public static boolean checkIfPangram(String sentence) {
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<sentence.length();i++){
            if(set.contains(sentence.charAt(i))){
                continue;
            }
            else{
                set.add(sentence.charAt(i));
            }
        }
        if(set.size()==26)
            return true;
        return false;
    }

}

/*

class Solution {
    public boolean checkIfPangram(String sentence) {
        for(char ch='a';ch<='z';ch++){
            if(sentence.indexOf(ch)<0)
                return false;
        }
        return true;
    }
}


class Solution {
    public boolean checkIfPangram(String sentence) {

        int arr[] = new int[26];

        for(int i =0 ; i < sentence.length() ; i++)
        {
            arr[sentence.charAt(i)-'a']++;
        }

        for(int i= 0 ; i < arr.length ; i++)
        {
            if(arr[i]==0)
                return false;
        }

        return true;
    }
}

class Solution {
    public boolean checkIfPangram(String sentence) {

        int arr[] = new int[26];

        for(int i =0 ; i < sentence.length() ; i++)
        {
            arr[sentence.charAt(i)-'a']++;
        }

        for(int i= 0 ; i < arr.length ; i++)
        {
            if(arr[i]==0)
                return false;
        }

        return true;
    }
}

class Solution {
    public boolean checkIfPangram(String s) {
        HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<s.length();i++) hs.add(s.charAt(i));
        if(hs.size()==26) return true;
        return false;
    }
}

class Solution {
    public boolean checkIfPangram(String sentence) {
        int n=sentence.length();
        int[] fre= new int[26];
        for(int i=0; i<n; i++){
            char ch = sentence.charAt(i);
            int idx = ch-'a';
            fre[idx]++;
        }
        for(int i=0; i<26; i++){
            if(fre[i]<1){
                return false;
            }
        }
        return true;



    }
}

class Solution {
    public boolean checkIfPangram(String sentence) {
       boolean[] arr = new boolean[26] ;
       for(int i = 0; i < sentence.length(); i++){
        //    int character = sentence.charAt(i) - 97;
           arr[sentence.charAt(i) - 97] = true;
       }
       for(int i = 0; i < arr.length; i++){
           if(!arr[i]){
               return false;
           }
       }
       return true;
    }
}

 */