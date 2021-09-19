package api.rest;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dto.IssueEstimationProperties;
import service.EstimationService;

@CrossOrigin
@RestController
@RequestMapping("/issue")
public class IssueController {
    
    @RequestMapping(value = "/estimateProperties/{owner}/{repo}", method = RequestMethod.GET)
    public ResponseEntity<IssueEstimationProperties> issuePropsEstimates(@PathVariable("owner") final String owner, @PathVariable("repo") final String repo) throws IOException {
        final IssueEstimationProperties estimatedProperties = new EstimationService().estimateProperties(owner, repo);
        return new ResponseEntity<IssueEstimationProperties>(estimatedProperties, HttpStatus.OK);
    }
}
