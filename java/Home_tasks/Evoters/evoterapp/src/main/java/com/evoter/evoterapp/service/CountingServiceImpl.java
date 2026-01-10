package com.evoter.evoterapp.service;

import com.evoter.evoterapp.domain.Vote;
import com.evoter.evoterapp.service.dto.ElectionResult;
import com.evoter.evoterapp.repository.VoteRepository;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CountingServiceImpl implements CountingService {

    private final VoteRepository voteRepository;

    public CountingServiceImpl(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @Override
    public ElectionResult tally(String electionId) {
        List<Vote> votes = voteRepository.findByElectionId(electionId);
        Map<String, Long> counts = votes.stream()
                .collect(Collectors.groupingBy(Vote::getCandidateId, Collectors.counting()));
        // sort by descending count
        LinkedHashMap<String, Long> sorted = counts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (a, b) -> a, LinkedHashMap::new));
        return new ElectionResult(sorted);
    }
}
