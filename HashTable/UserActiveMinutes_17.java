/*

You are given the logs for users' actions on LeetCode, and an integer k. The logs are represented by a 2D integer array logs where each logs[i] = [IDi, timei] indicates that the user with IDi performed an action at the minute timei.
Multiple users can perform actions simultaneously, and a single user can perform multiple actions in the same minute.
The user active minutes (UAM) for a given user is defined as the number of unique minutes in which the user performed an action on LeetCode. A minute can only be counted once, even if multiple actions occur during it.
You are to calculate a 1-indexed array answer of size k such that, for each j (1 <= j <= k), answer[j] is the number of users whose UAM equals j.
Return the array answer as described above.



Example 1:

Input: logs = [[0,5],[1,2],[0,2],[0,5],[1,3]], k = 5
Output: [0,2,0,0,0]
Explanation:
The user with ID=0 performed actions at minutes 5, 2, and 5 again. Hence, they have a UAM of 2 (minute 5 is only counted once).
The user with ID=1 performed actions at minutes 2 and 3. Hence, they have a UAM of 2.
Since both users have a UAM of 2, answer[2] is 2, and the remaining answer[j] values are 0.

Example 2:

Input: logs = [[1,1],[2,2],[2,3]], k = 4
Output: [1,1,0,0]
Explanation:
The user with ID=1 performed a single action at minute 1. Hence, they have a UAM of 1.
The user with ID=2 performed actions at minutes 2 and 3. Hence, they have a UAM of 2.
There is one user with a UAM of 1 and one with a UAM of 2.
Hence, answer[1] = 1, answer[2] = 1, and the remaining values are 0.

Constraints:

1 <= logs.length <= 104
0 <= IDi <= 109
1 <= timei <= 105
k is in the range [The maximum UAM for a user, 105].

 */

package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UserActiveMinutes_17 {

    public static void main (String[] args){
        int[][] logs = {{0,5},{1,2},{0,2},{0,5},{1,3}};
        int k=5;
        System.out.println(Arrays.toString(findingUsersActiveMinutes(logs,k)));
    }

    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] arr = new int[k];
        HashMap<Integer,Set<Integer>> ans = new HashMap();
        for(int i=0;i<logs.length;i++){
            Set s = ans.getOrDefault(logs[i][0],new HashSet<>());
            s.add(logs[i][1]);
            ans.put(logs[i][0],s);
        }
        for(Set s:ans.values()) {
            arr[s.size()-1]++;
        }
        return arr;
    }
}

/*

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> h = new HashMap<>();
        for(int i=0;i<logs.length;i++){
            int user = logs[i][0];
            if(h.containsKey(user)){
                h.get(user).add(logs[i][1]);
            }
            else{
                HashSet<Integer> h1 = new HashSet<>();
                h1.add(logs[i][1]);
                h.put(user,h1);
            }
        }
        int arr[] = new int[k];
        for(int i=0;i<k;i++){
            arr[i] = 0;
        }
        for(Map.Entry<Integer, HashSet<Integer>> e: h.entrySet()){
            int size = e.getValue().size();
            arr[size-1]+=1;
        }
        return arr;
    }
}

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans=new int[k];
        Arrays.sort(logs, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            else
                return a[1] - b[1];
        });
        int count=0;
        for(int i=0;i<logs.length;i++){
            if(i==logs.length-1 || logs[i][0]!=logs[i+1][0]){
                ans[count]++;
                count=0;
            }
            else if(logs[i][0]==logs[i+1][0]){
                if(logs[i][1]!=logs[i+1][1]) count++;
            }
        }
        return ans;
    }
}

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i< logs.length;i++) {
            map.computeIfAbsent(logs[i][0], ks -> new HashSet<>() ).add(logs[i][1]);
        }
        for(var x:map.values()) {
            res[x.size()-1]++;
        }
        return res;
    }
}

 */
