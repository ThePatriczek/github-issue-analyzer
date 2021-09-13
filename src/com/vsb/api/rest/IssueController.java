package api.rest;

import org.kohsuke.github.GHIssue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class IssueController {
    
    @RequestMapping(value = "/issues/{id}", method = RequestMethod.GET)
    public ResponseEntity<GHIssue> getIssue(@PathVariable("id") String id) {
        return new ResponseEntity<GHIssue>(new GHIssue(), HttpStatus.OK);
    }

    @RequestMapping(value = "/issues", method = RequestMethod.POST)
    public ResponseEntity<GHIssue> createIssue(@RequestBody GHIssue issue) {
        return new ResponseEntity<GHIssue>(new GHIssue(), HttpStatus.OK);
    }

    @RequestMapping(value = "/issues/{id}", method = RequestMethod.PUT)
    public ResponseEntity<GHIssue> updateIssue(@PathVariable("id") String id, @RequestBody GHIssue issue) {
        return new ResponseEntity<GHIssue>(new GHIssue(), HttpStatus.OK);
    }

    @RequestMapping(value = "/issues/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<GHIssue> deleteIssue(@PathVariable("id") String id) {
        return new ResponseEntity<GHIssue>(new GHIssue(), HttpStatus.OK);
    }
}
