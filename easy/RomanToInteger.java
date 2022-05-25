package easy;

import java.util.HashMap;
import java.util.Map;

class RomanToInteger {

    public int romanToInt(String s) {

        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int curr = romanValues.get(s.charAt(i));
            int next = romanValues.get(s.charAt(i + 1));
            result = curr < next ? result - curr : result + curr;
        }
        return result + romanValues.get(s.charAt(s.length() - 1));
    }

    public static void main(String[] args) {
        RomanToInteger r = new RomanToInteger();        
        System.out.println(r.romanToInt("III"));
        System.out.println(r.romanToInt("LVIII"));
        System.out.println(r.romanToInt("MCMXCIV"));
    }
}