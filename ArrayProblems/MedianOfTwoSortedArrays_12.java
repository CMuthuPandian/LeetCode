/*

Given two sorted arrays nums1 and nums2 of size m and n respectively,
return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

 */

package ArrayProblems;

public class MedianOfTwoSortedArrays_12 {

    public static void main(String[] args){
        int[] arr1 = {1,2};
        int[] arr2 = {3,4};
        System.out.println(findMedianSortedArrays(arr1,arr2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length+nums2.length];
        int i=0;
        int point1=0;
        int point2=0;
        while(point1<nums1.length&&point2<nums2.length){
            if(nums1[point1]<nums2[point2]){
                ans[i]=nums1[point1];
                i++;
                point1++;
            }
            else{
                ans[i]=nums2[point2];
                i++;
                point2++;
            }
        }
        while(i<ans.length){
            while(point1<nums1.length){
                ans[i]=nums1[point1];
                i++;
                point1++;
            }
            while(point2<nums2.length){
                ans[i]=nums2[point2];
                i++;
                point2++;
            }
        }
        if(ans.length%2==0){
            return ((float)(ans[ans.length/2]+ans[(ans.length/2)-1])/2);
        }
        else{
            return (float)ans[ans.length/2];
        }
    }
}

/*

This solution is best and easy to understand

 */
