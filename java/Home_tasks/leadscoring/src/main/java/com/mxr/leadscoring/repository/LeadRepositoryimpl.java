package com.mxr.leadscoring.repository;

import com.mxr.leadscoring.model.Lead;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public class LeadRepositoryimpl implements  LeadRepository{
    private final ArrayList<Lead> storage = new ArrayList<>();
    @Override
    public Lead getLeadById(UUID Id) {
        return null;
    }

    @Override
    public Lead saveLead(Lead lead) {
        storage.add(lead);
        return lead;
    }

    @Override
    public Lead findById(UUID id) {
        for( Lead lead : storage) {
            if (lead.getId().equals(id))
                return lead;
        }
        return null;
    }

    @Override
    public ArrayList<Lead> findAll() {
        return storage;
    }

    @Override
    public void deleteById(UUID id) {
        storage.removeIf(lead -> lead.getId().equals(id));
    }


}
