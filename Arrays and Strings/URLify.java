public class URLify {

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        int length = 13;

        System.out.println("Input:  " + str);
        String str2 = new String(RSpaces(str.toCharArray(), length));
        System.out.println("Output: " + str2);

        String str3 = RSpaces2(str, length);
        System.out.println("Output2: " + str3);
    }

    /*Solution with char[] rather than String*/
    public static char[] RSpaces(char[] str, int length) {
        /*Count the number of all spaces*/
        int count = 0;
        for (int i = length-1; i>=0; i--) {
            if (str[i] == ' ') {
                count++;
            }
        }
        /* Since we know the number of ' ', the total length of the new string can be decided*/
        int index = length+count*2;

        if (length<str.length) str[length] = '\0';

        for (int i = length-1; i>=0; i--) {
            if (str[i] == ' ') {
                str[index-1] = '0';
                str[index-2] = '2';
                str[index-3] = '%';
                index-=3;
            } else {
                str[index-1] = str[i];
                index--;
            }
        }
        // System.out.println("Test: " + str);
        return str;
    }
    
    /*Solution with string.replace, return a new String*/
    public static String RSpaces2(String str, int length) {
        return str.substring(0, length).replace(" ", "%20");
    }


}

// It's often easiest to modify strings by going from the end of the string to the beginning