package password;

public class PasswordChecker {

    private static final int PASSWORD_MIN_LIMIT = 8;

    private PasswordChecker() {
    }

    public static PasswordSecurityGrade check(String password) {
        if (password==null) {
            throw new NullPointerException(BusinessExceptionMessage.NULL_INPUT);
        }
        int count = countRuleValidation(password);
        return getPasswordSecurityGradeBy(count);
    }

    private static PasswordSecurityGrade getPasswordSecurityGradeBy(int count) {
        if (count == 2) {
            return PasswordSecurityGrade.NORMAL;
        }
        if (count == 3) {
            return PasswordSecurityGrade.STRONG;
        }
        return PasswordSecurityGrade.WEAK;
    }

    private static int countRuleValidation(String password) {
        int count = 0;
        if (password.length() >= PASSWORD_MIN_LIMIT) {
            count++;
        }
        if (containsNumber(password)) {
            count++;
        }
        if (containsUpperCase(password)) {
            count++;
        }
        return count;
    }

    private static boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z]+.*");
    }

    private static boolean containsNumber(String password) {
        return password.matches(".*[0-9]+.*");
    }
}
