package com.evoter.evoterapp.service;

import com.evoter.evoterapp.service.dto.ElectionResult;

public interface CountingService {

	ElectionResult tally(String electionId);

}
