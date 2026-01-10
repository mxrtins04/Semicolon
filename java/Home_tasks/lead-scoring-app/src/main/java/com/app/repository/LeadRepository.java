package com.app.repository;

import com.app.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

    @Query("SELECT l FROM Lead l ORDER BY l.scoreTotal DESC, l.createdAt DESC")
    List<Lead> findAllOrderedByScore();

    @Query("SELECT l FROM Lead l WHERE l.scoreTotal >= :minScore ORDER BY l.scoreTotal DESC")
    List<Lead> findByMinimumScore(Integer minScore);

    @Query("SELECT l FROM Lead l WHERE LOWER(l.company) = LOWER(:company)")
    List<Lead> findByCompany(String company);
}