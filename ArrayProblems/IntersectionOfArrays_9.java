package ArrayProblems;

/*

Given two integer arrays nums1 and nums2, return an array of their intersection.
Each element in the result must appear as many times as it shows in both arrays and
you may return the result in any order.

 */

import java.util.*;

public class IntersectionOfArrays_8 {

    public static void main(String[] args){
        int[] arr1 = {1,2,2,1};
        int[] arr2 = {2,2};
        System.out.println(Arrays.toString(intersect(arr1,arr2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2){
        ArrayList<Integer> list = new ArrayList<>();
        int[] temp;
        if(nums1.length<nums2.length){
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        for(int i=0;i<nums1.length;i++){
            if(nums1.length==1||nums2.length==1){
                if(nums1[i]==nums2[i]){
                    list.add(nums1[i]);
                    break;
                }
            }
            for(int j=0;j<nums2.length-1;j++){
                if(nums1[i]==nums2[j]){
                    if(j==0){
                        if(nums1[i+1]==nums2[j+1]){
                            list.add(nums1[i]);
                            list.add(nums1[i+1]);
                        }
                    }
                    else{
                        if(nums1[i+1]==nums2[j+1]){
                            list.add(nums1[i]);
                            list.add(nums1[i+1]);
                        }
                        else if(nums1[i+1]==nums2[j-1]){
                            list.add(nums1[i]);
                            list.add(nums1[i+1]);
                        }
                    }
                }
            }
        }
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}

/*

Output:

[2, 2]

 */

/*

Other possible answer with less time complexicity:

public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums1){
            int freq = map.getOrDefault(i, 0);
            map.put(i, freq + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : nums2){
            if(map.get(i) != null && map.get(i) > 0){
                list.add(i);
                map.put(i, map.get(i) - 1);
            }
        }
        int[] ret = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

 */