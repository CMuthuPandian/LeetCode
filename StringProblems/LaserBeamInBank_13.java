/*

Anti-theft security devices are activated inside a bank. You are given a 0-indexed binary string
array bank representing the floor plan of the bank, which is an m x n 2D matrix. bank[i]
represents the ith row, consisting of '0's and '1's. '0' means the cell is empty, while'1'
means the cell has a security device.
There is one laser beam between any two security devices if both conditions are met:
The two devices are located on two different rows: r1 and r2, where r1 < r2.
For each row i where r1 < i < r2, there are no security devices in the ith row.
Laser beams are independent, i.e., one beam does not interfere nor join with another.

Return the total number of laser beams in the bank.

Example 1:

Input: bank = ["011001","000000","010100","001000"]
Output: 8
Explanation: Between each of the following device pairs, there is one beam. In total, there are 8 beams:
 * bank[0][1] -- bank[2][1]
 * bank[0][1] -- bank[2][3]
 * bank[0][2] -- bank[2][1]
 * bank[0][2] -- bank[2][3]
 * bank[0][5] -- bank[2][1]
 * bank[0][5] -- bank[2][3]
 * bank[2][1] -- bank[3][2]
 * bank[2][3] -- bank[3][2]
Note that there is no beam between any device on the 0th row with any on the 3rd row.
This is because the 2nd row contains security devices, which breaks the second condition.

Example 2:

Input: bank = ["000","111","000"]
Output: 0
Explanation: There does not exist two devices located on two different rows.


Constraints:

m == bank.length
n == bank[i].length
1 <= m, n <= 500
bank[i][j] is either '0' or '1'.

 */

package StringProblems;

public class LaserBeamInBank_13 {

    public static void main(String[] args){
        String[] bank = {"011001","000000","010100","001000"};
        System.out.println(numberOfBeams(bank));
    }

    public static int numberOfBeams(String[] bank) {
        int ans=0;
        int prev =0;
        for(int i=0;i<bank.length;i++){
            int count=0;
            for(int j=0;j<bank[i].length();j++){
                if(bank[i].charAt(j)=='1'){
                    count++;
                }
            }
            if(count >0){
                ans+=(count*prev);
                prev = count;
            }
        }
        return ans;
    }

}

/*

class Solution {
    public int counT(String str){
        int c=0;
        for(byte ch:str.getBytes()){
            c=c+((int)(ch-48));
        }
        return c;
    }
    public int numberOfBeams(String[] bank) {
        if(bank.length==1)return 0;
        long[] count=new long[bank.length];
        for(int i=0;i<bank.length;i++){
            count[i]=counT(bank[i]);
        }
        int sum=0;
        for(int i=0;i<count.length;i++){
            for(int j=i+1;j<count.length;j++){
                if(count[j]==0){
                    continue;
                }else{
                    sum=sum+((int)(count[i]*count[j]));
                    break;
                }
            }
        }
        return sum;
    }
}

class Solution {
    public int numberOfBeams(String[] bank) {
        int total=0,curr=0,n=bank[0].length();
        for(String str : bank){
            int temp=0;
            for(int i=0;i<n;i++){
                if(str.charAt(i)=='1')temp++;
            }

            if(temp>0){
                total+=curr*temp;
                curr=temp;
            }
        }

        return total;
    }
}

class Solution {
    public int countOnes(String str){
        int n = str.length();
        int res = 0;
        for(int i=0; i<n; i++){
            if(str.charAt(i) == '1'){
                res++;
            }

        }
        return res;
    }
    public int numberOfBeams(String[] b) {
        int n = b.length;
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        for(int i=0; i<n; i++){
            int ones = countOnes(b[i]);
            if(ones != 0){
                list.add(ones);
            }
        }

        for(int i=1; i<list.size(); i++){
            // System.out.print(res[i]+ " ");
            ans += list.get(i-1)*list.get(i);
        }

        return ans;
    }
}

class Solution {
    public int numberOfBeams(String[] bank) {
        int result = 0, counter = 0;
        List<Integer> aux = new ArrayList<>();
        for (String s : bank) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    counter++;
                }
            }
             if (counter > 0) {
                aux.add(counter);
            }
            counter = 0;
        }
        for (int k = 1; k < aux.size(); k++) {
            result += aux.get(k) * aux.get(k - 1);
        }
        return result;
    }
}

 */