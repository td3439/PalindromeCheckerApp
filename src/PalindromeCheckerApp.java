import java.util.*;


public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        // Choose strategy dynamically
        PalindromeStrategy strategy;

        // Change this to switch algorithm
        strategy = new StackStrategy();
        // strategy = new DequeStrategy();

        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.executeCheck(input);

        if (result) {
            System.out.println("The input \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The input \"" + input + "\" is NOT a Palindrome.");
        }
    }
}

/**
 * Strategy Interface
 */
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

/**
 * Stack-Based Implementation
 */
class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String input) {

        if (input == null) return false;

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        Stack<Character> stack = new Stack<>();

        for (char c : normalized.toCharArray()) {
            stack.push(c);
        }

        for (char c : normalized.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

/**
 * Deque-Based Implementation
 */
class DequeStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String input) {

        if (input == null) return false;

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : normalized.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

/**
 * Context Class
 */
class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCheck(String input) {
        return strategy.isPalindrome(input);
    }
}