/*

You are given an array items, where each items[i] = [typei, colori, namei] describes the type,
color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
The ith item is said to match the rule if one of the following is true:
ruleKey == "type" and ruleValue == typei.
ruleKey == "color" and ruleValue == colori.
ruleKey == "name" and ruleValue == namei.
Return the number of items that match the given rule.

Example 1:

Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
Output: 1
Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].

Example 2:
Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
Output: 2
Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.

Constraints:

1 <= items.length <= 104
1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
ruleKey is equal to either "type", "color", or "name".
All strings consist only of lowercase letters.

 */

package StringProblems;

import java.util.ArrayList;
import java.util.List;

public class CountItemMatchRule_3 {

    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("phone");
        list1.add("blue");
        list1.add("pixel");
        List<String> list2 = new ArrayList<>();
        list2.add("computer");
        list2.add("silver");
        list2.add("lenovo");
        List<String> list3 = new ArrayList<>();
        list3.add("phone");
        list3.add("gold");
        list3.add("iphone");
        items.add(list1);
        items.add(list2);
        items.add(list3);
        String ruleKey = "color";
        String ruleValue = "silver";
        System.out.println(countMatches(items,ruleKey,ruleValue));
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;

        for(int i = 0 ;i<items.size();i++){
            if(ruleKey.equals("type") && items.get(i).get(0).equals(ruleValue)) res++;
            if(ruleKey.equals("color") && items.get(i).get(1).equals(ruleValue)) res++;
            if(ruleKey.equals("name") && items.get(i).get(2).equals(ruleValue)) res++;
        }

        return res;
    }
}

/*

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int counter = 0,len = items.size();
        int get = (ruleKey.equals("type"))? 0:(ruleKey.equals("color"))? 1:2;
        for (int i = 0; i < len; i++)
        {
            if(ruleValue.equals(items.get(i).get(get))) counter++;
        }
        return counter;
    }
}
class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int index = -1;
        if(ruleKey.compareTo("type") == 0)
            index = 0;
        else if(ruleKey.compareTo("color") == 0)
            index = 1;
        else
            index = 2;

        int count = 0;


        for(List<String> i : items)
        {

            String elem = i.get(index);
            if(elem.compareTo(ruleValue) == 0)
                count += 1;

        }

        return count;
    }
}

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count=0;
        for(List<String> item : items) {
            if (ruleKey.equals("type")  && item.get(0).equals(ruleValue)) {
                count++;
            } else if(ruleKey.equals("color") && item.get(1).equals(ruleValue)) {
                count++;
            } else if(ruleKey.equals("name") && item.get(2).equals(ruleValue) ) {
                count++;
            }
        }
        System.gc();
        return count;
    }
}

 */
