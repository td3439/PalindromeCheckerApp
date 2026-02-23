public class PalindromeCheckerApp {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("   Welcome to the Palindrome Checker App  ");
        System.out.println("==========================================");

        String word = "madam";
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println("The word \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a Palindrome.");
        }

        System.out.println("------------------------------------------");
        System.out.println("Program executed successfully.");
    }
}