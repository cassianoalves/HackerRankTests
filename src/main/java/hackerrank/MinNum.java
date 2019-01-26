package hackerrank;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MinNum {

    @Test
    public void c1 () {
        assertEquals(1, minNum(3,5,1));
        assertEquals(2, minNum(3,5,10));
    }

    /* P
     K => A

     K A
     1 2
     6 5*

     5  3 10
     1  11
     6  14
     11 17
     16 20
     21 23
     26 26
     31 29




    * */


    public int minNum(int A, int K, int P) {
        if (K <= A) return -1;

        int i = 0;
        for (int k=1, a=1+P; k <= a ; k+=K, a+=A, i++);

        return i;
    }
}
