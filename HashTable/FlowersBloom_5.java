/*

You are given a 0-indexed 2D integer array flowers, where flowers[i] = [starti, endi] means the ith flower will be in full bloom from starti to endi (inclusive). You are also given a 0-indexed integer array persons of size n, where persons[i] is the time that the ith person will arrive to see the flowers.
Return an integer array answer of size n, where answer[i] is the number of flowers that are in full bloom when the ith person arrives.

Example 1:

Input: flowers = [[1,6],[3,7],[9,12],[4,13]], persons = [2,3,7,11]
Output: [1,2,2,2]
Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
For each person, we return the number of flowers in full bloom during their arrival.

Example 2:

Input: flowers = [[1,10],[3,3]], persons = [3,3,2]
Output: [2,2,1]
Explanation: The figure above shows the times when the flowers are in full bloom and when the people arrive.
For each person, we return the number of flowers in full bloom during their arrival.

Constraints:

1 <= flowers.length <= 5 * 104
flowers[i].length == 2
1 <= starti <= endi <= 109
1 <= persons.length <= 5 * 104
1 <= persons[i] <= 109

 */

package HashTable;

import java.util.Arrays;

public class FlowersBloom_5 {

    public static void main(String[] args){
        int[][] flowers = {{1,6},{3,7},{9,12},{4,13}};
        int[]persons = {2,3,7,11};
        System.out.println(Arrays.toString(fullBloomFlowers(flowers,persons)));
    }

    public static int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int[] ans = new int[persons.length];
        for(int j=0;j<persons.length;j++){
            int count=0;
            for(int i=0;i<flowers.length;i++){
                if(persons[j]>=flowers[i][0] && persons[j]<=flowers[i][1]){
                    count++;
                }
            }
            ans[j]=count;
        }
        return ans;
    }
}

/*

The above code will exceed time limit for big arrays

class Solution {
    public int[] fullBloomFlowers(int[][] fl, int[] persons)
    {
        Integer[] st = new Integer[fl.length];
        Integer[] en = new Integer[fl.length];

        for(int i=0; i<fl.length; i++) {
            st[i] = fl[i][0];
            en[i] = fl[i][1];
        }

        Arrays.sort(st); Arrays.sort(en);
        int j =0;
        int[] ans = new int[persons.length];


        for(int p: persons) {
            ans[j] = bs(st, p) - bs(en,p-1);
            j++;
        }
        return ans;
    }


    int bs(Integer[] arr, int t) {
        int l = 0;
        int r = arr.length-1;
        int ind = -1;
        while(l <= r) {
            int m = (l + r)/2;
            if (arr[m] > t) {
                r = m-1;
            } else {
                ind = Math.max(ind, m);
                l = m+1;
            }
        }
        return ind+1;
    }
}

class Solution {

    private int binarySearch(int[] arr, int p) {
        int n=arr.length;
        int low=0, high=arr.length-1;
        int res=-1;

        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] > p) {
                high=mid-1;
            } else {
                res=Math.max(res, mid);
                low=mid+1;
            }
        }

        return res+1;
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        int n=persons.length;
        int[] chalu = new int[flowers.length];
        int[] khatam = new int[flowers.length];

        for(int i=0; i<flowers.length; i++) { chalu[i] = flowers[i][0]; khatam[i] = flowers[i][1]; }
        Arrays.sort(chalu); Arrays.sort(khatam);

        int[] res = new int[n];

        for(int i=0; i<n; i++) {
            res[i] = binarySearch(chalu, persons[i]) - binarySearch(khatam, persons[i]-1);
        }

        return res;
    }
}

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<flowers.length; i++) {
            mp.put(flowers[i][0], mp.getOrDefault(flowers[i][0],0)+1);
            mp.put(flowers[i][1]+1, mp.getOrDefault(flowers[i][1]+1,0)-1);
        }
        List<Map.Entry<Integer, Integer>> f = new ArrayList<>(mp.entrySet());
        Collections.sort(f, (a,b)->a.getKey()-b.getKey());

        int n = persons.length;
        int[] ret = new int[n];
        List<int[]> p = new ArrayList<>();
        for(int i=0; i<n; i++){
            p.add(new int[]{i, persons[i]});
        }
        Collections.sort(p, (a,b)->a[1]-b[1]);

        int s = -1;
        int sum = 0;
        for(int i=0; i<n; i++){
            int[] cur = p.get(i);
            while(s<f.size()-1 && cur[1]>=f.get(s+1).getKey()){
                s++;
                sum+=f.get(s).getValue();
            }
            ret[cur[0]] = sum;
        }
        return ret;
    }
}


 */