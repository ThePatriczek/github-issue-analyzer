package api.rest;

import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import model.RepositoryRaw;
import repository.GithubRepository;
import service.RepositoryDataService;

@CrossOrigin
@RestController
@RequestMapping("/repository")
public class RepositoryController {
    
    @RequestMapping(value = "/write/{owner}/{repo}", method = RequestMethod.POST)
    public ResponseEntity<String[]> writeRepository(@PathVariable("owner") final String owner, @PathVariable("repo") final String repo) throws IOException {
        final GithubRepository repository = new GithubRepository(owner, repo);
        final RepositoryRaw rawRepository = new RepositoryRaw(repository);
        final String[] addedRepository = new RepositoryDataService().writeNewRepository(rawRepository);
        return new ResponseEntity<String[]>(addedRepository, HttpStatus.OK);
    }

        @RequestMapping(value = "/write/TheMostStarredRepositories", method = RequestMethod.POST)
    public ResponseEntity<Boolean> writeTheMostStarredRepositories() throws IOException {
        new RepositoryDataService().writeTheMostStarredRepositories();
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @RequestMapping(value = "/read/all", method = RequestMethod.GET)
    public ResponseEntity<List<RepositoryRaw>> read() throws IOException, CsvException {
        final List<RepositoryRaw> repositories = new RepositoryDataService().readRepositories();
        return new ResponseEntity<List<RepositoryRaw>>(repositories, HttpStatus.OK);
    }
}
