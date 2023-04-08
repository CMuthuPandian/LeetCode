/*

There are n rings and each ring is either red, green, or blue. The rings are distributed across ten rods labeled from 0 to 9.

You are given a string rings of length 2n that describes the n rings that are placed onto the rods. Every two characters in rings forms a color-position pair that is used to describe each ring where:

The first character of the ith pair denotes the ith ring's color ('R', 'G', 'B').
The second character of the ith pair denotes the rod that the ith ring is placed on ('0' to '9').
For example, "R3G2B1" describes n == 3 rings: a red ring placed onto the rod labeled 3, a green ring placed onto the rod labeled 2, and a blue ring placed onto the rod labeled 1.

Return the number of rods that have all three colors of rings on them.

Example 1:

Input: rings = "B0B6G0R6R0R6G9"
Output: 1
Explanation:
- The rod labeled 0 holds 3 rings with all colors: red, green, and blue.
- The rod labeled 6 holds 3 rings, but it only has red and blue.
- The rod labeled 9 holds only a green ring.
Thus, the number of rods with all three colors is 1.

Example 2:

Input: rings = "B0R0G0R9R0B0G0"
Output: 1
Explanation:
- The rod labeled 0 holds 6 rings with all colors: red, green, and blue.
- The rod labeled 9 holds only a red ring.
Thus, the number of rods with all three colors is 1.

Example 3:

Input: rings = "G4"
Output: 0
Explanation:
Only one ring is given. Thus, no rods have all three colors.

Constraints:

rings.length == 2 * n
1 <= n <= 100
rings[i] where i is even is either 'R', 'G', or 'B' (0-indexed).
rings[i] where i is odd is a digit from '0' to '9' (0-indexed).

 */

package HashTable;

import java.util.HashSet;
import java.util.Set;

public class RingAndRods_11 {

    public static void main(String[] args){
        String rings = "G3R3R7B7R5B1G8G4B3G6";
        System.out.println(countPoints(rings));
    }

    public static int countPoints(String rings) {
        Set<Integer> r = new HashSet<>();
        Set<Integer> g = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for(int i = 0; i < rings.length(); i += 2){
            if(rings.charAt(i) == 'R')
                r.add(rings.charAt(i + 1) - '0');
            else if(rings.charAt(i) == 'B')
                b.add(rings.charAt(i + 1) - '0');
            else
                g.add(rings.charAt(i + 1) - '0');
        }
        int ans = 0;
        for(int i = 0; i <= 9; i++){
            if(r.contains(i) && g.contains(i) && b.contains(i))
                ans++;
        }
        return ans;
    }
}

/*

class Solution {
  1) Create three integer arrays of size 10 for three colours respectively
  2) Iterate the string whenever you found the digit get the previous
  character from the string and add the ring in the repective array
  3) Once completed the iteration iterate the arrays and whenever you found
  values in same index of each arrays then increase the count

  Positive Case - > Rings in all the colours and the rods
  Negative Case - > Rings are not there in all the rods
  Edge Case - > Only one rod and one ring
public static int countPoint(String rings) {
        int[] b = new int[10];
        int[] g = new int[10];
        int[] r = new int[10];
        for(int i = 1; i < rings.length(); i = i + 2){
            if(rings.charAt(i - 1) == 'B')
                b[rings.charAt(i) - 48]++;
            else if(rings.charAt(i - 1) == 'G')
                g[rings.charAt(i) - 48]++;
            else
                r[rings.charAt(i) - 48]++;
        }
        int count = 0;
        for(int i = 0; i < 10; i++){
            if(b[i] > 0 && g[i] > 0 && r[i] > 0)
                count++;
        }
        return count;
    }
}

public static int countPoints(String rings) {
        int j=1;
        int count=0;
        for(int i=0;i<10;i++){
            boolean red = false;
            boolean green = false;
            boolean blue = false;
            while(j<rings.length()){
                if(i==(rings.charAt(j)-'0')){
                    if(rings.charAt(j-1)=='R'){
                        red = true;
                    }
                    else if(rings.charAt(j-1)=='G'){
                        green = true;
                    }
                    else if(rings.charAt(j-1)=='B'){
                        blue = true;
                    }
                }
                j+=2;
            }
            if(red==true && green==true && blue==true){
                count++;
            }
            j=1;
        }
        return count;
    }

 */