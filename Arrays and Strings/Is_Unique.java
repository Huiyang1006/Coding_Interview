public class Is_Unique {
    public static boolean IsUniqueStr(String str) {
        if (str.length() > 256) return false;
        
        boolean[] char_set = new boolean[128];
        for (int i = 0; i<str.length(); i++) {
            int test = str.charAt(i);

            if (char_set[i]) return false;
            else char_set[i] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        String sentence = "abcdefg";
        System.out.println(sentence + ": " + IsUniqueStr(sentence));
    }
}