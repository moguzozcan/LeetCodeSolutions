import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LC_326_PowerOfThree_Test {

    private LC_326_PowerOfThree lc_326_powerOfThree;

    @Before
    public void init() {
        lc_326_powerOfThree = new LC_326_PowerOfThree();
    }

    @Test
    public void isPowerOfThreeSuccess() {
        //Arrange
        int nine = 9;
        int eight = 8;

        //Act
        boolean nineRes = lc_326_powerOfThree.isPowerOfThree(nine);
        boolean eightRes = lc_326_powerOfThree.isPowerOfThree(eight);

        //Assert
        Assert.assertEquals(true, nineRes);
        Assert.assertEquals(false, eightRes);
    }
}
