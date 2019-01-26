//package hackerrank;
//
//public class X {
//
//    public static String isPossible(int a, int b, int c, int d) {
//        // Write your code here
//        State expected = new State(c, d);
//        return search(new State(a, b), expected, false, false).equals(expected) ? "Yes" : "No";
//    }
//
//    private static State search(State init, State expected, boolean done1, boolean done2) {
//        if (init.equals(expected) || init.a > expected.a || init.b > expected.b || (done1 && done2))
//            return init;
//
//        if (!done1)
//            return search(init.next1(), expected, true, done2);
//        if (!done2)
//            return search(init.next2(), expected, done1, true);
//
//        return init;
//    }
//
//    static class State {
//        public int a, b;
//
//        public State(int a, int b) {
//            this.a = a;
//            this.b = b;
//        }
//
//        public State next1() {
//            return new State(a + b, b);
//        }
//
//        public State next2() {
//            return new State(a, a + b);
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o)
//                return true;
//            if (o == null || getClass() != o.getClass())
//                return false;
//            State state = (State) o;
//            return a == state.a && b == state.b;
//        }
//
//    }
//}
