package easy;

import easy.LC_346_MovingAverageFromDataStream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LC_346_MovingAverageFromDataStream_Test {

    private LC_346_MovingAverageFromDataStream lc_346_movingAverageFromDataStream;

    @Before
    public void init() {
        lc_346_movingAverageFromDataStream = new LC_346_MovingAverageFromDataStream(3);
    }

    @Test
    public void testMovingAverage() {
        Assert.assertEquals(1.0, lc_346_movingAverageFromDataStream.next(1), 0.0001);
        Assert.assertEquals(5.5, lc_346_movingAverageFromDataStream.next(10), 0.0001);
        Assert.assertEquals(4.66, lc_346_movingAverageFromDataStream.next(3), 0.1);
        Assert.assertEquals(6.0, lc_346_movingAverageFromDataStream.next(5), 0.0001);
    }
}
