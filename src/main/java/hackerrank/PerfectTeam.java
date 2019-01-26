package hackerrank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PerfectTeam {


    @Test
    public void c1() {
        assertEquals(1, differentTeams("pcmbz"));
        assertEquals(0, differentTeams("pcmpp"));
        assertEquals(2, differentTeams("pcmpcmbbbzz"));
        assertEquals(2, differentTeams("pcmbzpcmbz"));
    }


    /**
     * each team 5 students
     * each different skill
     * student in only 1 team
     *
     * pcmpcmbbbzz
     * pp
     * cc
     * mm
     * bbb
     * zz
     *
     * @param skills
     * @return
     */
    public int differentTeams(String skills) {
        int p = countSkills('p', skills);
        int c = countSkills('c', skills);
        int m = countSkills('m', skills);
        int b = countSkills('b', skills);
        int z = countSkills('z', skills);

        List<Integer> counts = new ArrayList<>();
        counts.add(p);
        counts.add(c);
        counts.add(m);
        counts.add(b);
        counts.add(z);

        return counts.stream().sorted().findFirst().get();
    }

    public int countSkills(char skill, String all) {
        int count=0;
        for(int i=0; i<all.length(); i++) {
            if(all.charAt(i) == skill) count++;
        }

        return count;
    }
}


