package com.vsb.api.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class IssueController {

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("test", HttpStatus.OK);
    }
}
