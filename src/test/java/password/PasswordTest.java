package password;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PasswordTest {

    @Test
    @DisplayName("0개를 충족하는 경우 비밀번호 약함")
    void test1() {
        String password = "aaaa";
        PasswordSecurityGrade result = PasswordChecker.check(password);
        assertThat(result).isEqualTo(PasswordSecurityGrade.WEAK);
    }

    @Test
    @DisplayName("1개를 충족하는 경우 비밀번호 약함")
    void test2() {

        String password1 = "aaaaaaaa";
        String password2 = "aaa0";
        String password3 = "Aaaa";

        PasswordSecurityGrade result1 = PasswordChecker.check(password1);
        PasswordSecurityGrade result2 = PasswordChecker.check(password2);
        PasswordSecurityGrade result3 = PasswordChecker.check(password3);

        assertThat(result1).isEqualTo(PasswordSecurityGrade.WEAK);
        assertThat(result2).isEqualTo(PasswordSecurityGrade.WEAK);
        assertThat(result3).isEqualTo(PasswordSecurityGrade.WEAK);
    }

    @Test
    @DisplayName("2개를 충족하는 경우 비밀번호 중간")
    void test3() {
        String password1 = "aaaaaaaa0";
        String password2 = "aaaaaaaaA";
        String password3 = "A9";

        PasswordSecurityGrade result1 = PasswordChecker.check(password1);
        PasswordSecurityGrade result2 = PasswordChecker.check(password2);
        PasswordSecurityGrade result3 = PasswordChecker.check(password3);

        assertThat(result1).isEqualTo(PasswordSecurityGrade.NORMAL);
        assertThat(result2).isEqualTo(PasswordSecurityGrade.NORMAL);
        assertThat(result3).isEqualTo(PasswordSecurityGrade.NORMAL);
    }

    @Test
    @DisplayName("3개를 충족하는 경우 비밀번호 강함")
    void test4() {
        String password = "Aaaaaaa0";
        PasswordSecurityGrade result = PasswordChecker.check(password);
        assertThat(result).isEqualTo(PasswordSecurityGrade.STRONG);
    }

    @Test
    @DisplayName("입력값이 NULL일 경우 예외처리")
    void test5() {
        assertThatThrownBy(() -> PasswordChecker.check(null))
            .isInstanceOf(NullPointerException.class)
            .hasMessage(BusinessExceptionMessage.NULL_INPUT);
    }
}
