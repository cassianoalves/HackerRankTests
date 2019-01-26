package hackerrank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IsPossible2 {

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

    static class State {
        int a, b;

        State(int a, int b) {
            this.a=a;
            this.b=b;
        }

        State next1() {
            return new State(a+b, b);
        }
        State next2() {
            return new State(a, a+b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return a == state.a &&
                    b == state.b;
        }

    }

    private static String isPossible(int a, int b, int c, int d) {
        State expected = new State(c,d);
        return search(new State(a,b), expected).equals(expected) ? "Yes" : "No";
    }


    private static State search(State init, State expected) {
        if(init.equals(expected) || init.a > expected.a || init.b > expected.b) return init;

        State s1 = search(init.next1(), expected);
        if(s1.equals(expected)) return s1;

        return search(init.next2(), expected);
    }


}