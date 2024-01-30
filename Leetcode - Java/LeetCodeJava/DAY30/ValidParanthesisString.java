package DAY30;

import java.util.Stack;

public class ValidParanthesisString {
	public static boolean checkValidString(String s) {
        Stack<Integer> leftID = new Stack<>();
        Stack<Integer> starID = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                leftID.push(i);
            else if (ch == '*')
                starID.push(i);
            else {
                if (leftID.isEmpty() && starID.isEmpty())   return false;
                if (!leftID.isEmpty())
                    leftID.pop();
                else 
                    starID.pop();
            }
        }
        while (!leftID.isEmpty() && !starID.isEmpty()) {
            if (leftID.pop() > starID.pop()) 
                return false;
        }
        return leftID.isEmpty();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()";
		System.out.println(checkValidString(s));
	}

}
