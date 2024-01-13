package com.springboootex.Demo12.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class VotingController {

    private final Map<String, Integer> candidateVotes = new HashMap<>();

    @PostMapping("/entercandidate")
    public String enterCandidate(@RequestParam String name) {
        candidateVotes.put(name, 0);
        return "Candidate " + name + " entered with 0 votes.";
    }

    @PostMapping("/castvote")
    public String castVote(@RequestParam String name) {
        if (candidateVotes.containsKey(name)) {
            int currentVotes = candidateVotes.get(name);
            candidateVotes.put(name, currentVotes + 1);
            return "Vote cast for candidate " + name + ". Total votes: " + (currentVotes + 1);
        } else {
            return "Invalid candidate.";
        }
    }

    @GetMapping("/countvote")
    public String countVote(@RequestParam String name) {
        if (candidateVotes.containsKey(name)) {
            int currentVotes = candidateVotes.get(name);
            return "Current vote count for candidate " + name + ": " + currentVotes;
        } else {
            return "Invalid candidate.";
        }
    }

    @GetMapping("/listvote")
    public Map<String, Integer> listVotes() {
        return candidateVotes;
    }

    @GetMapping("/getwinner")
    public String getWinner() {
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : candidateVotes.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        if (maxEntry != null) {
            return "Winner: " + maxEntry.getKey() + " with " + maxEntry.getValue() + " votes.";
        } else {
            return "No winner yet.";
        }
    }
}

