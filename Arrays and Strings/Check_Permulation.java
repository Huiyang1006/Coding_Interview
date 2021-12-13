import java.util.Map;
import java.util.HashMap;

public class Check_Permulation {

    public static void main(String[] args) {
        String str1 = "abcded";
        String str2 = "bcddea";

        System.out.println("str2 is a permutation of str1? " + sort_compare(str1, str2));
        System.out.println("str2 is a permutation of str1? " + count_compare(str1, str2));
        System.out.println("str2 is a permutation of str1? " + hash_compare(str1, str2));
    }

    /*A smart algorithm by sorting*/
    public static boolean sort_compare(String str1, String str2) {
        
        /*If two string have different length, then the answer is no*/
        if (str1.length()!=str2.length()) return false;

        return sort(str1).equals(sort(str2));
    }
    // Time Complexity O(n log n)
    // Space Complexity O(n)

    /*Sort the given string*/
    public static String sort(String str) {
        char[] Astr = str.toCharArray();
        java.util.Arrays.sort(Astr);
        return new String(Astr);
    }

    /*A time optimal algorithm by counting different characters' number*/
    public static boolean count_compare(String str1, String str2) {
        if (str1.length()!=str2.length()) return false;

        int[] letters = new int[128];

        for (int i = 0; i<str1.length(); i++) letters[str1.charAt(i)]++;
        for (int i = 0; i<str1.length(); i++) {
            letters[str2.charAt(i)]--;
            if (letters[str2.charAt(i)]<0) return false;
        }
        /* Since there are no negative values, and two string have the same length, there are no positive values either*/
        return true;
    }

    /*A time optimal algorithm with hashmap*/
    public static boolean hash_compare(String str1, String str2) {
        if (str1.length()!=str2.length()) return false;

        char[] Astr1 = str1.toCharArray();
        char[] Astr2 = str2.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : Astr1) {
            if (!map.containsKey(c)) map.put(c, 1);
            else map.put(c, map.get(c)+1);
        }

        for (char c : Astr2) {
            if (!map.containsKey(c)) return false;
            else map.put(c, map.get(c)-1);
        }

        /*The use of Map.Entry is very hard*/
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
             if (entry.getValue() !=0) return false;
        }

        return true;
    }
}