package com.pollsAPI.polls.domain;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.NotFound;
import org.springframework.lang.NonNull;

import java.util.Set;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POLL_ID")
    @NotFound
    private Long pollId;

    @Column(name = "QUESTION")
    @NotEmpty
    private String question;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "POLL_ID")
    @OrderBy
    @Size(min=2, max=6)
    @NotEmpty
    private Set<Choice> choices;


    public Poll() {
    }


    public Long getPollId() {
        return pollId;
    }

    public void setPollId(Long id) {
        this.pollId = pollId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<Choice> getChoices() {
        return choices;
    }

    public void setChoices(Set<Choice> choices) {
        this.choices = choices;
    }


}
