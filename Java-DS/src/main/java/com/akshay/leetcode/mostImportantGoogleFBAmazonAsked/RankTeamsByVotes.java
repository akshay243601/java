package com.akshay.leetcode.mostImportantGoogleFBAmazonAsked;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * 1366. Rank Teams by Votes
 * https://leetcode.com/problems/rank-teams-by-votes/
 *
 * In a special ranking system, each voter gives a rank from highest to lowest to all teams participated in the competition.
 * The ordering of teams is decided by who received the most position-one votes.
 * If two or more teams tie in the first position, we consider the second position to resolve the conflict,
 * if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.
 *
 * Given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.
 * Return a string of all teams sorted by the ranking system.
 *
 * Example 1:
 *
 * Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
 * Output: "ACB"
 * Explanation: Team A was ranked first place by 5 voters. No other team was voted as first place so team A is the first team.
 * Team B was ranked second by 2 voters and was ranked third by 3 voters.
 * Team C was ranked second by 3 voters and was ranked third by 2 voters.
 * As most of the voters ranked C second, team C is the second team and team B is the third.
 *
 *
 * Example 2:
 * Input: votes = ["WXYZ","XYZW"]
 * Output: "XWYZ"
 * Explanation: X is the winner due to tie-breaking rule. X has same votes as W for the first position but X has one vote as second position while W doesn't have any votes as second position.
 *
 *
 * Example 3:
 * Input: votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
 * Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
 * Explanation: Only one voter so his votes are used for the ranking.
 * Example 4:
 *
 * Input: votes = ["BCA","CAB","CBA","ABC","ACB","BAC"]
 * Output: "ABC"
 * Explanation:
 * Team A was ranked first by 2 voters, second by 2 voters and third by 2 voters.
 * Team B was ranked first by 2 voters, second by 2 voters and third by 2 voters.
 * Team C was ranked first by 2 voters, second by 2 voters and third by 2 voters.
 * There is a tie and we rank teams ascending by their IDs.
 * Example 5:
 *
 * Input: votes = ["M","M","M","M"]
 * Output: "M"
 * Explanation: Only team M in the competition so it has the first rank.
 *
 *
 * Constraints:
 *
 * 1 <= votes.length <= 1000
 * 1 <= votes[i].length <= 26
 * votes[i].length == votes[j].length for 0 <= i, j < votes.length.
 * votes[i][j] is an English upper-case letter.
 * All characters of votes[i] are unique.
 * All the characters that occur in votes[0] also occur in votes[j] where 1 <= j < votes.length.
 *
 * **/

public class RankTeamsByVotes {

    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        Map<Character, int[]> teamRanks = new HashMap<>();

        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                char currCh = vote.charAt(i);
                if(!teamRanks.containsKey(currCh)) {
                    teamRanks.put(currCh, new int[n]);
                }
                teamRanks.get(currCh)[i]++;
            }
        }

        // queue is used to store data into sorted order
        PriorityQueue<Character> queue = new PriorityQueue<Character>((a, b) -> compareAndSort(a, b, teamRanks));
        for(Character ch : teamRanks.keySet()) {
            queue.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    private int compareAndSort(Character a, Character b, Map<Character, int[]> teamRanks) {
        int[] listA = teamRanks.get(a);
        int[] listB = teamRanks.get(b);

        for (int i = 0; i < listA.length; i++) {
            if(listA[i] != listB[i]) {
                //maintain descending order i.e. 5 5 4 3 2 1
                return listB[i] - listA[i];
            }
        }

        // Alphabetic order maintain
        return a.compareTo(b);
    }


    public static void main(String[] args) {
        RankTeamsByVotes rankTeamsByVotes = new RankTeamsByVotes();
        System.out.println(rankTeamsByVotes.rankTeams(new String[]{"BCA","CAB","CBA","ABC","ACB","BAC"}));
        System.out.println(rankTeamsByVotes.rankTeams(new String[]{"WXYZ","XYZW"}));
        System.out.println(rankTeamsByVotes.rankTeams(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"}));
        System.out.println(rankTeamsByVotes.rankTeams(new String[]{"BCA","CAB","CBA","ABC","ACB","BAC"}));
        System.out.println(rankTeamsByVotes.rankTeams(new String[]{"M","M","M","M"}));
    }
}
