package password;

public class PasswordChecker {

    public static String check(String input) {
        if (input == null) {
            throw new RuntimeException("입력값이 NULL 입니다.");
        }
        int count = passwordValidCount(input);
        return getPasswordResult(count);
    }

    private static String getPasswordResult(int count) {
        if (count ==1 || count ==0) {
            return "약함";
        }
        if (count ==2) {
            return "보통";
        }
        return "강함";
    }

    private static int passwordValidCount(String input) {
        int count = 0;
        if (containsNumber(input)) {
            count++;
        }
        if (input.length() >= 8) {
            count++;
        }
        if (containsUpperCase(input)) {
            count++;
        }
        return count;
    }

    private static boolean containsNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (isNumber(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumber(char input) {
        return '0' <= input && input <= '9';
    }

    private static boolean containsUpperCase(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (isUpperCase(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean isUpperCase(char input) {
        return 'A' <= input && input <= 'Z';
    }
}
