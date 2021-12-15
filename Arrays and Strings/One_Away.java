public class One_Away {

    public static void main(String[] args) {

        String[][] tests = {{"a", "b", "true"}, 
				{"", "d", "true"},
				{"d", "de", "true"},
				{"pale", "pse", "false"},
				{"acdsfdsfadsf", "acdsgdsfadsf", "true"},
				{"acdsfdsfadsf", "acdsfdfadsf", "true"},
				{"acdsfdsfadsf", "acdsfdsfads", "true"},
				{"acdsfdsfadsf", "cdsfdsfadsf", "true"},
				{"adfdsfadsf", "acdfdsfdsf", "false"},
				{"adfdsfadsf", "bdfdsfadsg", "false"},
				{"adfdsfadsf", "affdsfads", "false"},
				{"pale", "pkle", "true"},
				{"pkle", "pable", "false"}};
        for (int i = 0; i < tests.length; i++) {
			String[] test = tests[i];
			String a = test[0];
			String b = test[1];
			boolean expected = test[2].equals("true");
			
			test(a, b, expected);
			test(b, a, expected);
        }
    }

    public static void test(String a, String b, boolean expected) {
		boolean resultA = Sol2.OneEditAway(a, b);
		boolean resultB = Sol2.OneEditAway(a, b);		
		
		if (resultA == expected && resultB == expected) {
			System.out.println(a + ", " + b + ", " + expected + ": success");
		} else {
			System.out.println(a + ", " + b + ", " + expected + ": error");
		}
	}

    
}

class Sol1 {
    public static boolean OneEditAway(String str1, String str2) {

        if (Math.abs(str1.length() - str2.length()) > 1) return false;

        if (str1.length() == str2.length()) {
            return OneEditReplace(str1, str2);
        }

        /* Get shorter and longer string.*/
        String strS = str1.length()< str2.length() ? str1 : str2;
        String strL = str1.length()< str2.length() ? str2 : str1;

        return OneEditInsert(strS, strL);
    }
    // Time Complexity O(n)
    // Space Complexity O(1)
    // Clearer and easier to follow

    public static boolean OneEditReplace(String str1, String str2) {
        boolean flag = false;

        for(int i = 0; i<str1.length(); i++) {
            if(str1.charAt(i)!=str2.charAt(i)) {
                if(flag) return false;   
                flag = true;
            }
        }

        return true;
    }

    public static boolean OneEditInsert(String str1, String str2) {
        int i = 0;
        int j = 0;

        while(i<str1.length() && j<str2.length()) {
            if(str1.charAt(i)!=str2.charAt(j)) {
                if(i!=j) return false;
                j++;
            } else {
                i++;
                j++;
            }
        }

        return true;
    }
}

class Sol2 {
    public static boolean OneEditAway(String str1, String str2) {

        if (Math.abs(str1.length() - str2.length()) > 1) return false;

        /* Get shorter and longer string.*/
        String strS = str1.length()< str2.length() ? str1 : str2;
        String strL = str1.length()< str2.length() ? str2 : str1;

        int i = 0; 
        int j = 0;
        boolean flag = false;

        while(i<strS.length() && j<strL.length()) {
            if(strS.charAt(i)!=strL.charAt(j)) {
                if(flag) return false;
                flag = true;

                if (strS.length() == strL.length()) { i++; }
            } else { i++; }

            j++;
        }

        return true;
    }
    // Time Complexity O(n)
    // Space Complexity O(1)
    // More compact and no duplicate code
}

// No need to pick a side, should discuss the tradeoff with interviewer