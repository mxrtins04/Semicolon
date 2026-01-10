package com.mxr.leadscoring;

import com.mxr.leadscoring.service.ScoringConfiguration;
import com.mxr.leadscoring.service.ScoringService;
import org.junit.jupiter.api.Test;
import com.mxr.leadscoring.model.*;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


class ScoringServiceTest {
    private ScoringService scoringService;
    private Lead testLead;
    ScoringConfiguration configuration;

    @BeforeEach
    void setup() {
        configuration = new ScoringConfiguration();
        scoringService = new ScoringService(configuration);
        testLead = new Lead("mxr", "mxr@jj.com", Position.OWNER, ActionType.COLD_OUTREACH);
    }

    @Test
    void leadHasA_ScoreUponCreation(){
        double score = scoringService.calculateScore(testLead);
        assertTrue(score >= 0);
    }

    @Test
    void leadWithOWNER_PositionGetsZeroPointNinePoints(){
        Lead lead2 = new Lead("gh","gh@email.com", Position.OWNER, ActionType.INQUIRY);
        double score = scoringService.getPositionScore(lead2);
        assertEquals(0.9, score);
    }

    @Test
    void leadWithMANAGER_PositionGetsZeroPointSevenPoints(){
        Lead lead2 = new Lead("gh","gh@email.com", Position.MANAGER, ActionType.INQUIRY);
        double score = scoringService.getPositionScore(lead2);
        assertEquals(0.7, score);
    }

    @Test
    void leadWithADMIN_PositionGetsZeroPointFourPoints(){
        Lead lead2 = new Lead("gh","gh@email.com", Position.ADMIN, ActionType.INQUIRY);
        double score = scoringService.getPositionScore(lead2);
        assertEquals(0.4, score);
    }

    @Test
    void leadWithSTAFF_PositionGetsZeroPointTwoPoints(){
        Lead lead2 = new Lead("gh","gh@email.com", Position.STAFF, ActionType.INQUIRY);
        double score = scoringService.getPositionScore(lead2);
        assertEquals(0.2, score);
    }

    @Test
    void scoreLead_recencyBetween0And3Days_returns0Point9(){
        Lead lead2 = new Lead("gh","gh@email.com", Position.STAFF, ActionType.INQUIRY);
        long recency = lead2.getRecency();
        double expectedScore = 0.9;
        double actualScore = scoringService.getRecencyScore(lead2);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void scoreLead_actionTypeBookedCall_return0Point9(){
        Lead lead2 = new Lead("gh","gh@email.com", Position.STAFF, ActionType.BOOKED_CALL);
        double expectedScore = 0.9;
        double actualScore = scoringService.getActionTypeScore(lead2);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void scoreLead_actionTypeInquiry_return0Point7() {
            Lead lead2 = new Lead("gh","gh@email.com", Position.STAFF, ActionType.INQUIRY);
        double expectedScore = 0.7;
        double actualScore = scoringService.getActionTypeScore(lead2);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void scoreLead_actionTypeReferral_return0Point6() {
            Lead lead2 = new Lead("gh","gh@email.com", Position.STAFF, ActionType.REFERRAL);
        double expectedScore = 0.6;
        double actualScore = scoringService.getActionTypeScore(lead2);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void scoreLead_actionTypeResponse_return0Point5() {
        Lead lead2 = new Lead("gh","gh@email.com", Position.STAFF, ActionType.RESPONSE);
        double expectedScore = 0.5;
        double actualScore = scoringService.getActionTypeScore(lead2);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void scoreLead_actionTypeColdOutreach_return0Point1() {
        Lead lead2 = new Lead("gh","gh@email.com", Position.STAFF, ActionType.COLD_OUTREACH);
        double expectedScore = 0.1;
        double actualScore = scoringService.getActionTypeScore(lead2);
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void scoreConfiguration_actionType_hasAWeight(){
        Lead lead2 = new Lead("jjk", "hj@eial.com", Position.STAFF, ActionType.INQUIRY);
        int weight = configuration.getActionTypeWeight();
        assertEquals(60, weight);
    }

    @Test
    void scoreConfiguration_Position_hasAWeight(){
        Lead lead2 = new Lead("jjk", "hj@eial.com", Position.STAFF, ActionType.INQUIRY);
        int weight = configuration.getPositionWeight();
        assertEquals(25, weight);
    }

    @Test
    void scoreConfiguration_Recency_hasAWeight(){
        Lead lead2 = new Lead("jjk", "hj@eial.com", Position.STAFF, ActionType.INQUIRY);
        int weight = configuration.getRecencyWeight();
        assertEquals(15, weight);
    }

    @Test
    void scoreLead_Position_returnsCorrectWeightedScore(){
        Lead lead2 = new Lead("jjk", "hj@eial.com", Position.STAFF, ActionType.INQUIRY);
        double weightedPositionScore = scoringService.getPositionWeightedScore(lead2);
        assertEquals(5.0, weightedPositionScore);
    }

    @Test
    void scoreLead_Recency_returnsCorrectWeightedScore(){
        Lead lead2 = new  Lead("jjk", "hj@eial.com", Position.STAFF, ActionType.INQUIRY);
        double weightedRecencyScore = scoringService.getWeightedRecencyScore(lead2);
        assertEquals(13.5, weightedRecencyScore);
    }

    @Test
    void scoreLead_ActionType_returnsCorrectWeightedScore(){
        Lead lead2 = new  Lead("jjk", "hj@eial.com", Position.STAFF, ActionType.INQUIRY);
        double weightedActionTypeScore = scoringService.getWeightedActionTypeScore(lead2);
        assertEquals(42.0, weightedActionTypeScore);
    }

    @Test
    void shouldReturnCorrectScore_whenScoringLead(){
        Lead lead2 = new  Lead("jjk", "hj@eial.com", Position.STAFF, ActionType.INQUIRY);
        double leadScore = scoringService.calculateScore(lead2);
        assertEquals(60.5, leadScore);

    }
}
