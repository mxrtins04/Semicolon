package com.evoter.evoterapp.cli;

import com.evoter.evoterapp.service.CountingService;
import com.evoter.evoterapp.service.ElectionAdminService;
import com.evoter.evoterapp.service.VotingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "evoter.cli.enabled", havingValue = "true", matchIfMissing = false)
public class SpringCliRunner implements CommandLineRunner {

    private final VotingService votingService;
    private final CountingService countingService;
    private final ElectionAdminService adminService;

    public SpringCliRunner(VotingService votingService, CountingService countingService, ElectionAdminService adminService) {
        this.votingService = votingService;
        this.countingService = countingService;
        this.adminService = adminService;
    }

    @Override
    public void run(String... args) throws Exception {
        EvoterCli cli = new EvoterCli(votingService, countingService, adminService, System.in, System.out);
        cli.run();
    }
}
