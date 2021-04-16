package practice;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/***
 * String findWinner(List<String> votes)
 * Arrays.asList("A", "B", "A", "C", "D", "B", "A");
 *
 * ABC : A + B + C
 * BCA : B + C +  A
 * CBA :
 *
 * O(n) java <= 7
 * hashCode() {
 *     return 1;
 * }
 *
 * java >= 1.8
 * O(log(n))
 *
 * A-> 3
 * B-> 2
 * C-> 1
 * D-> 1
 * *************/


/****
 *
 * [
 *   [
 *     "Candidate 1",  3
 *     "Candidate 2",  2
 *     "Candidate 3",  1
 *   ],
 *   [
 *     Candidate 3,   3
 *     Candidate 2,   2
 *     Candidate 1,   1
 *   ],
 * ]
 *
 *
 *
 * *****/
//        Map<String, Integer[]> votesMap = new HashMap<>();
/***
 * "Candidate 1" -> { 3,  1 }
 * "Candidate 2" -> { 2, 2  }
 * "Candidate 3" -> { 1, 3  }
 *
 *
 *
 *
 *
 *
 * ***/


public class Test {

    static String findWinner(List<List<String>> votes) {
        if(votes == null || votes.isEmpty()) {
            return null;
        }
        int n = votes.get(0).size();
        int max = 0;
        String winner = "";
        Map<String, Integer> votesMap = new HashMap<>();
        for (List<String> vote : votes) {
            for (int i = 0; i < n; i++) {
                if(!votesMap.containsKey(vote.get(i))) {
                    votesMap.put(vote.get(i), 0);
                }
                int freq = n - i;
                votesMap.put(vote.get(i), votesMap.get(vote.get(i)) + freq);
                if(votesMap.get(vote.get(i)) >= max) {
                    max = votesMap.get(vote.get(i));
                    winner = vote.get(i);
                }
            }
        }
        return winner;
    }


    static String findWinner1(List<String> votes) {
        if(votes == null || votes.isEmpty()) {
            return null;
        }

        Map<String, Integer> votesMap = new HashMap<>();
        String winner = votes.get(0);
        int max = 1;
        for (String vote : votes) {
            votesMap.put(vote, votesMap.getOrDefault(vote, 0) + 1);
            if(votesMap.get(vote) >= max) {
                max = votesMap.get(vote);
                winner = vote;
            }
        }
        return winner;
    }

    @org.junit.Test
    public void verifyWinners1(){
        assertEquals(null,findWinner1(Arrays.asList()));
        assertEquals("A",findWinner1(Arrays.asList("A", "B", "A", "C", "D", "B", "A")));
        assertEquals("A",findWinner1(Arrays.asList("B", "A", "B", "A", "C", "B", "A")));
        assertNotSame("C",findWinner1(Arrays.asList("B", "A", "B", "A", "C", "B", "A")));
    }

    @org.junit.Test
    public void verifyWinners(){
        assertEquals(null,findWinner(Arrays.asList()));

        List<List<String>> ips =  Arrays.asList(
                Arrays.asList("Candidate 1", "Candidate 2", "Candidate 3"),
                Arrays.asList("Candidate 3", "Candidate 2", "Candidate 1")
        );

        assertEquals("Candidate 1",findWinner(ips));


    }

/****
 *
 *  * [
 *  *   [
 *  *     "Candidate 1",  3
 *  *     "Candidate 2",  2
 *  *     "Candidate 3",  1
 *  *   ],
 *  *   [
 *  *     Candidate 3,   3
 *  *     Candidate 2,   2
 *  *     Candidate 1,   1
 *  *   ],
 *  * ]
 *
 *
 * **/



    public static void main(String[] args) {
        System.out.println(new Test().findWinner1(Arrays.asList("A", "B", "A", "C", "D", "B", "A")));
        System.out.println(new Test().findWinner1(Arrays.asList("B", "A", "B", "A", "C", "B", "A")));
   }
}
