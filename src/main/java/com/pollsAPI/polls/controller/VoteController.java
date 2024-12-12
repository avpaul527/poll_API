package com.pollsAPI.polls.controller;

import com.pollsAPI.polls.domain.Poll;
import com.pollsAPI.polls.domain.Vote;
import com.pollsAPI.polls.repository.PollRepository;
import com.pollsAPI.polls.repository.VoteRepository;
import com.pollsAPI.polls.service.PollService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class VoteController {


    private final Logger logger = LoggerFactory.getLogger(VoteController.class);

    @Autowired
    PollRepository pollRepository;


    @Autowired
    VoteRepository voteRepository;

    @PostMapping("/polls/{pollId}/votes")
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote){
        vote = voteRepository.save(vote);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{pollId}").buildAndExpand(vote.getVoteId()).toUri());
        logger.info("Added vote successfully for poll (" + pollRepository.findById(pollId).get().getQuestion() + " [id: "+ pollId + "]).");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/polls/{pollId}/votes")
    public Iterable<Vote> getAllVotes(@PathVariable Long pollId){
        logger.info("Responded successfully with all votes for poll (" + pollRepository.findById(pollId).get().getQuestion() + " [id: "+ pollId + "]).");
        return voteRepository.findByPoll(pollId);
    }






}
