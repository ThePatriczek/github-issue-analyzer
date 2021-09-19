package api.rest;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import repository.UserRepository;
import org.kohsuke.github.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    
    @RequestMapping(value = "/getRepositories/{login}", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getRepositories(@PathVariable("login") final String login) throws IOException {
        final Map<String, GHRepository> repositoriesMap = new UserRepository(login).getRepositories();
        
        List<String> repositories = new ArrayList<>();
        repositoriesMap.forEach((k, v) -> {
            repositories.add(k);
        });
        
        return new ResponseEntity<>(repositories, HttpStatus.OK);
    }
}
