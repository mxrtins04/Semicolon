package com.mxr.leadscoring.service;


import com.mxr.leadscoring.model.ActionType;
import com.mxr.leadscoring.model.Lead;
import com.mxr.leadscoring.model.Position;
import org.springframework.stereotype.Service;

@Service
public class ScoringService {
        private final ScoringConfiguration configuration;

        public ScoringService(ScoringConfiguration configuration) {
            this.configuration = configuration;
        }


    public double calculateScore(Lead testLead) {
        return getWeightedRecencyScore(testLead) + getWeightedActionTypeScore(testLead) +
                getPositionWeightedScore(testLead);
    }

    public double getRecencyScore(Lead testLead){
        long recency = testLead.getRecency();
        double recencyScore = 0;
        if( 0 <= recency && recency <= 3)
            recencyScore += 0.9;
        if( recency >= 4 && recency <= 7)
            recencyScore = 0.7;
        if( recency >= 8 && recency <= 10)
            recencyScore = 0.4;
        if( recency > 10)
            recencyScore = 0.1;

        return recencyScore;
    }

    public double getWeightedRecencyScore(Lead testLead){
        double recencyScore = getRecencyScore(testLead);
        return recencyScore * configuration.getRecencyWeight();
    }

    public double getActionTypeScore(Lead testLead) {
        ActionType actionType = testLead.getActionType();
        double actionTypeScore = 0;
        if( actionType == ActionType.BOOKED_CALL)
            actionTypeScore = 0.9;
        if( actionType == ActionType.INQUIRY)
            actionTypeScore = 0.7;
        if( actionType == ActionType.REFERRAL)
            actionTypeScore = 0.6;
        if( actionType == ActionType.RESPONSE)
            actionTypeScore = 0.5;
        if( actionType == ActionType.COLD_OUTREACH) actionTypeScore = 0.1;

        return actionTypeScore;
    }

    public double getWeightedActionTypeScore(Lead testLead){
        double actionTypeScore = getActionTypeScore(testLead);
        return actionTypeScore * configuration.getActionTypeWeight();
    }

    public double getPositionScore(Lead testLead){
        Position position = testLead.getPosition();
        double positionScore = 0;
        if( position == Position.OWNER) positionScore = 0.9;

        if( position == Position.MANAGER) positionScore = 0.7;

        if( position == Position.ADMIN) positionScore = 0.4;

        if( position == Position.STAFF) positionScore = 0.2;

        return positionScore;
    }

    public double getPositionWeightedScore(Lead testLead){
            double positionScore = getPositionScore(testLead);
            return positionScore * configuration.getPositionWeight();
    }


}

