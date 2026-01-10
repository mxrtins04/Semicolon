package com.app.service;

import com.app.entity.Lead;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScoringServiceImpl implements ScoringService {

    @Override
    public Lead scoreLead(Lead lead) {
        log.info("Scoring lead: {}", lead.getName());

        int volumeScore = calculateVolumeScore(lead.getAnnualVolume());
        int experienceScore = calculateExperienceScore(lead.getTradingExperience());
        int responseScore = calculateResponseScore(lead.getEmail(), lead.getPhone());

        lead.setResponseScore(responseScore);
        lead.setEngagementScore(experienceScore);
        lead.setScoreTotal(volumeScore + experienceScore + responseScore);

        log.debug("Lead {} scored: total={}, volume={}, experience={}, response={}",
                lead.getName(), lead.getScoreTotal(), volumeScore, experienceScore, responseScore);

        return lead;
    }

    @Override
    public Integer calculateVolumeScore(Double volume) {
        if (volume == null || volume == 0) {
            return 0;
        }
        if (volume > 1_000_000) {
            return 40;
        }
        if (volume > 500_000) {
            return 30;
        }
        if (volume > 100_000) {
            return 20;
        }
        return 10;
    }

    @Override
    public Integer calculateExperienceScore(String experience) {
        if (experience == null || experience.isBlank()) {
            return 0;
        }

        return switch (experience.toLowerCase().strip()) {
            case "expert" -> 35;
            case "advanced" -> 25;
            case "intermediate" -> 15;
            case "beginner" -> 5;
            default -> 0;
        };
    }

    @Override
    public Integer calculateResponseScore(String email, String phone) {
        int score = 0;
        if (email != null && !email.isBlank()) {
            score += 15;
        }
        if (phone != null && !phone.isBlank()) {
            score += 15;
        }
        return score;
    }
}