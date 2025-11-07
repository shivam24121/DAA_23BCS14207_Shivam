import java.util.Scanner;

public class Main {
    static final int BASE = 256;

    public static void searchPattern(String text, String pattern, int prime) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int patternHash = 0;
        int windowHash = 0;
        int power = 1;

        for (int i = 0; i < patternLength - 1; i++) {
            power = (power * BASE) % prime;
        }

        for (int i = 0; i < patternLength; i++) {
            patternHash = (BASE * patternHash + pattern.charAt(i)) % prime;
            windowHash = (BASE * windowHash + text.charAt(i)) % prime;
        }

        for (int i = 0; i <= textLength - patternLength; i++) {
            if (patternHash == windowHash) {
                boolean match = true;
                for (int j = 0; j < patternLength; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            if (i < textLength - patternLength) {
                windowHash = (BASE * (windowHash - text.charAt(i) * power) + text.charAt(i + patternLength)) % prime;
                if (windowHash < 0) {
                    windowHash += prime;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter pattern: ");
        String pattern = sc.nextLine();

        int prime = 101;

        searchPattern(text, pattern, prime);

        sc.close();
    }
}
