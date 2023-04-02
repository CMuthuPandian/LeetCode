/*

There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.
You are given an integer array groupSizes, where groupSizes[i] is the size of the group that
person i is in. For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
Return a list of groups such that each person i is in a group of size groupSizes[i].
Each person should appear in exactly one group, and every person must be in a group. If there
are multiple answers, return any of them. It is guaranteed that there will be at least one valid solution for the given input.

Example 1:

Input: groupSizes = [3,3,3,3,3,1,3]
Output: [[5],[0,1,2],[3,4,6]]
Explanation:
The first group is [5]. The size is 1, and groupSizes[5] = 1.
The second group is [0,1,2]. The size is 3, and groupSizes[0] = groupSizes[1] = groupSizes[2] = 3.
The third group is [3,4,6]. The size is 3, and groupSizes[3] = groupSizes[4] = groupSizes[6] = 3.
Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].

Example 2:

Input: groupSizes = [2,1,3,3,3,2]
Output: [[1],[0,5],[2,3,4]]

Constraints:

groupSizes.length == n
1 <= n <= 500
1 <= groupSizes[i] <= n

 */

package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class GroupPeopleBasedOnSize_6 {

    public static void main(String[] args){
        int[] arr = {2,1,3,3,3,2};
        System.out.println(groupThePeople(arr));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap();
        for(int i=0;i<groupSizes.length;i++){
            map.putIfAbsent(groupSizes[i],new ArrayList<>());
            map.get(groupSizes[i]).add(i);
            if(map.get(groupSizes[i]).size()==groupSizes[i])
            {
                ans.add(map.get(groupSizes[i]));
                map.remove(groupSizes[i]);
            }
        }

        return ans;
    }
}

/*

class Solution {
    private int Max(int arr[]){
        int max=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max)
               max=arr[i];
        }
        return max;
    }
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
         List<List<Integer>> list  = new ArrayList<>();
          if(groupSizes.length==1){
               list.add(Arrays.asList(0));
               return list;
         }
         for(int i=1;i<=Max(groupSizes);i++){
             List<Integer> temp = new ArrayList<>();
             for(int j=0;j<groupSizes.length;j++){
                 if(groupSizes[j]==i){
                     if(temp.size()>=i){
                         list.add(temp);
                         temp.clear();
                     }
                     temp.add(j);
                 }
             }
             if(temp.size()>0){
                    list.add(temp);
             }
         }
         return list;
    }
}

class Solution {
    public List<List<Integer>> groupThePeople(int[] grp) {
        List<List<Integer>> res = new ArrayList<>();
        //HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int n=grp.length;
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for(int i=0;i<n;i++){
            if(arr[grp[i]] == null)arr[grp[i]] = new ArrayList<>();
            arr[grp[i]].add(i);
            if(arr[grp[i]].size() == grp[i]){
                res.add(arr[grp[i]]);
                arr[grp[i]] = new ArrayList<>();
            }
        }

        return res;
    }
}

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        List<List<Integer>> list = new ArrayList();

        for(int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];

            List<Integer> group = map.getOrDefault(size, new ArrayList());
            group.add(i);
            map.put(size, group);

            if(group.size() == size) {
                list.add(group);
                map.remove(size);
            }
        }

        return list;
    }
}

*/
