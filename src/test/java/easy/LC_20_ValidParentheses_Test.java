package easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LC_20_ValidParentheses_Test {

    private LC_20_ValidParentheses lc_20_validParentheses;

    @Before
    public void init() {
        lc_20_validParentheses  = new LC_20_ValidParentheses();
    }

    @Test
    public void testParenthesisCorrect() {
        String str = "()(){()}";

        Assert.assertEquals(lc_20_validParentheses.isValid2(str), true);
    }

    @Test
    public void testParenthesisFalse() {
        String str = "()(){()}}";

        Assert.assertEquals(lc_20_validParentheses.isValid2(str), false);
    }

    @Test
    public void testParenthesisInvalidCharacter() {
        String str = "()(){()}=";

        Assert.assertEquals(lc_20_validParentheses.isValid2(str), false);
    }
}
