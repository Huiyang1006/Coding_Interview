public class Is_Unique {

    public static void main(String[] args) {
        String sentence = "abcdefga";
        Unique tester = new Unique();
        System.out.println(sentence + ": " + tester.IsUniqueChar(sentence));
    }
}

class Unique {
    /*A brute-force solution*/
    public boolean IsUniqueChar(String str) {
        /*Assume the string is an ASCII string*/
        if (str.length() > 256) return false;
        /*Compare each character with the rest characters in the string*/
        for (int i = 0; i<str.length()-1; i++) {
            for (int j = i+1; j<str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) return false;
            }
        }

        return true;
    }
    // Time Complexity O(n^2)
    // Space Complexity O(1)
    // The Time Complexity can be reduced to O(n log n) by sorting with a heap.

    /*A smart solution, use a boolean array to check if unique*/
    public boolean IsUniqueChar1(String str) {
        /*Assume the string is an ASCII string*/
        if (str.length() > 256) return false;
        /*Construct a boolean array to map characters to boolean number*/
        boolean[] char_set = new boolean[128];
        for (int i = 0; i<str.length(); i++) {
            int val = str.charAt(i);

            if (char_set[val]) return false;
            else char_set[val] = true;
        }

        return true;
    }
    // Time Compexity O(n) or O(1)
    // Space Compexity O(c)

    /*A special solution, use binary calculation to check if unique*/
    public boolean IsUniqueChar2(String str) {
        /*Assume the string only uses the lowercase letters a through z*/
        if (str.length() > 26) return false;

        int checker = 0;
        for (int i = 0; i<str.length(); i++) {
            int val = str.charAt(i) - 'a';

            if ((checker & (1<<val)) > 0) return false;
            checker |= (1 << val);
        }

        return true;
    }
}