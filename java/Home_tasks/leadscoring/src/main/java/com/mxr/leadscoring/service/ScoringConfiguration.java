package com.mxr.leadscoring.service;
import org.springframework.stereotype.Component;

@Component

public class ScoringConfiguration {
    private final int recencyWeight;
    private final int actionTypeWeight;
    private final int positionWeight;


    public ScoringConfiguration() {
        this.recencyWeight = 15;
        this.actionTypeWeight = 60;
        this.positionWeight = 25;
    }

    public int getRecencyWeight() {
        return recencyWeight;
    }

    public int getActionTypeWeight() {
        return actionTypeWeight;
    }

    public int getPositionWeight() {
        return positionWeight;
    }

}
