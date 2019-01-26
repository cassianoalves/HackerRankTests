package hackerrank;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class Braces {

    @Test
    public void Test() {
        String in[] = {
                "}][}}(}][))]",
                "[](){()}",
                "()",
                "({}([][]))[]()",
                "{)[](}]}]}))}(())(",
                "([[)"
        };
        String[] result = braces(in);

        Assert.assertEquals("NO" , result[0]);
        Assert.assertEquals("YES", result[1]);
        Assert.assertEquals("YES", result[2]);
        Assert.assertEquals("YES", result[3]);
        Assert.assertEquals("NO" , result[4]);
        Assert.assertEquals("NO" , result[5]);
    }


    static String[] braces(String[] values) {
        String[] out = new String[values.length];
        java.util.stream.Stream.of(values)
                .map(x -> isBracesBalanced(x))
                .collect(java.util.stream.Collectors.toList()).toArray(out);

        return out;
    }

    private static String isBracesBalanced(String value) {

        Stack<Character> q = new Stack<>();

        for (char c : value.toCharArray()) {
            if(c == '{' || c == '[' || c == '(') q.push(c);
            else {
                if(q.empty()) return "NO";
                char last = q.peek();
                if((last == '{' && c == '}')
                        || (last == '[' && c == ']')
                        || (last == '(' && c == ')')) {
                    q.pop();
                } else {
                    return "NO";
                }
            }
        }

        return q.empty() ? "YES" : "NO";
    }

}
