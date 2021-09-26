package service;

import java.io.IOException;
import java.util.List;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueState;

import model.IssueEstimationProperties;
import repository.GithubRepository;

public class EstimationService {
    public EstimationService() {
    }

    // TODO estimation properties
    public IssueEstimationProperties estimateProperties(final String owner, final String repo) throws IOException {
        final var githubRepository = new GithubRepository(owner, repo);
        final List<GHIssue> issues = githubRepository.getIssues(GHIssueState.CLOSED);

        final GHIssue issue = issues.stream().filter(i -> {
            try {
                return i.getAssignee() != null;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }).findFirst().orElse(null);
    
        final var IssueEstimationProperties = new IssueEstimationProperties(issue.getLabels(), issue.getClosedAt(), issue.getAssignees());
        return IssueEstimationProperties;
    }
}
