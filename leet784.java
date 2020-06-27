/*Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

        Examples:
        Input: S = "a1b2"
        Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

        Input: S = "3z4"
        Output: ["3z4", "3Z4"]

        Input: S = "12345"
        Output: ["12345"]
        Note:

        S will be a string with length between 1 and 12.
        S will consist only of letters or digits.*/

//REFER TO https://www.youtube.com/watch?v=x2emlQREyWQ IF ANY DOUBTS. This is a question on backtracking.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class leet784 {
    public static List<String> letterCasePermutation(String S) {
        List<String> result=new ArrayList<>();
        findAllPermutations(result,S,0);

        return result;// this works because an arraylist is passed by reference, apparently. so any changes in findAllPermutations(result,S,0); will reflect in result too.
    }
    public static void findAllPermutations(List<String> res, String str, int index){
        res.add(str);
        for(int i=index;i<str.length();i++)//the loop helps us get back to the original string in case a digit is encountered of if we reach the end of the character array being passed in the parameter.
        {
            char[] strArray=str.toCharArray();
            if(Character.isLetter(str.charAt(i)))
            {
                if(Character.isUpperCase(str.charAt(i)))
                {
                    strArray[i]=Character.toLowerCase(str.charAt(i));
                    findAllPermutations(res,String.valueOf(strArray),i+1);// passing the next index. the next index will now be toggled
                }
                else
                {
                    strArray[i]=Character.toUpperCase(str.charAt(i));
                    findAllPermutations(res,String.valueOf(strArray),i+1);
                }
            }

        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        System.out.println(letterCasePermutation(s));
    }
}
