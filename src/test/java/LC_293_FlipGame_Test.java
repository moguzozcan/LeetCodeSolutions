import org.junit.Before;
import org.junit.Test;

public class LC_293_FlipGame_Test {

    private LC_293_FlipGame lc_293_flipGame;

    @Before
    public void init() {
        lc_293_flipGame = new LC_293_FlipGame();
    }

    @Test
    public void test() {
        String[] testcase = {"+","-","++","--","+++","++++","+--+","-+-+","+-+-"};
        for(int i=0;i<testcase.length;i++){
            System.out.println(lc_293_flipGame.generatePossibleNextMoves(testcase[i]));
        }
    }
}
