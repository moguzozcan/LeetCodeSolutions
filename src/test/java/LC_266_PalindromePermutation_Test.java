import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LC_266_PalindromePermutation_Test {

    private LC_266_PalindromePermutation lc_266_palindromePermutation;

    @Before
    public void init() {
        lc_266_palindromePermutation = new LC_266_PalindromePermutation();
    }

    @Test
    public void testPalindromePermutationSuccess() {
        String s = "aab";

        Assert.assertEquals(true, lc_266_palindromePermutation.canPermutePalindrome(s));
    }

    @Test
    public void testPalindromePermutationFail() {
        String s = "code";

        Assert.assertEquals(false, lc_266_palindromePermutation.canPermutePalindrome(s));
    }
}
