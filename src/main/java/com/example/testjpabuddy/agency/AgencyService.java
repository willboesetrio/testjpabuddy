package com.example.testjpabuddy.agency;

import java.util.List;

public interface AgencyService {
    List<Agency> getAllAgencies();
    Agency getAgencyById(Long id);
}
