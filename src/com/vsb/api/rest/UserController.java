package api.rest;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import model.Repository;
import model.User;
import service.UserService;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    
    @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<List<User>> search(@RequestParam("query") final String query) throws IOException {
            List<User> users = new UserService().search(query);
            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/getRepositories/{login}", method = RequestMethod.GET)
    public ResponseEntity<List<Repository>> getRepositories(@PathVariable("login") final String login) throws IOException {
        List<Repository> repositories = new UserService().getRepositories(login);
        return new ResponseEntity<List<Repository>>(repositories, HttpStatus.OK);
    }

}
