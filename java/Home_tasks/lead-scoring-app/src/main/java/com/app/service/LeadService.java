package com.app.service;

import com.app.entity.Lead;
import java.util.List;

public interface LeadService {
    Lead createLead(Lead lead);
    Lead updateLead(Long id, Lead lead);
    Lead getLeadById(Long id);
    List<Lead> getAllLeads();
    List<Lead> getLeadsByMinimumScore(Integer minScore);
    List<Lead> getLeadsByCompany(String company);
    void deleteLead(Long id);
    Integer getTotalLeadsCount();
}