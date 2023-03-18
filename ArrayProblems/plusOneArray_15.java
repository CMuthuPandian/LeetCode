package ArrayProblems;

/*

You are given a large integer represented as an integer array digits,
where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.


Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].


Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].


Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

 */

import java.util.Arrays;

public class plusOneArray_15 {

    public static void main(String[] args){
        int[] arr = {9,6,3,7,2};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits){
        int sum = 0;
        int[] ans = new int[digits.length+1];
        for(int i=0;i<digits.length;i++){
            sum = sum + digits[i];
        }
        if(sum==(9*digits.length)){
            for(int i =0;i<digits.length+1;i++){
                if(i==0)
                    ans[i]=1;
                else
                    ans[i]=0;
            }
            return ans;
        }
        int j = digits.length-1;
        while(digits[j]==9){
            digits[j]=0;
            j--;
        }
        digits[j]=digits[j]+1;
        return digits;
    }
}

/*

Output:

[9, 6, 3, 7, 3]

 */

/*

Same approach with another form of code:

public int[] plusOne(int[] digits) {

    int n = digits.length;
    for(int i=n-1; i>=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }

        digits[i] = 0;
    }

    int[] newNumber = new int [n+1];
    newNumber[0] = 1;

    return newNumber;
}

 */