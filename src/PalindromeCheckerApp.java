import java.util.*;

/**
 * UC13 - Performance Comparison of Palindrome Algorithms
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        List<PalindromeStrategy> strategies = Arrays.asList(
                new TwoPointerStrategy(),
                new StackStrategy(),
                new DequeStrategy()
        );

        for (PalindromeStrategy strategy : strategies) {

            long startTime = System.nanoTime();

            boolean result = strategy.isPalindrome(input);

            long endTime = System.nanoTime();

            long duration = endTime - startTime;

            System.out.println("-----------------------------------");
            System.out.println("Algorithm: " + strategy.getClass().getSimpleName());
            System.out.println("Result: " + result);
            System.out.println("Execution Time (nanoseconds): " + duration);
        }
    }
}

/* Strategy Interface */
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

/* Two Pointer Strategy (Fastest Approach) */
class TwoPointerStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String input) {

        if (input == null) return false;

        String normalized = input.replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

/* Stack Strategy */
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

/* Deque Strategy */
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