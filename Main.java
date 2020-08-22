public class Main {



    // MAIN FUNCTION
    public static void main(String[] args) {

        // THE SOLUTION TO 2 GIVEN JAVA PROBLEMS.

        // TODO: THE FUNCTION DEFINITIONS ARE GIVEN, PLEASE USE IT AS YOU WOULD LIKE TO TEST AND EXECUTE

        // TODO: UNCOMMENT THIS FOR TASK1
        //findLongestSubstringPalindrom("asdf");
        // TODO: UNCOMMENT THIS FOR TASK2
        //BinaryReverse("47");
    }

    static void findLongestSubstringPalindrom(String str1) {
        int n = str1.length();
        boolean table[][] = new boolean[n][n];
        int mLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;
        int strt = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str1.charAt(i) == str1.charAt(i + 1)) {
                table[i][i + 1] = true;
                strt = i;
                mLength = 2;
            }
        }
        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                if (table[i + 1][j - 1] && str1.charAt(i) == str1.charAt(j)) {
                    table[i][j] = true;

                    if (k > mLength) {
                        strt = i;
                        mLength = k;
                    }
                }
            }
        }
        //System.out.print("The longest palindrome substring in the given string is; ");
        System.out.println("Longest Palindrome: "+str1.substring(strt, strt + mLength));
    }

    // TASK 2 TO REVERSE A BINARY REPRESENTATION OF A DECIMAL STRING ACCORDING TO A SPECIFIC CRITERIA
    static void BinaryReverse(String str){
        int value = Integer.parseInt(str);
        // DECIMAL TO BINARY CONVERSION
        String binaryRepresentation = Integer.toBinaryString(value);
        // FINDING THE NUMBER OF ZEROS FOR PADDING
        int paddingLength = 8-binaryRepresentation.length();
        // PADDING NECESSARY ZEROS
        for(int i = 0; i<paddingLength; i++){
            binaryRepresentation = "0"+binaryRepresentation;
        }
        System.out.println("BINARY: "+binaryRepresentation);
        // REVERSING THE BINARY STRING AS ASKED
        binaryRepresentation = new StringBuilder(binaryRepresentation).reverse().toString();
        System.out.println("REVERSED BINARY: "+binaryRepresentation);
        // CONVERTING FROM BINARY BACK TO DECIMAL
        int answer = Integer.parseInt(binaryRepresentation, 2);
        System.out.println("ANSWER: "+answer);
    }
}
