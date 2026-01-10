package com.mxr.leadscoring.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Lead {
    private final UUID id;
    private String name;
    private String email;
    private Position position;
    private ActionType actionType;
    private long recency;
    private final LocalDate createdAt;
    private double score;

    public Lead(String name, String email, Position position, ActionType actionType) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.position = position;
        this.actionType = actionType;
        this.createdAt = LocalDate.now();
    }

    public UUID getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName(String name) {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public LocalDate getCreatedAt(){
        return createdAt;
    }

    public void setRecency() {
        LocalDate calledAt = LocalDate.now();
        recency = ChronoUnit.DAYS.between(createdAt, calledAt);
    }

    public long getRecency(){
        setRecency();
        return recency;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}
