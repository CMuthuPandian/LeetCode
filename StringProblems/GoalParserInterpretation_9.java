/*

You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G",
"()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the
string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the
original order.

Given the string command, return the Goal Parser's interpretation of command.

Example 1:

Input: command = "G()(al)"
Output: "Goal"
Explanation: The Goal Parser interprets the command as follows:
G -> G
() -> o
(al) -> al
The final concatenated result is "Goal".

Example 2:

Input: command = "G()()()()(al)"
Output: "Gooooal"

Example 3:

Input: command = "(al)G(al)()()G"
Output: "alGalooG"

Constraints:

1 <= command.length <= 100
command consists of "G", "()", and/or "(al)" in some order.

 */

package StringProblems;

public class GoalParserInterpretation_9 {

    public static void main(String[] args){
        String str = "G()()()()(al)";
        System.out.println(interpret(str));
    }

    public static String interpret(String command) {
        int i=0;
        StringBuilder string = new StringBuilder();
        while(i<command.length()){
            if(command.charAt(i)=='G'){
                string.append('G');
                i++;
            }
            else if(command.charAt(i)=='('){
                if(command.charAt(i+1)=='a'){
                    string.append('a');
                    string.append('l');
                    i=i+4;
                }
                else{
                    string.append('o');
                    i=i+2;
                }
            }
        }
        return string.toString();
    }
}

/*

class Solution {
    public String interpret(String command) {
        command = command.replace("()","o").replace("(al)","al");

        return command;
    }
}

class Solution {
    public String interpret(String command) {
        String s1="";
        for(int i=0;i<command.length();i++)
        {
            if(command.charAt(i)=='G')
            {
                s1+='G';
            }
            else if(command.charAt(i)=='(' && command.charAt(i+1)==')')
            {
                s1+='o';
            }
            else if(command.charAt(i)=='(' && command.charAt(i+1)=='a'&&command.charAt(i+2)=='l' && command.charAt(i+3)==')')
            {
                s1+='a';
                s1+='l';
            }
        }
        return s1;
    }
}

 */