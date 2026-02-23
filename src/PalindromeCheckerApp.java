public class PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("Palindrome Checker - Use Case 4");

        String word = "radar";
        char[] characters = word.toCharArray();

        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("Result: \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("Result: \"" + word + "\" is NOT a Palindrome.");
        }

        System.out.println("Program Ended.");
    }
}