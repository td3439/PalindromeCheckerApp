public class PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("Palindrome Checker - Use Case 2");

        String word = "madam";
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println("Result: \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("Result: \"" + word + "\" is NOT a Palindrome.");
        }

        System.out.println("Program Ended.");
    }
}