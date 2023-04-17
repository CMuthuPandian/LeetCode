/*

A cell (r, c) of an excel sheet is represented as a string "<col><row>" where:
<col> denotes the column number c of the cell. It is represented by alphabetical letters.
For example, the 1st column is denoted by 'A', the 2nd by 'B', the 3rd by 'C', and so on.
<row> is the row number r of the cell. The rth row is represented by the integer r.
You are given a string s in the format "<col1><row1>:<col2><row2>", where <col1> represents the
column c1, <row1> represents the row r1, <col2> represents the column c2, and <row2> represents
the row r2, such that r1 <= r2 and c1 <= c2.

Return the list of cells (x, y) such that r1 <= x <= r2 and c1 <= y <= c2. The cells should be
represented as strings in the format mentioned above and be sorted in non-decreasing order first
by columns and then by rows.


Example 1:

Input: s = "K1:L2"
Output: ["K1","K2","L1","L2"]
Explanation:
The above diagram shows the cells which should be present in the list.
The red arrows denote the order in which the cells should be presented.

Example 2:

Input: s = "A1:F1"
Output: ["A1","B1","C1","D1","E1","F1"]
Explanation:
The above diagram shows the cells which should be present in the list.
The red arrow denotes the order in which the cells should be presented.

Constraints:

s.length == 5
'A' <= s[0] <= s[3] <= 'Z'
'1' <= s[1] <= s[4] <= '9'
s consists of uppercase English letters, digits and ':'.

 */

package StringProblems;

import java.util.List;
import java.util.ArrayList;

public class CellsInRangeOnExcelSheet_1 {

    public static void main(String[] args){
        String str = "A1:F1";
        System.out.println((cellsInRange(str)));
    }

    public static List<String> cellsInRange(String s) {
        char a = s.charAt(0);
        char b = s.charAt(3);
        int c = s.charAt(s.length()-1)-'0';
        int d = s.charAt(1)-'0';
        int count = ((int)b-(int)a)+1;
        int length = (count+1)*c;
        List<String> ans = new ArrayList<String>();
        for(char i =a;i<=b;i++){
            for(int j=d;j<=c;j++){
                ans.add(""+i+j);
            }
        }
        return ans;
    }
}

/*

class Solution {
    public List<String> cellsInRange(String s) {
        List<String> list = new ArrayList<>();
        char c1 = s.charAt(0),c2 = s.charAt(3);
        char r1 = s.charAt(1),r2 = s.charAt(4);
        for(char c = c1;c <= c2 ;c++){
            for(char r = r1;r <= r2;r++){
                list.add("" + c + r);
            }
        }
        return list;
    }
}
class Solution {
    public List<String> cellsInRange(String s) {
        char begin = s.charAt(0);
        char end = s.charAt(3);

        char start = s.charAt(1);
        char finish = s.charAt(4);

        List<String> res = new ArrayList<>();

        for (char i = begin; i <= end; i++) {
            for (char j = start; j <= finish; j++) {
                res.add(new String(new char[]{i, j}));
            }
        }

        return res;
    }
}
 */