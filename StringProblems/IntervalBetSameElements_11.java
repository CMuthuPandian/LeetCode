/*

You are given a 0-indexed array of n integers arr.
The interval between two elements in arr is defined as the absolute difference between their indices. More formally, the interval between arr[i] and arr[j] is |i - j|.
Return an array intervals of length n where intervals[i] is the sum of intervals between arr[i] and each element in arr with the same value as arr[i].
Note: |x| is the absolute value of x.

Example 1:

Input: arr = [2,1,3,1,2,3,3]
Output: [4,2,7,2,4,4,5]
Explanation:
- Index 0: Another 2 is found at index 4. |0 - 4| = 4
- Index 1: Another 1 is found at index 3. |1 - 3| = 2
- Index 2: Two more 3s are found at indices 5 and 6. |2 - 5| + |2 - 6| = 7
- Index 3: Another 1 is found at index 1. |3 - 1| = 2
- Index 4: Another 2 is found at index 0. |4 - 0| = 4
- Index 5: Two more 3s are found at indices 2 and 6. |5 - 2| + |5 - 6| = 4
- Index 6: Two more 3s are found at indices 2 and 5. |6 - 2| + |6 - 5| = 5

Example 2:

Input: arr = [10,5,10,10]
Output: [5,0,3,4]
Explanation:
- Index 0: Two more 10s are found at indices 2 and 3. |0 - 2| + |0 - 3| = 5
- Index 1: There is only one 5 in the array, so its sum of intervals to identical elements is 0.
- Index 2: Two more 10s are found at indices 0 and 3. |2 - 0| + |2 - 3| = 3
- Index 3: Two more 10s are found at indices 0 and 2. |3 - 0| + |3 - 2| = 4

Constraints:

n == arr.length
1 <= n <= 105
1 <= arr[i] <= 105

 */

package StringProblems;

import java.util.Arrays;

public class IntervalBetSameElements_11 {

    public static void main(String[] args){
        int[] arr = {2,1,3,1,2,3,3};
        System.out.println(Arrays.toString(getDistances(arr)));
    }

    public static long[] getDistances(int[] arr) {
        long[] ans = new long[arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[i]==arr[j]){
                    ans[i]+=Math.abs(i-j);
                }
            }
            for(int k=i+1;k<arr.length;k++){
                if(arr[i]==arr[k]){
                    ans[i]+=Math.abs(i-k);
                }
            }
        }
        return ans;
    }

}

/*

class Solution {
    public long[] getDistances(int[] arr) {
        long[] count = new long[100001];
        long[] sum = new long[100001];

        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
            count[val]++;
            sum[val] += i;
        }

        long[] ans = new long[arr.length];
        long[] leftCounts = new long[100001];
        long[] leftSums = new long[100001];

        for(long i = 0; i < arr.length; i++) {
            long iAns = 0L;
            int val = arr[(int)i];
            long rightCount = count[val] - 1;
            long rightSum = sum[val] - i;
            long leftCount = leftCounts[val];
            long leftSum = leftSums[val];

            iAns = (leftCount * i) - leftSum;
            iAns += (rightSum - (rightCount * i));

            leftCounts[val]++;
            leftSums[val] += i;
            count[val]--;
            sum[val] -= i;

            ans[(int)i] = iAns;
        }

        return ans;
    }
}

class Solution {
     long[]  ans;
    public long[] getDistances(int[] arr) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int n = arr.length;
        for(int i = 0 ; i<n;++i) {
            if(map.get(arr[i]) ==null) {
                map.put(arr[i],  new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }

      ans  = new long[n];
for(Integer k : map.keySet()) {
     // System.out.println(k + "    "  +map.get(k));
   find(map.get(k)) ;
}
        return ans;

    }

    public void find(ArrayList<Integer> ar)

    {   int n = ar.size();
        long[] l = new long[n];
        long[] r = new long[n];
        l[0] = (long)ar.get(0);
        r[n-1] = (long)ar.get(n-1);

        for(int i = 1 ; i<n;++i) {
            l[i] = (long)ar.get(i) + l[i-1];
        }

          for(int i = n-2 ; i>=0;--i) {
            r[i] = (long)ar.get(i) + r[i+1];
        }

        for(int i = 0 ; i<n;++i) {
          int index=ar.get(i);

            long smaller= i==0 ?0 : ((long)i*index)-(l[i-1]);

            long larger= i == n-1 ?0 : r[i+1]-((long)(n-i-1)*index);

            ans[index]=smaller+larger;
        }
    }
}

//Space Complexity: O(n)
//Time Complexity: O(n)
class Solution {
    public long[] getDistances(int[] arr) {
       Map<Integer, List<Integer>> in = new HashMap<>();

       for(int i = 0; i < arr.length; i++) {
           in.putIfAbsent(arr[i], new ArrayList<Integer>());
           in.get(arr[i]).add(i);
       }

       long[] ans = new long[arr.length];
       for(int i: in.keySet()) {
           long smaller = 0, larger = 0;
           int st = in.get(i).get(0);
           for(int j = 1; j < in.get(i).size(); j++) {
               larger += in.get(i).get(j) - st;
           }
           ans[st] = larger;
           for(int j = 1; j < in.get(i).size(); j++) {
               smaller += (j - 1) * (in.get(i).get(j) - in.get(i).get(j - 1));
               larger -= (in.get(i).size() - j - 1) * (in.get(i).get(j) - in.get(i).get(j - 1));
               ans[in.get(i).get(j)] = smaller + larger;
           }
       }

       return ans;
    }
}

 */