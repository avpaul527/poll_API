package com.pollsAPI.polls.service;


import com.pollsAPI.polls.controller.PollController;
import com.pollsAPI.polls.domain.Choice;
import com.pollsAPI.polls.domain.Poll;
import com.pollsAPI.polls.repository.ChoiceRepository;
import com.pollsAPI.polls.repository.PollRepository;
import com.pollsAPI.polls.repository.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class PollService {

    @Autowired
    PollRepository pollRepository;

    @Autowired
    ChoiceRepository choiceRepository;

    @Autowired
    VoteRepository voteRepository;

    private final Logger logger = LoggerFactory.getLogger(PollService.class);



    //CRUD

     //Poll Services

    //Get (R)
    public Iterable<Poll> getAllPolls(){
        return pollRepository.findAll();
        //getPolls();
    }

    public Poll getPollById(Long pollId){
        for(Poll poll: getAllPolls()){
            if(poll.getPollId().equals(pollId)){
                //logger.info("Responded successfully with poll (" + poll.getQuestion()  + " [id: " + pollId + "]).");

                return poll;
            }
        }
        return null;
        //getPoll();

    }


    //Post (C)
    public void addPoll(Poll poll){
        pollRepository.save(poll);
        //createPoll();
    }


    //Put (U)
    public Poll updatePoll(Long pollId, Poll poll){
            Poll p = pollRepository.findById(pollId).get();
            if(poll.getPollId().equals(pollId)) {
                p.setQuestion(poll.getQuestion());
                p.setChoices(poll.getChoices());
                pollRepository.save(p);
            }

        return poll;
        //editPoll();
    }


    //Delete (D)
    public void deletePollById(Long pollId){
        pollRepository.deleteById(pollId);

        // Poll poll = getPollById(pollId);

//        if(poll.getPollId().equals(pollId)) {
//                pollRepository.delete(poll);
//        }
            //deletePoll();
    }





}
