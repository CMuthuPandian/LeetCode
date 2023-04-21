/*

You are given a 0-indexed string num of length n consisting of digits.
Return true if for every index i in the range 0 <= i < n, the digit i occurs num[i] times in num,
otherwise return false.

Example 1:

Input: num = "1210"
Output: true
Explanation:
num[0] = '1'. The digit 0 occurs once in num.
num[1] = '2'. The digit 1 occurs twice in num.
num[2] = '1'. The digit 2 occurs once in num.
num[3] = '0'. The digit 3 occurs zero times in num.
The condition holds true for every index in "1210", so return true.

Example 2:

Input: num = "030"
Output: false
Explanation:
num[0] = '0'. The digit 0 should occur zero times, but actually occurs twice in num.
num[1] = '3'. The digit 1 should occur three times, but actually occurs zero times in num.
num[2] = '0'. The digit 2 occurs zero times in num.
The indices 0 and 1 both violate the condition, so return false.

Constraints:

n == num.length
1 <= n <= 10
num consists of digits.

 */

package StringProblems;

public class EqualDIgitAndValueCount_5 {

    public static void main(String[] args){
        String num = "1210";
        System.out.println(digitCount(num));
    }

    public static boolean digitCount(String num) {
        int[] freq = new int[10];
        for(int i=0;i<num.length();i++){
            int a = num.charAt(i)-'0';
            freq[a]++;
        }
        for(int i=0;i<num.length();i++){
            if(freq[i]==(num.charAt(i)-'0')){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

}

/*

class Solution {
    public boolean digitCount(String num) {
        int[] freq = new int[10];

        for(int i=0; i<num.length(); i++){
            ++freq[num.charAt(i)-'0'];
        }

        for(int i=0; i<num.length(); i++){
            if(freq[i] != num.charAt(i)-'0')return false;
        }

        return true;
    }
}

class Solution {
    public boolean digitCount(String num) {
        for(int i=0; i<num.length(); i++) {
            int letterCount = num.length()-num.replace(String.valueOf(i),"").length();
            if(letterCount != Integer.parseInt(String.valueOf(num.charAt(i)))) return false;
        }
        return true;

    }
}

class Solution {
    public boolean digitCount(String num) {

        int[] arr = new int[10];
        Arrays.fill(arr, 0);

        for(int i = 0; i< num.length(); i++){

            arr[Character.getNumericValue(num.charAt(i))]++;

        }
        //System.out.println(arr[1]);

        boolean res = false;
        int counter = 0;
        for(int j=0; j< num.length(); j++){
            if(Character.getNumericValue(num.charAt(j)) == arr[j]) counter++;
        }

        if(counter == num.length()) res = true;

        return res;


    }
}

 */