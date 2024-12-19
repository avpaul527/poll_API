package com.pollsAPI.polls.controller;


import com.pollsAPI.polls.domain.Poll;
import com.pollsAPI.polls.exception.ResourceNotFoundException;
import com.pollsAPI.polls.repository.PollRepository;
import com.pollsAPI.polls.service.PollService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class PollController {

    private final Logger logger = LoggerFactory.getLogger(PollController.class);

    @Autowired
    PollService pollService;

    @GetMapping("/polls")
    public ResponseEntity<Iterable<Poll>> getPolls(){
        logger.info("Responded successfully with all polls.");
        return new ResponseEntity<>(pollService.getAllPolls(), HttpStatus.OK);
    }

    @PostMapping("/polls")
    public ResponseEntity<?> createPoll(@Valid @RequestBody Poll poll){
        pollService.addPoll(poll);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{pollId}")
                .buildAndExpand(poll.getPollId())
                .toUri();
        responseHeaders.setLocation(newPollUri);

        logger.info("Created new poll successfully (" + poll.getQuestion() + ").");
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/polls/{pollId}")
    public ResponseEntity<?> getPoll(@PathVariable Long pollId){
        verifyPoll(pollId);
        Poll poll = pollService.getPollById(pollId);
        logger.info("Responded successfully with poll (" + poll.getQuestion()  + " [id: " + pollId + "]).");
        return new ResponseEntity<>(poll, HttpStatus.OK);
    }

    @PutMapping("/polls/{pollId}")
    public ResponseEntity<?> editPoll(@PathVariable Long pollId, @RequestBody Poll poll) {
        verifyPoll(pollId);
        logger.info("Poll [id: " + pollId + "] updated successfully.");
        pollService.updatePoll(pollId, poll);
        return new ResponseEntity<>(HttpStatus.OK);
        }

    @DeleteMapping("/polls/{pollId}")
    public ResponseEntity<?> deletePoll(@PathVariable Long pollId){
        verifyPoll(pollId);
        pollService.deletePollById(pollId);
        logger.info("Successfully deleted poll. ");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    protected void verifyPoll(Long pollId) throws ResourceNotFoundException {
        Poll poll = pollService.getPollById(pollId);
        if(poll == null){
            throw new ResourceNotFoundException("Poll with id: " + pollId + " not found.");
        }
    }



}
