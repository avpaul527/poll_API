package com.pollsAPI.polls.domain;

import com.pollsAPI.polls.repository.PollRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Vote {


    @Id
    @GeneratedValue
    @Column(name = "VOTE_ID")
    private Long voteId;

    @ManyToOne
    @JoinColumn(name = "CHOICE_ID")
    private Choice vote;


    public Vote() {}


    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long id) {
        this.voteId = voteId;
    }

    public Choice getVote() {
        return vote;
    }

    public void setVote(Choice vote) {
        this.vote = vote;
    }

}
