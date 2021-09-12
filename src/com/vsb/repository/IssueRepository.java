package com.vsb.repository;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class IssueRepository {
    final GithubRepository githubRepository;
    final GHIssue issue;

    public IssueRepository(final GithubRepository githubRepository, final int issueId) throws IOException {
        this.githubRepository = githubRepository;
        this.issue = githubRepository.getIssue(issueId);
    }

    public Collection<GHLabel> getLabels() {
        return issue.getLabels();
    }

    public String getBody() {
        return issue.getBody();
    }

    public Date getClosedAt() {
        return issue.getClosedAt();
    }

    public GHUser getClosedBy() throws IOException {
        return issue.getClosedBy();
    }

    public GHIssueState getState() {
        return issue.getState();
    }

    public List<GHIssueComment> getComments() throws IOException {
        return issue.getComments();
    }
}
