package easy;

import org.junit.Test;

public class LC_604_DesignCompressedStringIterator_Test {

    private LC_604_DesignCompressedStringIterator lc_604_designCompressedStringIterator = new LC_604_DesignCompressedStringIterator();

    @Test
    public void testCompressedStringSuccess() {
        String compressed = "L1e2t1C1o1d1e1";

        lc_604_designCompressedStringIterator.StringIterator(compressed);

        System.out.println(lc_604_designCompressedStringIterator.hasNext());
        System.out.println(lc_604_designCompressedStringIterator.next());
        System.out.println(lc_604_designCompressedStringIterator.hasNext());
        System.out.println(lc_604_designCompressedStringIterator.next());
        System.out.println(lc_604_designCompressedStringIterator.hasNext());
        System.out.println(lc_604_designCompressedStringIterator.next());
        System.out.println(lc_604_designCompressedStringIterator.hasNext());
        System.out.println(lc_604_designCompressedStringIterator.next());
        System.out.println(lc_604_designCompressedStringIterator.hasNext());
        System.out.println(lc_604_designCompressedStringIterator.next());
        System.out.println(lc_604_designCompressedStringIterator.hasNext());
        System.out.println(lc_604_designCompressedStringIterator.next());
        System.out.println(lc_604_designCompressedStringIterator.hasNext());
        System.out.println(lc_604_designCompressedStringIterator.next());
        System.out.println(lc_604_designCompressedStringIterator.hasNext());
        System.out.println(lc_604_designCompressedStringIterator.next());
        System.out.println(lc_604_designCompressedStringIterator.hasNext());
        System.out.println(lc_604_designCompressedStringIterator.next());
        System.out.println(lc_604_designCompressedStringIterator.hasNext());
        System.out.println(lc_604_designCompressedStringIterator.next());
    }

}
