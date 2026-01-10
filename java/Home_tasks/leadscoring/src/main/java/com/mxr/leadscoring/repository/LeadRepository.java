package com.mxr.leadscoring.repository;

import com.mxr.leadscoring.model.Lead;

import java.util.UUID;
import java.util.ArrayList;

public interface LeadRepository {
    public Lead getLeadById(UUID Id);
    public Lead saveLead(Lead lead);
    public Lead findById(UUID id);
    public ArrayList<Lead> findAll();
    public void deleteById(UUID id);
}
