/*

You are given an array points containing the coordinates of points on a 2D plane,
sorted by the x-values, where points[i] = [xi, yi] such that xi < xj for all
1 <= i < j <= points.length. You are also given an integer k.

Return the maximum value of the equation yi + yj + |xi - xj| where |xi - xj| <= k and
1 <= i < j <= points.length.

It is guaranteed that there exists at least one pair of points that satisfy the constraint
|xi - xj| <= k.

Example 1:

Input: points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
Output: 4
Explanation: The first two points satisfy the condition |xi - xj| <= 1 and if we calculate the equation we get 3 + 0 + |1 - 2| = 4. Third and fourth points also satisfy the condition and give a value of 10 + -10 + |5 - 6| = 1.
No other pairs satisfy the condition, so we return the max of 4 and 1.

Example 2:

Input: points = [[0,0],[3,0],[9,2]], k = 3
Output: 3
Explanation: Only the first two points have an absolute difference of 3 or less in the x-values,
and give the value of 0 + 0 + |0 - 3| = 3.

Constraints:

2 <= points.length <= 105
points[i].length == 2
-108 <= xi, yi <= 108
0 <= k <= 2 * 108
xi < xj for all 1 <= i < j <= points.length
xi form a strictly increasing sequence.

 */

package ArrayProblems;

public class MaxValueOfTheEquation_11 {

    public static void main(String[] args){
        int[][] arr = {{-17,-6},{-4,0},{-2,-16},{1,2},{0,11},{6,18}};
        int n = 13;
        System.out.println(findMaxValueOfEquation(arr,n));
    }

    public static int findMaxValueOfEquation(int[][] points, int k) {
        int temp0 = 0;
        int temp1 = 1;
        int i = 0;
        int j = 1;
        int max = Integer.MIN_VALUE;
        while(j<points.length){
            int ans = -(points[i][temp0]-points[j][temp0]);
            if(ans<=k){
                int finalAns = points[i][temp1]+points[j][temp1]+ans;
                if(finalAns>max)
                    max = finalAns;
                if(j==points.length-1) {
                    i++;
                    j = i + 1;
                }
                else
                    j++;
            }
            else{
                i++;
                j=i+1;
            }
        }
        return max;
    }

}

/*

Less time complexity solutions:

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int ans=Integer.MIN_VALUE;
		int i=0;
        int f=1;
        while(i < points.length) {
            if(f<i+1)
                f=i+1;
            for (int j = f; j <= points.length-1; j++) {
                if(points[j][0]>(points[i][0]+k))
					break;
                if((points[i][1]+points[j][1]+points[j][0]-points[i][0])>ans){
                    ans=points[i][1]+points[j][1]+points[j][0]-points[i][0];
                    f=j-1;
                }
            }
            i++;
        }
        return ans;
    }
}

public int findMaxValueOfEquation(int[][] points, int k) {
    //     int start = 0;
    //     int[] s = points[start];
    //     int max = Integer.MIN_VALUE;
    //     for(int i=1; i<points.length; i++){
    //         int[] e = points[i];
    //         while(e[0] - s[0] > k){
    //             start++;
    //             s = points[start];
    //         }

    //         for(int j=start; j<i; j++){
    //             int[] c = points[j];
    //             int tmp = e[1] + c[1] + e[0] - c[0];
    //             max = Math.max(max, tmp);
    //         }
    //     }

    //     return max;
    // }
}

 */