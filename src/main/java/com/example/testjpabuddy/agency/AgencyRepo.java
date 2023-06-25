package com.example.testjpabuddy.agency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepo extends JpaRepository<Agency, Long> {
    Agency getAgencyById(Long id);
}
