package com.akshay.systemdesign.votingSystem;

public class Candidate {
    private String candidateId;
    private String candidateName;

    public Candidate(String candidateId, String candidateName) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateId='" + candidateId + '\'' +
                ", candidateName='" + candidateName + '\'' +
                '}';
    }
}
