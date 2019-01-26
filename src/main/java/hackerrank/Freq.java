package hackerrank;

import org.junit.Test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class Freq {

    @Test
    public void case1() {
        List<Integer> result = frequency("1226#24#");

        assertEquals(Arrays.asList(1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1), result);
    }

    @Test
    public void case2() {
        List<Integer> result = frequency("1(10)226#24#(3)");

        assertEquals(Arrays.asList(10, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 1), result);
    }


    private static final Pattern PATTERN = Pattern.compile("([1-9][0-9]?)#?(\\(([0-9]+)\\))?");

    private static List<Integer> frequency(String s) {
        List<Integer> result = initArray();

        Queue<Character> q = new LinkedList<>();
        for (char c : s.toCharArray()) {
            q.add(c);
        }

        String e;
        while ((e = peekNext(q)) != null) {
            System.out.println(e);
            Matcher matcher = PATTERN.matcher(e);
            if(!matcher.matches()) break;

            int i = getCharIndex(matcher) - 1;
            int r = getCharRepetitions(matcher);

            result.set(i, result.get(i) + r);
        }

        return result;
    }

    private static int getCharRepetitions(Matcher matcher) {
        String rep = matcher.group(3);
        if(rep == null) return 1;
        return Integer.parseInt(rep);
    }

    private static int getCharIndex(Matcher matcher) {
        return Integer.parseInt(matcher.group(1));
    }

    private static String peekNext(Queue<Character> q) {
        StringBuilder result = new StringBuilder("");

        if(q.isEmpty() || !q.peek().toString().matches("[1-9]")) return null;

        result.append(q.poll());

        if(q.isEmpty()) return result.toString();

        Character ca[] = new Character[q.size()];
        q.toArray(ca);
        if(ca.length > 1 && ca[1] == '#') {
            result.append(q.poll());
            result.append(q.poll());
        }

        if(!q.isEmpty() && q.peek() == '(') {
            Character c;
            while(!q.isEmpty()) {
                c = q.poll();
                result.append(c);
                if(c == ')') break;
            }
        }

        return result.toString();
    }

    private static List<Integer> initArray() {
        List<Integer> a = new ArrayList<>(26);
        for(int i=0; i<26; i++) {
            a.add(0);
        }
        return a;
    }
}
