package com.app.service;

import com.app.entity.Lead;

public interface ScoringService {
    Lead scoreLead(Lead lead);
    Integer calculateVolumeScore(Double annualVolume);
    Integer calculateExperienceScore(String experience);
    Integer calculateResponseScore(String email, String phone);
}