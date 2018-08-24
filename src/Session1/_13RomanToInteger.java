package Session1;

import java.util.HashMap;

public class _13RomanToInteger {
    public static int romanToInt(String s) {
        int result = 0;
        HashMap<Character, Integer> romanToIntMap = new HashMap<Character, Integer>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);
        int i = 0;
        while (i < s.length() - 1) {
            if (romanToIntMap.get(s.charAt(i + 1)) > romanToIntMap.get(s.charAt(i))) {
                result += romanToIntMap.get(s.charAt(i + 1)) - romanToIntMap.get(s.charAt(i));
                i++;
            } else
                result += romanToIntMap.get(s.charAt(i));
            i++;
        }
        while (i < s.length()) {
            result += romanToIntMap.get(s.charAt(i));
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        //code
        System.out.println(romanToInt("LVIII"));
    }
}
