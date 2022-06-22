package passwordChecker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PasswordTest {

    @Test
    @DisplayName("0개를 충족하는 경우 비밀번호 약함")
    void test1() {
        String password = "aaaa";
        String result = PasswordChecker.check(password);
        assertThat(result).isEqualTo("약함");
    }

    @Test
    @DisplayName("1개를 충족하는 경우 비밀번호 약함")
    void test2() {

        String password1 = "aaaaaaaa";
        String password2 = "aaa0";
        String password3 = "Aaaa";

        String result1 = PasswordChecker.check(password1);
        String result2 = PasswordChecker.check(password2);
        String result3 = PasswordChecker.check(password3);

        assertThat(result1).isEqualTo("약함");
        assertThat(result2).isEqualTo("약함");
        assertThat(result3).isEqualTo("약함");
    }

    @Test
    @DisplayName("2개를 충족하는 경우 비밀번호 중간")
    void test3() {
        String password = "aaaa";
        String result = PasswordChecker.check(password);
        assertThat(result).isEqualTo("중간");
    }

    @Test
    @DisplayName("3개를 충족하는 경우 비밀번호 강함")
    void test4() {
        String password = "aaaa";
        String result = PasswordChecker.check(password);
        assertThat(result).isEqualTo("강함");
    }
}
