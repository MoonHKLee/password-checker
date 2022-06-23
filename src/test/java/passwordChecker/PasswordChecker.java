package passwordChecker;

public class PasswordChecker {

    public static PasswordSecurityGrade check(String password) {
        int count = 0;
        if (password.length() >= 8) {
            count++;
        }
        if (containsNumber(password)) {
            count++;
        }
        if (containsUpperCase(password)) {
            count++;
        }
        if (count == 2) {
            return PasswordSecurityGrade.NORMAL;
        }
        if (count == 3) {
            return PasswordSecurityGrade.STRONG;
        }
        return PasswordSecurityGrade.WEAK;
    }

    private static boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z]+.*");
    }

    private static boolean containsNumber(String password) {
        return password.matches(".*[0-9]+.*");
    }
}
