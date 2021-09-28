package service;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.RepositoryRaw;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.PagedSearchIterable;

import client.github.GithubClient;

import com.opencsv.CSVReader;

public class IssueDataService {
    final  String fileName = "./src/com/vsb/data/issuesRaw.csv";

    public String[] writeNewIssue(final IssueRaw issueRaw) throws IOException {
        String[] line = {
            repositoryRaw.getOwner(),         
            repositoryRaw.getName(), 
            repositoryRaw.getDescription(),
            repositoryRaw.getLanguage(), 
            repositoryRaw.getTopics().toString(),
            String.valueOf(repositoryRaw.getStars()),
        };

        CSVWriter writer = new CSVWriter(new FileWriter(fileName, true));
        writer.writeNext(line, true);
        writer.close();

        return line;
    }

    // public List<IssueRaw> readIssues() throws IOException, CsvException {
    //     List<IssueRaw> issues = new ArrayList<IssueRaw>();
        
    //     try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
    //         List<String[]> lines = reader.readAll();
    //         lines.forEach(line -> {
    //             IssueRaw issueRaw = new RepositoryRaw(line[0]);
    //             issues.add(issueRaw);
    //         });
    //     }

    //     return issues;
    // }

    public void writeIssue(final int id) throws IOException {
        PagedSearchIterable<GHRepository> theMostStarredRepositories = new GithubClient().searchTheMostStarredRepositories();
        theMostStarredRepositories.forEach(repository -> {
            try {
                writeNewRepository(new IssueRaw());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
