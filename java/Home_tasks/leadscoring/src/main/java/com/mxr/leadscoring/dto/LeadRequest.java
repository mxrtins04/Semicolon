package com.mxr.leadscoring.dto;

import com.mxr.leadscoring.model.Position;

import java.util.Objects;

public class LeadRequest {

    private final String name;
    private final String email;
    private final Position position;
    private final String actionTaken;


    public LeadRequest(
            String name,
            String email,
            Position position,
            String actionTaken
    ) {
        this.name = validateRequired(name, "name");
        this.email = validateAndNormalizeEmail(email);
        this.position = Objects.requireNonNull(position, "position must not be null");
        this.actionTaken = validateRequired(actionTaken, "actionTaken");
    }

    private String validateAndNormalizeEmail(String email) {
        Objects.requireNonNull(email, "email must not be null");

        String normalized = email.trim().toLowerCase();
        if (!normalized.contains("@")) {
            throw new IllegalArgumentException("invalid email format");
        }
        return normalized;
    }

    private String validateRequired(String value, String field) {
        Objects.requireNonNull(value, field + " must not be null");
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }
        return value;
    }

    private int validateNonNegative(int value, String field) {
        if (value < 0) {
            throw new IllegalArgumentException(field + " must be >= 0");
        }
        return value;
    }

    private double validateNonNegative(double value, String field) {
        if (value < 0) {
            throw new IllegalArgumentException(field + " must be >= 0");
        }
        return value;
    }

    public String getEmail() {
        return email;
    }

    public Position getPosition() {
        return position;
    }

    public String getCompanySize() {
        return companySize;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public int getDaysSinceLead() {
        return daysSinceLead;
    }

    public double getResponseTimeHours() {
        return responseTimeHours;
    }
}

