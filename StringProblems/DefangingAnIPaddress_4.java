/*

Given a valid (IPv4) IP address, return a defanged version of that IP address.
A defanged IP address replaces every period "." with "[.]".

Example 1:

Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Example 2:

Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"

Constraints:

The given address is a valid IPv4 address.

 */

package StringProblems;

public class DefangingAnIPaddress_4 {

    public static void main(String[] args){
        String str = "255.100.50.0";
        System.out.println(defangIPaddr(str));
    }

    public static String defangIPaddr(String address) {
        int i=0;
        StringBuilder string = new StringBuilder();
        while(i<address.length()){
            if(address.charAt(i)=='.'){
                string.append('[');
                string.append('.');
                string.append(']');
            }
            else{
                string.append(address.charAt(i));

            }
            i++;
        }
        return string.toString();
    }
}


/*

class Solution {
    public String defangIPaddr(String address) {

        String [] arr=new String[address.length()];
        for(int i=0;i<address.length();i++){

            if( address.charAt(i) == '.'){
                arr[i]="[.]";
            }
            else{
                arr[i] = Character.toString(address.charAt(i));
            }
        }
        String result="";
        for(int i=0; i<arr.length;i++){
            result+=arr[i];
        }
        return result;
    }
}

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)=='.'){
                sb.append("[.]");
            }else{
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }
}

 */
