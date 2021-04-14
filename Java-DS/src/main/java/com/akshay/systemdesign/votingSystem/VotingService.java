package com.akshay.systemdesign.votingSystem;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.Executable;
import java.util.*;
import java.util.concurrent.*;

public class VotingService {
    private final Map<String, Set<String>> voteCount;
    private final Set<String> voterList;
    private final Set<String> candidateList;
    private final Set<String> votersVotedList;
    private final ExecutorService voteExecuterService;
    public VotingService(Set<String> voterList, Set<String> candidateList) {
        this.voteCount = new HashMap<>();
        this.votersVotedList = new HashSet<>();
        this.voterList = voterList;
        this.candidateList = candidateList;
        this.voteExecuterService = Executors.newFixedThreadPool(10);
    }

    public boolean doVote(String voter, String candidate) {
        Future<Boolean> booleanCallable = CompletableFuture.supplyAsync(() -> doVoteAction(voter, candidate));
        this.voteExecuterService.submit(() -> booleanCallable);
        try {
            return booleanCallable.get();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    public boolean doVoteAction(String voter, String candidate){
        if(verify(voter, candidate)) {
            if(!voteCount.containsKey(candidate)) {
                voteCount.put(candidate, new HashSet<>());
            }
            voteCount.get(candidate).add(voter);
            votersVotedList.add(voter);
            return true;
        }
        return false;
    }

    private boolean verify(String voter, String candidate) {
        return
                this.candidateList.contains(candidate) &&
                        this.voterList.contains(voter) &&
                        !this.votersVotedList.contains(voter);
    }

    public Set<String> allVoters() {
        return voterList;
    }

    public Set<String> allCandidate() {
        return candidateList;
    }

    public String getWinner() {
        int max = 0;
        String winnerName = null;
        for (Map.Entry<String, Set<String>> voteC :voteCount.entrySet()) {
            if(max < voteC.getValue().size()) {
                max = voteC.getValue().size();
                winnerName = voteC.getKey();
            }
        }
        return winnerName;
    }

    public Set<String> candidateVoters(String canidate) {
        return voteCount.get(canidate);
    }
}
