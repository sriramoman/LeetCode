package Session1;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesisDriver {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (char bkt : s.toCharArray()) {
            if (bkt == '(' || bkt == '{' || bkt == '[')
                stack.push(new Character(bkt));
            else if (map.containsKey(bkt) && !stack.isEmpty() && stack.peek().compareTo(map.get(bkt)) == 0)
                stack.pop();
            else
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //code
        System.out.println(isValid("["));
    }
}
