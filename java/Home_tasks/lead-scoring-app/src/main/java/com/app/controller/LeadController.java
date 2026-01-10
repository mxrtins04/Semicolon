package com.app.controller;

import com.app.entity.Lead;
import com.app.service.LeadService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/leads")
@CrossOrigin(origins = "*")
@Slf4j
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @GetMapping
    public ResponseEntity<List<Lead>> getAllLeads() {
        log.info("GET /api/leads");
        List<Lead> leads = leadService.getAllLeads();
        return ResponseEntity.ok(leads);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable Long id) {
        log.info("GET /api/leads/{}", id);
        Lead lead = leadService.getLeadById(id);
        return ResponseEntity.ok(lead);
    }

    @GetMapping("/score/{minScore}")
    public ResponseEntity<List<Lead>> getLeadsByScore(@PathVariable Integer minScore) {
        log.info("GET /api/leads/score/{}", minScore);
        List<Lead> leads = leadService.getLeadsByMinimumScore(minScore);
        return ResponseEntity.ok(leads);
    }

    @GetMapping("/company/{company}")
    public ResponseEntity<List<Lead>> getLeadsByCompany(@PathVariable String company) {
        log.info("GET /api/leads/company/{}", company);
        List<Lead> leads = leadService.getLeadsByCompany(company);
        return ResponseEntity.ok(leads);
    }

    @PostMapping
    public ResponseEntity<Lead> createLead(@Valid @RequestBody Lead lead) {
        log.info("POST /api/leads - Creating lead: {}", lead.getName());
        Lead createdLead = leadService.createLead(lead);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLead);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lead> updateLead(@PathVariable Long id, @Valid @RequestBody Lead lead) {
        log.info("PUT /api/leads/{} - Updating lead", id);
        Lead updatedLead = leadService.updateLead(id, lead);
        return ResponseEntity.ok(updatedLead);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long id) {
        log.info("DELETE /api/leads/{}", id);
        leadService.deleteLead(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/stats/count")
    public ResponseEntity<Map<String, Integer>> getLeadCount() {
        log.info("GET /api/leads/stats/count");
        Integer count = leadService.getTotalLeadsCount();
        return ResponseEntity.ok(Map.of("totalLeads", count));
    }
}