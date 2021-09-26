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
import com.opencsv.CSVReader;

public class RepositoryDataService {
    final  String fileName = "./src/com/vsb/data/repositoriesRaw.csv";

    public String[] writeNewRepository(final RepositoryRaw repositoryRaw) throws IOException {
        String[] line = {
            repositoryRaw.getOwner(),         
            repositoryRaw.getName(), 
            repositoryRaw.getDescription(),
            repositoryRaw.getLanguage(), 
            repositoryRaw.getTopics().toString()};

        CSVWriter writer = new CSVWriter(new FileWriter(fileName, true));
        writer.writeNext(line, true);
        writer.close();

        return line;
    }

    public List<RepositoryRaw> readRepositories() throws IOException, CsvException {
        List<RepositoryRaw> repositories = new ArrayList<RepositoryRaw>();
        
        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
            List<String[]> lines = reader.readAll();
            lines.forEach(line -> {
                RepositoryRaw repositoryRaw = new RepositoryRaw(line[0], line[1], line[2], line[3], Arrays.asList(line[4].split(",")));
                repositories.add(repositoryRaw);
            });
        }

        return repositories;
    }
}
