public class String_Compression {

    public static void main(String[] args) {
        Sol1 solution1 = new Sol1();
        Sol2 solution2 = new Sol2();
        String str = "aabcccccaaa";
        String str1 = solution1.Compress(str);
        String str2 = solution2.Compress(str);
        System.out.println(str.length() > str1.length() ? str1 : str);
        System.out.println(str.length() > str2.length() ? str2 : str);

    }
}

/*A natural and good solution with StringBuilder*/
/*A StringBuilder double its size when it needs to*/
/*Calculate the needed first could reduce the time*/
class Sol1 {
    public String Compress(String str) {
        StringBuilder sb = new StringBuilder();
        int num = 1;

        for (int i = 1; i<str.length(); i++) {
            char prev = str.charAt(i-1);
            char curr = str.charAt(i);
            if (prev == curr) num++;
            else {
                sb.append(prev);
                sb.append(num);
                num = 1;
            }
        }
        /*Information of the last character*/
        sb.append(str.charAt(str.length()-1));
        sb.append(num);

        return sb.toString();
    }
}
// Time Complexity O(n)
// Space Complexity O(1)

/*An optimal solution. Calculate the total length first*/
class Sol2 {
    public String Compress(String str) {
        int finalLength = CompressionCount(str);
        if (finalLength>=str.length()) return str;

        StringBuilder sb = new StringBuilder();
        int num = 1;

        for (int i = 1; i<str.length(); i++) {
            char prev = str.charAt(i-1);
            char curr = str.charAt(i);
            if (prev == curr) num++;
            else {
                sb.append(prev);
                sb.append(num);
                num = 1;
            }
        }
        /*Information of the last character*/
        sb.append(str.charAt(str.length()-1));
        sb.append(num);

        return sb.toString();

    }

    public int CompressionCount(String str) {
        int finalLength = 0;
        int num = 1;
        for (int i = 1; i<str.length(); i++) {
            char prev = str.charAt(i-1);
            char curr = str.charAt(i);
            if (prev == curr) num++;
            else {
                finalLength += 1 + String.valueOf(num).length();
                num = 1;
            }            
        }
        finalLength += 1 + String.valueOf(num).length();

        return finalLength;
    }
}
// Time Complexity O(n)
// Space Complexity O(1)