import java.util.Arrays;

public class Palindrome_Permulation {

    public static void main(String[] args) {

        Sol1 solution1 = new Sol1();
        Sol2 solution2 = new Sol2();

        String str = "Ratzs live on no evil starz";
        String str2 = str.toLowerCase();

        System.out.println("Solution 1: " + str + ": " + solution1.Is_Palindrome(str2));
        System.out.println("Solution 2: " + str + ": " + solution2.Is_Palindrome(str2));

    }
}

/*Utility*/
class utility {
        public static int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z) {
			return val - a;
		}
		return -1;
    }

    public static int[] BuildHashTable(String str) {
        char[] Astr = str.toCharArray();
        int[] letters = new int[26];

         for (char c : Astr) {
            int val = getCharNumber(c);
            if (val!=-1) letters[val]++;
        }

        return letters;
    }
}

class Sol1 {
    /*Solution 1, use a hash table*/
    public boolean Is_Palindrome(String str) {

        int[] letters = utility.BuildHashTable(str);

        System.out.println(Arrays.toString(letters));
        return CheckOdd(letters);
    }
    // Time complexity O(n)
    // Space complexity O(1)

    public boolean CheckOdd(int[] letters) {
        boolean flag = false;
        for (int count : letters) {
            if (count % 2 == 1) {
                if (flag) return false;
                flag = true;
            }
        }
        return true;
    }
}

class Sol2 {
    public boolean Is_Palindrome(String str) {

        int Odd = 0;
        int[] letters = new int[26];

        for (char c : str.toCharArray()) {
            int val = common.getCharNumber(c);
            if (val!=-1) {
                letters[val]++;
                if (letters[val]%2==1) Odd++;
                else Odd--;
            }
        }

        return Odd<=1;
    }
}