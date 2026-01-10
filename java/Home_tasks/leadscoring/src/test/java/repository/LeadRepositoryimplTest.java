package repository;

import com.mxr.leadscoring.model.ActionType;
import com.mxr.leadscoring.model.Lead;
import com.mxr.leadscoring.model.Position;
import com.mxr.leadscoring.repository.LeadRepository;
import com.mxr.leadscoring.repository.LeadRepositoryimpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class LeadRepositoryimplTest {
    private LeadRepository repo;
    private Lead lead;

    @BeforeEach
    void setup(){
        repo = new LeadRepositoryimpl();
        lead = new Lead("jjk", "hj@eial.com", Position.STAFF, ActionType.INQUIRY);
    }

    @Test
    void repoIsEmptyByDefault(){
        Lead fetchedLead = repo.getLeadById(lead.getId());
        assertNull(fetchedLead);
    }

    @Test
    void savingLead_whenGivenLead_returnsLead(){
       Lead savedLead = repo.saveLead(lead);
       assertNotNull(savedLead);
    }

    @Test
    void saveLeadShouldReturnSavedLead_whenGivenLeadId(){
        repo.saveLead(lead);
        Lead foundLead = repo.findById(lead.getId());
        assertEquals(lead.getId(), foundLead.getId());
    }

    @Test
    void findByIdShouldReturnNull_forNonExistentId(){
        Lead foundLead = repo.findById(UUID.randomUUID());
        assertNull(foundLead);
    }

    @Test
    void findAllLeads_ShouldReturnAllLeadsInRepo(){
        Lead lead1 = new Lead("jjk", "hj@eial.com", Position.STAFF, ActionType.INQUIRY);
        repo.saveLead(lead1);
        repo.saveLead(lead);
        var allLeads = repo.findAll();
        assertEquals(2, allLeads.size());
        assertTrue(allLeads.contains(lead1));
    }

    @Test
    void givenLeadId_whenDeletedById_leadIsRemovedFromDB(){
        repo.saveLead(lead);
        repo.deleteById(lead.getId());
        Lead foundLead = repo.findById(lead.getId());
        assertNull(foundLead);
    }



}
