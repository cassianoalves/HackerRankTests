package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class OddNumbers {

    int[][] cases = {
            {2,5},
            {}
    };


    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> result = new ArrayList<>();
        for(int i=l; i<=r; i++) {
            if(i%2 != 0) result.add(i);
        }
        return result;
    }

}

class A {
    public int x() {
        return 0;
    }
}

abstract class Y extends A {

}

abstract class X extends A {

}


class YY extends Y {

}

interface lala {
    void a();
}
abstract class P implements lala {}

