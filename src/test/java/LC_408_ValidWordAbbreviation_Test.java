import org.junit.Assert;
import org.junit.Test;

public class LC_408_ValidWordAbbreviation_Test {

    private LC_408_ValidWordAbbreviation lc_408_validWordAbbreviation = new LC_408_ValidWordAbbreviation();

    @Test
    public void validWordAbbreviationSuccess() {
        String word = "internationalization";
        String abbr = "i12iz4n";

        Assert.assertEquals(true, lc_408_validWordAbbreviation.validWordAbbreviation(word, abbr));
    }

    @Test
    public void validWordAbbreviationFail() {
        String word = "apple";
        String abbr = "a2e";

        Assert.assertEquals(false, lc_408_validWordAbbreviation.validWordAbbreviation(word, abbr));
    }
}
