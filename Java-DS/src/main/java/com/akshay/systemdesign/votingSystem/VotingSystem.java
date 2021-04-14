package com.akshay.systemdesign.votingSystem;

import java.util.HashSet;
import java.util.Set;

public class VotingSystem {

    public static void main(String[] args) {
        VotingService votingService = new VotingService(voterList(), candidateList());
        System.out.println(votingService.doVote("Akshay001", "BJP"));
        System.out.println(votingService.doVote("Ram001", "SBP"));
        System.out.println(votingService.doVote("IonDeck001", "ABC"));
        System.out.println(votingService.doVote("Suresh001", "BJP"));
        System.out.println(votingService.doVote("IonDeck001", "ABC"));
        System.out.println(votingService.doVote("Suresh001", "BJP"));


        int i = 0;
        while (i <  5) {
            System.out.println(votingService.doVote("Akshay001" + i, "BJP"));
            System.out.println(votingService.doVote("Ram001" + i, "SBP"));
            System.out.println(votingService.doVote("IonDeck001" + i, "ABC"));
            System.out.println(votingService.doVote("Suresh001" + i, "BJP"));
            System.out.println(votingService.doVote("IonDeck001" + i, "ABC"));
            System.out.println(votingService.doVote("Suresh001" + i, "BJP"));
            i++;
        }


        System.out.println(votingService.getWinner());
        System.out.println(votingService.candidateVoters(votingService.getWinner()));
        System.out.println(votingService.allCandidate());
        System.out.println(votingService.allVoters());
    }

    private static Set<String> voterList() {
        Set<String> voterList = new HashSet<>();
        voterList.add("Akshay001");
        voterList.add("Ram001");
        voterList.add("IonDeck001");
        voterList.add("Suresh001");
        voterList.add("Ravi001");
        return voterList;
    }

    private static Set<String> candidateList() {
        Set<String> candidateList = new HashSet<>();
        candidateList.add("BJP");
        candidateList.add("SBP");
        candidateList.add("ABC");
        candidateList.add("LSP");
        candidateList.add("CONG");
        return candidateList;
    }

}
