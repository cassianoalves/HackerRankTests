package hackerrank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IsPossible1Err {

    @Test public void case1() { assertEquals("Yes", isPossible(1,4,5,9)); }
    @Test public void case2() { assertEquals("No", isPossible(1,4,5,8)); }
    @Test public void case3() { assertEquals("No", isPossible(1,4,5,10)); }
    @Test public void case4() { assertEquals("No", isPossible(1,4,4,9)); }
    @Test public void case5() { assertEquals("No", isPossible(1,4,6,9)); }
    @Test public void case6() { assertEquals("Yes", isPossible(1,1,2,3)); }
    @Test public void case7() { assertEquals("Yes", isPossible(1,1,3,2)); }

    @Test public void case8() { assertEquals("No", isPossible(1,2,3,6)); }
    @Test public void case9() { assertEquals("Yes", isPossible(0,0,0,0)); }
    @Test public void case10() { assertEquals("No", isPossible(5,9,1,4)); }
    @Test public void case11() { assertEquals("Yes", isPossible(5,9,5,9)); }


    public static String isPossible(int a, int b, int c, int d) {
        // Write your code here
        if(a == c && b == d) return "Yes";
        if(isPossibleRec12(a,b,c,d,0)) return "Yes";
        if(isPossibleRec21(a,b,c,d,0)) return "Yes";
        return "No";
    }

    private static boolean isPossibleRec12(int a, int b, int c, int d, int i) {
        if(i == 0) {
            if (a + b == c && b == d) return true;
            else return isPossibleRec12(a + b, b, c, d, 1);
        } else if (i == 1) {
            return a == c && a + b == d;
        }
        return false;
    }

    private static boolean isPossibleRec21(int a, int b, int c, int d, int i) {
        if(i == 0) {
            if (a == c && a + b == d) return true;
            else return isPossibleRec12(a, a+b, c, d, 1);
        } else if (i == 1) {
            return a + b == c && b == d;
        }
        return false;
    }

}
