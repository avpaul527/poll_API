package com.pollsAPI.polls.controller;

import com.pollsAPI.polls.dto.ChoiceCount;
import com.pollsAPI.polls.domain.Vote;
import com.pollsAPI.polls.dto.VoteResult;
import com.pollsAPI.polls.repository.PollRepository;
import com.pollsAPI.polls.repository.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ComputeResultsController {

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    PollRepository pollRepository;

    private final Logger logger = LoggerFactory.getLogger(ComputeResultsController.class);



    @GetMapping("/computeresult")
    public ResponseEntity<?> computeResult(@RequestParam Long pollId){
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepository.findByPoll(pollId);

        int totalVotes = 0;
        Map<Long, ChoiceCount> tempMap = new HashMap<Long, ChoiceCount>();
        for(Vote v : allVotes) {
            totalVotes ++;
            ChoiceCount choiceCount = tempMap.get(v.getVoteId());
            if(choiceCount == null) {
                choiceCount = new ChoiceCount();
                choiceCount.setCountId(v.getVoteId());
                tempMap.put(v.getVoteId(), choiceCount);
            }
            choiceCount.setCount(choiceCount.getCount()+1);
        }
        voteResult.setTotalVotes(totalVotes);
        voteResult.setResults(tempMap.values());

        logger.info("Votes calculated successfully.");

        return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);
    }



}
