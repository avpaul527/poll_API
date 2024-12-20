package com.pollsAPI.polls.repository;

import com.pollsAPI.polls.domain.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<Poll, Long> {

}
