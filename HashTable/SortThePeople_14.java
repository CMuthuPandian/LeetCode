/*

You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
For each index i, names[i] and heights[i] denote the name and height of the ith person.
Return names sorted in descending order by the people's heights.

Example 1:

Input: names = ["Mary","John","Emma"], heights = [180,165,170]
Output: ["Mary","Emma","John"]
Explanation: Mary is the tallest, followed by Emma and John.

Example 2:

Input: names = ["Alice","Bob","Bob"], heights = [155,185,150]
Output: ["Bob","Alice","Bob"]
Explanation: The first Bob is the tallest, followed by Alice and the second Bob.

Constraints:

n == names.length == heights.length
1 <= n <= 103
1 <= names[i].length <= 20
1 <= heights[i] <= 105
names[i] consists of lower and upper case English letters.
All the values of heights are distinct.

 */

package HashTable;

import java.util.HashMap;
import java.util.Arrays;

public class SortThePeople_14 {

    public static void main(String[] args){
       String[] names = {"Mary","John","Emma"};
       int[] heights = {180,165,170};
       System.out.println(Arrays.toString(sortPeople(names,heights)));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String> ans = new HashMap<>();
        for(int i=0;i<heights.length;i++){
            ans.put(heights[i],names[i]);
        }
        Arrays.sort(heights);
        String[] finalAns = new String[names.length];
        int count=0;
        for(int i=heights.length-1;i>=0;i--){
            finalAns[count]=ans.get(heights[i]);
            count++;
        }
        return finalAns;
    }

}

/*

class Solution {
    public static void quickSort(int[] arr, String[] arrNames, int low, int high) {
        if (arr == null || arr.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] > pivot) {
                i++;
            }

            while (arr[j] < pivot) {
                j--;
            }

            if (i <= j) {
                String tempNames = arrNames[i];
                int temp = arr[i];
                arr[i] = arr[j];
                arrNames[i] = arrNames[j];
                arr[j] = temp;
                arrNames[j] = tempNames;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(arr, arrNames, low, j);

        if (high > i)
            quickSort(arr, arrNames, i, high);
    }

    public String[] sortPeople(String[] names, int[] heights) {
        quickSort(heights, names,0,names.length-1);
        return names;
    }
}

 *
