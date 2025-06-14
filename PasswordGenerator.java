
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    static final String LETTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String NUMBERS = "0123456789";
    static final String SYMBOLS = "!@#$%^&*()_+-=[]{}|;:',.<>/?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();
  
        System.out.print("Include letters? (true/false): ");
        boolean includeLetters = scanner.nextBoolean();

        System.out.print("Include numbers? (true/false): ");
        boolean includeNumbers = scanner.nextBoolean();

        System.out.print("Include symbols? (true/false): ");
        boolean includeSymbols = scanner.nextBoolean();


        String password = generatePassword(length, includeLetters, includeNumbers, includeSymbols);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, boolean useLetters, boolean useNumbers, boolean useSymbols) {
        StringBuilder characterPool = new StringBuilder();

        if (useLetters) {
            characterPool.append(LETTERS);
        }
        if (useNumbers) {
            characterPool.append(NUMBERS);
        }
        if (useSymbols) {
            characterPool.append(SYMBOLS);
        }

        if (characterPool.length() == 0) {
            return "No character types selected";
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
}
