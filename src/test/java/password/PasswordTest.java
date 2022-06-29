package password;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PasswordTest {

    @Test
    void 입력값이_NULL인_경우() {
        String input = null;

        assertThatThrownBy(()->PasswordChecker.check(input))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("입력값이 NULL 입니다.");
    }

    @Test
    void 아무것도_충족하지_않으면_규칙은_약함이다() {
        passwordAssert("asdf",PasswordLevel.WEAK);
    }

    @Test
    void 길이가_8글자_이상() {
        passwordAssert("aaaaaaaa",PasswordLevel.WEAK);
    }

    @Test
    void 숫자0에서_9사이를_포함() {
        passwordAssert("0",PasswordLevel.WEAK);
    }

    @Test
    void 대문자를_포함() {
        passwordAssert("A",PasswordLevel.WEAK);
    }

    @Test
    void 길이가_8글자_이상이고_0에서9사이의_숫자를_포함() {
        passwordAssert("aaaaaaa8",PasswordLevel.NORMAL);
    }

    @Test
    void 길이가_8글자_이상이고_대문자를_포함() {
        passwordAssert("aaaaaaaA",PasswordLevel.NORMAL);
    }

    @Test
    void 숫자0에서9사이_그리고_대문자를_포함() {
        passwordAssert("0A",PasswordLevel.NORMAL);
    }

    @Test
    void 모든_규칙을_준수한다() {
        passwordAssert("0aaaaaaA",PasswordLevel.STRONG);
    }

    private void passwordAssert(String actual, String expect) {
        String result = PasswordChecker.check(actual);
        assertThat(result).isEqualTo(expect);
    }

}
