package com.mxr.mfds.model;

public enum FuelType {
    PETROL("Petrol"),
    KEROSENE("Kerosene"),
    DIESEL("Diesel");
    
    private final String displayName;
    
    FuelType(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}