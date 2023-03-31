/*

Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.

Example 2:

Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]

Constraints:

1 <= pattern.length <= 20
1 <= words.length <= 50
words[i].length == pattern.length
pattern and words[i] are lowercase English letters.


 */

package HashTable;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class FindAndReplacePattern_4 {

    public static void main(String[] args){
        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        System.out.println(findAndReplacePattern(words,pattern));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        String pat = transform(pattern);
        List<String> res = new ArrayList();
        for(String s : words){
            String temp = transform(s);
            if(temp.equals(pat)){
                res.add(s);
            }
        }
        return res;
    }

    public static String transform(String s){
        HashMap<Character,Character> ans = new HashMap<>();
        char c = 'a';
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ans.containsKey(ch)==false){
                sb.append(c);
                ans.put(ch,c);
                c++;
            }
            else{
                sb.append(ans.get(ch));
            }
        }
        return sb.toString();
    }
}

/*

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();

        for(String word : words) {
            if(match(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean match(String s, String t) {
        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for(int i = 0; i < t.length(); i++) {
            if(map1[s.charAt(i)] != map2[t.charAt(i)]) {
                return false;
            }
            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }

        return true;
    }
}

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList();
        for(String i : words)
        if(check(i, pattern))
        list.add(i);

        return list;
    }
    static boolean check(String a, String  b)
    {
        for(int i =0;i<a.length();i++)
        if(a.indexOf(a.charAt(i)) != b.indexOf(b.charAt(i)))
        return false;
        return true;
    }
}

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        int[] p = normalize(pattern);
        for (String word : words) {
            if (Arrays.equals(p, normalize(word))) {
                result.add(word);
            }
        }
        return result;
    }

    private int[] normalize(String word) {
        int[] normalized = new int[word.length()];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            map.putIfAbsent(word.charAt(i), map.size());

            normalized[i] = map.get(word.charAt(i));
        }
        return normalized;
    }
}

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
                List<String> ans=new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(check(word,pattern)){
                ans.add(word);
            }
        }
        return ans;
    }
    public boolean check(String a, String b){
        if(a.length()!=b.length()){
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if(a.indexOf(a.charAt(i))!=b.indexOf(b.charAt(i))){
                return false;
            }
        }
        return true;
    }
}


 */